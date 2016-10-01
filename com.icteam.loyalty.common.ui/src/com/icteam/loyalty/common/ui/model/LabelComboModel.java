package com.icteam.loyalty.common.ui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.collections.ListUtils;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.interfaces.IEnum;
import com.icteam.loyalty.common.nls.NLS;
import com.icteam.loyalty.common.service.EnumService;

public class LabelComboModel<D extends IDTO, S extends Serializable> extends LabelModel<D, S> {

	private static final long serialVersionUID = -389856560005584245L;

	@Inject
	private EnumService enumService;

	private List<String> values;
	private final Map<String, S> valueMap = new HashMap<>();

	private List<S> srcValues;
	private List<S> customValues;
	private boolean minus;

	public LabelComboModel(D model, String property) {
		this(model, property, null, false);
	}

	public LabelComboModel(D model, String property, List<S> customValues, boolean minus) {
		this(model, property, null, customValues, minus);
	}

	public LabelComboModel(D model, String property, List<S> srcValues, List<S> customValues, boolean minus) {
		super(model, property);

		this.srcValues = srcValues;
		this.customValues = customValues;
		this.minus = minus;
	}

	@Override
	@PostConstruct
	public void initialize() {
		super.initialize();

		List<S> vs = srcValues;

		if (srcValues == null) {
			final Class<S> nestedPropertyClass = getNestedPropertyClass();

			if (!IEnum.class.isAssignableFrom(nestedPropertyClass)) {
				if (customValues == null || minus) {
					throw new IllegalArgumentException(
							"nestedPropertyClass must be an instance of IEnum if srcValues and customValues is null or minus is true");
				}
			} else {
				vs = (List<S>) enumService.values((Class<? extends IEnum>) nestedPropertyClass);
			}
		}

		if (customValues != null) {
			if (minus) {
				vs = ListUtils.subtract(vs, customValues);
			} else {
				vs = customValues;
			}
		}

		for (final S v : vs) {
			// if (ISelectable.class.isAssignableFrom(v.getClass())) {
			valueMap.put(NLS.get(v.getClass(), v.toString()), v);
			// } else {
			// valueMap.put(v.toString(), v);
			// }
		}

		this.values = new ArrayList<>(valueMap.keySet());
	}

	public List<String> getValues() {
		return values;
	}

	public Map<String, S> getValueMap() {
		return valueMap;
	}

}
