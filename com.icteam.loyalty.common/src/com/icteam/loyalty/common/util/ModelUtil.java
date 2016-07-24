package com.icteam.loyalty.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.time.DateUtils;

import com.icteam.loyalty.common.annotations.Property;
import com.icteam.loyalty.common.interfaces.IPrioritized;

public class ModelUtil {

	public static Comparator<Field> propertyFieldComparator = (f1, f2) -> {
		final Property property1 = f1.getAnnotation(Property.class);
		final Property property2 = f2.getAnnotation(Property.class);

		final int o1 = property1.order();
		final int o2 = property2.order();

		int c = o1 - o2;

		if (c == 0) {
			c = f1.getName().compareTo(f2.getName());
		}

		return c;
	};

	public static <P extends IPrioritized> List<P> filter(List<P> prioritizeds) {
		if (prioritizeds == null || prioritizeds.isEmpty()) {
			return prioritizeds;
		}

		final List<P> out = new ArrayList<>(prioritizeds);
		for (final P prioritized : prioritizeds) {
			final Set<P> minors = prioritized.getPrioritiesMinor();
			for (final P minor : minors) {
				out.remove(minor);
			}
		}

		return out;
	}

	public static Optional<Date> truncate(Date date) {
		return Optional.ofNullable(date == null ? null : DateUtils.truncate(date, Calendar.DAY_OF_MONTH));
	}

	public static String[] collectPropertyNames(Class<?> clazz) {
		final SortedSet<Field> propertyFields = new TreeSet<>(propertyFieldComparator);

		collectPropertyNames(clazz, propertyFields);

		return propertyFields.stream().map(f -> f.getName()).collect(Collectors.toList()).toArray(new String[] {});
	}

	public static void collectPropertyNames(Class<?> clazz, final SortedSet<Field> propertyFields) {
		if (clazz.equals(Object.class)) {
			return;
		}

		Stream.of(clazz.getDeclaredFields()).filter(f -> f.isAnnotationPresent(Property.class)).forEach(f -> {
			final Property property = f.getAnnotation(Property.class);
			if (property.show() || property.order() != Integer.MAX_VALUE) {
				propertyFields.add(f);
			}
		});

		collectPropertyNames(clazz.getSuperclass(), propertyFields);
	}

}
