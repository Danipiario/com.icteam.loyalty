package com.icteam.loyalty.common.api.nls;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.metatype.AttributeDefinition;
import org.osgi.service.metatype.MetaTypeInformation;
import org.osgi.service.metatype.MetaTypeService;
import org.osgi.service.metatype.ObjectClassDefinition;
import org.osgi.util.tracker.ServiceTracker;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Configurable<T> {
	public static Pattern SPLITTER_P = Pattern.compile("(?<!\\\\)\\|");

	public static <T> T createConfigurable(Class<T> c, Map<?, ?> properties) {
		final Object o = Proxy.newProxyInstance(c.getClassLoader(), new Class<?>[] { c },
				new ConfigurableHandler<>(properties, c));
		return c.cast(o);
	}

	public static <T> T createConfigurable(Class<T> c, Dictionary<?, ?> properties) {
		final Map<Object, Object> alt = new HashMap<>();
		for (final Enumeration<?> e = properties.keys(); e.hasMoreElements();) {
			final Object key = e.nextElement();
			alt.put(key, properties.get(key));
		}
		return createConfigurable(c, alt);
	}

	static class ConfigurableHandler<T> implements InvocationHandler {
		final Map<?, ?> properties;
		private final Class<T> clazz;

		private final Map<Method, Object> values = new HashMap<>();

		ConfigurableHandler(Map<?, ?> properties, Class<T> clazz) {
			this.properties = properties;
			this.clazz = clazz;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Object o = values.get(method);

			if (o == null) {
				final Bundle bundle = FrameworkUtil.getBundle(clazz);
				final ServiceTracker<MetaTypeService, MetaTypeService> serviceTracker = new ServiceTracker<>(
						bundle.getBundleContext(), MetaTypeService.class, null);
				serviceTracker.open();
				final MetaTypeService metaTypeService = serviceTracker.waitForService(10000);

				if (metaTypeService == null) {
					return null;
				}

				final MetaTypeInformation metaTypeInformation = metaTypeService.getMetaTypeInformation(bundle);
				final ObjectClassDefinition objectClassDefinition = metaTypeInformation
						.getObjectClassDefinition(clazz.getPackage().getName(), null);

				final AttributeDefinition[] attributeDefinitions = objectClassDefinition
						.getAttributeDefinitions(ObjectClassDefinition.ALL);

				for (final AttributeDefinition attributeDefinition : attributeDefinitions) {
					final String name = attributeDefinition.getID();

					if (name.equals(method.getName())) {
						o = properties.get(name);

						if (o == null) {
							o = attributeDefinition.getDefaultValue();

							if (o.equals(new String[] {})) {
								o = null;
							}

							if (attributeDefinition.getCardinality() == 0) {
								if (o == null) {
									throw new IllegalStateException(
											"Attribute is required but not set " + method.getName());
								}

								o = Array.get(o, 0);
							}
						}

						if (o == null) {
							final Class<?> rt = method.getReturnType();

							if (rt == boolean.class) {
								o = false;
							} else {
								if (method.getReturnType().isPrimitive()) {
									o = "0";
								} else {
									return null;
								}
							}
						}

						if (o != null) {
							o = convert(method.getGenericReturnType(), o);
						}

						break;
					}
				}

				if (o != null) {
					values.put(method, o);
				}
			}

			return o;
		}

		public Object convert(Type type, Object o) throws Exception {
			if (type instanceof ParameterizedType) {
				final ParameterizedType pType = (ParameterizedType) type;
				return convert(pType, o);
			}

			if (type instanceof GenericArrayType) {
				final GenericArrayType gType = (GenericArrayType) type;
				return convertArray(gType.getGenericComponentType(), o);
			}

			Class<?> resultType = (Class<?>) type;

			if (resultType.isArray()) {
				return convertArray(resultType.getComponentType(), o);
			}

			final Class<?> actualType = o.getClass();
			if (actualType.isAssignableFrom(resultType)) {
				return o;
			}

			if (resultType == boolean.class || resultType == Boolean.class) {
				if (actualType == boolean.class || actualType == Boolean.class) {
					return o;
				}

				if (Number.class.isAssignableFrom(actualType)) {
					final double b = ((Number) o).doubleValue();
					if (b == 0) {
						return false;
					}
					return true;
				}
				if (o instanceof String) {
					return Boolean.parseBoolean((String) o);
				}
				return true;

			} else if (resultType == byte.class || resultType == Byte.class) {
				if (Number.class.isAssignableFrom(actualType)) {
					return ((Number) o).byteValue();
				}
				resultType = Byte.class;
			} else if (resultType == char.class) {
				resultType = Character.class;
			} else if (resultType == short.class) {
				if (Number.class.isAssignableFrom(actualType)) {
					return ((Number) o).shortValue();
				}
				resultType = Short.class;
			} else if (resultType == int.class) {
				if (Number.class.isAssignableFrom(actualType)) {
					return ((Number) o).intValue();
				}
				resultType = Integer.class;
			} else if (resultType == long.class) {
				if (Number.class.isAssignableFrom(actualType)) {
					return ((Number) o).longValue();
				}
				resultType = Long.class;
			} else if (resultType == float.class) {
				if (Number.class.isAssignableFrom(actualType)) {
					return ((Number) o).floatValue();
				}
				resultType = Float.class;
			} else if (resultType == double.class) {
				if (Number.class.isAssignableFrom(actualType)) {
					return ((Number) o).doubleValue();
				}
				resultType = Double.class;
			}

			if (resultType.isPrimitive()) {
				throw new IllegalArgumentException("Unknown primitive: " + resultType);
			}

			if (Number.class.isAssignableFrom(resultType) && actualType == Boolean.class) {
				final Boolean b = (Boolean) o;
				o = b ? "1" : "0";
			} else if (actualType == String.class) {
				final String input = (String) o;
				if (Enum.class.isAssignableFrom(resultType)) {
					return Enum.valueOf((Class<Enum>) resultType, input);
				}
				if (resultType == Class.class) {
					return clazz.getClassLoader().loadClass(input);
				}
				if (resultType == Pattern.class) {
					return Pattern.compile(input);
				}
			}

			try {
				final Constructor<?> c = resultType.getConstructor(String.class);
				return c.newInstance(o.toString());
			} catch (final Throwable t) {
				// handled on next line
			}
			throw new IllegalArgumentException(
					"No conversion to " + resultType + " from " + actualType + " value " + o);
		}

		private Object convert(ParameterizedType pType, Object o)
				throws InstantiationException, IllegalAccessException, Exception {
			Class<?> resultType = (Class<?>) pType.getRawType();
			if (Collection.class.isAssignableFrom(resultType)) {
				final Collection<?> input = toCollection(o);
				if (resultType.isInterface()) {
					if (resultType == Collection.class || resultType == List.class) {
						resultType = ArrayList.class;
					} else if (resultType == Set.class || resultType == SortedSet.class) {
						resultType = TreeSet.class;
					} else if (resultType == Queue.class /*
					 * || resultType ==
					 * Deque.class
					 */) {
						resultType = LinkedList.class;
					} else if (resultType == Queue.class /*
					 * || resultType ==
					 * Deque.class
					 */) {
						resultType = LinkedList.class;
					} else {
						throw new IllegalArgumentException(
								"Unknown interface for a collection, no concrete class found: " + resultType);
					}
				}

				final Collection<Object> result = (Collection<Object>) resultType.newInstance();
				final Type componentType = pType.getActualTypeArguments()[0];

				for (final Object i : input) {
					result.add(convert(componentType, i));
				}
				return result;
			} else if (pType.getRawType() == Class.class) {
				return clazz.getClassLoader().loadClass(o.toString());
			}
			if (Map.class.isAssignableFrom(resultType)) {
				final Map<?, ?> input = toMap(o);
				if (resultType.isInterface()) {
					if (resultType == SortedMap.class) {
						resultType = TreeMap.class;
					} else if (resultType == Map.class) {
						resultType = LinkedHashMap.class;
					} else {
						throw new IllegalArgumentException(
								"Unknown interface for a collection, no concrete class found: " + resultType);
					}
				}
				final Map<Object, Object> result = (Map<Object, Object>) resultType.newInstance();
				final Type keyType = pType.getActualTypeArguments()[0];
				final Type valueType = pType.getActualTypeArguments()[1];

				for (final Map.Entry<?, ?> entry : input.entrySet()) {
					result.put(convert(keyType, entry.getKey()), convert(valueType, entry.getValue()));
				}
				return result;
			}
			throw new IllegalArgumentException(
					"cannot convert to " + pType + " because it uses generics and is not a Collection or a map");
		}

		Object convertArray(Type componentType, Object o) throws Exception {
			if (o instanceof String) {
				final String s = (String) o;
				if (componentType == Byte.class || componentType == byte.class) {
					return s.getBytes("UTF-8");
				}
				if (componentType == Character.class || componentType == char.class) {
					return s.toCharArray();
				}
			}
			final Collection<?> input = toCollection(o);
			final Class<?> componentClass = getRawClass(componentType);
			final Object array = Array.newInstance(componentClass, input.size());

			int i = 0;
			for (final Object next : input) {
				Array.set(array, i++, convert(componentType, next));
			}
			return array;
		}

		private Class<?> getRawClass(Type type) {
			if (type instanceof Class) {
				return (Class<?>) type;
			}

			if (type instanceof ParameterizedType) {
				return (Class<?>) ((ParameterizedType) type).getRawType();
			}

			throw new IllegalArgumentException(
					"For the raw type, type must be ParamaterizedType or Class but is " + type);
		}

		private Collection<?> toCollection(Object o) {
			if (o instanceof Collection) {
				return (Collection<?>) o;
			}

			if (o.getClass().isArray()) {
				if (o.getClass().getComponentType().isPrimitive()) {
					final int length = Array.getLength(o);
					final List<Object> result = new ArrayList<>(length);
					for (int i = 0; i < length; i++) {
						result.add(Array.get(o, i));
					}
					return result;
				}
				return Arrays.asList((Object[]) o);
			}

			if (o instanceof String) {
				final String s = (String) o;
				if (SPLITTER_P.matcher(s).find()) {
					return Arrays.asList(s.split("\\|"));
				} else {
					return unescape(s);
				}

			}
			return Arrays.asList(o);
		}

		private Map<?, ?> toMap(Object o) {
			if (o instanceof Map) {
				return (Map<?, ?>) o;
			}

			throw new IllegalArgumentException("Cannot convert " + o + " to a map as requested");
		}

	}

	public static String mangleMethodName(String id) {
		final StringBuilder sb = new StringBuilder(id);
		for (int i = 0; i < sb.length(); i++) {
			final char c = sb.charAt(i);
			final boolean twice = i < sb.length() - 1 && sb.charAt(i + 1) == c;
			if (c == '$' || c == '_') {
				if (twice) {
					sb.deleteCharAt(i + 1);
				} else if (c == '$') {
					sb.deleteCharAt(i--); // Remove dollars
				} else {
					sb.setCharAt(i, '.'); // Make _ into .
				}
			}
		}
		return sb.toString();
	}

	public static List<String> unescape(String s) {
		// do it the OSGi way
		final List<String> tokens = new ArrayList<>();

		final String[] parts = s.split("(?<!\\\\),");

		for (String p : parts) {
			p = p.replaceAll("^\\s*", "");
			p = p.replaceAll("(?!<\\\\)\\s*$", "");
			p = p.replaceAll("\\\\([\\s,\\\\|])", "$1");
			tokens.add(p);
		}
		return tokens;
	}

}
