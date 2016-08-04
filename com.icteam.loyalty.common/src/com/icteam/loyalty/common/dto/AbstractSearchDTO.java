package com.icteam.loyalty.common.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.icteam.loyalty.common.interfaces.ISearchDTO;

public abstract class AbstractSearchDTO extends AbstractDTO implements ISearchDTO {

	private static final long serialVersionUID = 3476747311923453173L;

	private String[] dynamicFilters;

	private final List<String> dynamicFilterProperties = new ArrayList<>();

	@Override
	public void setRawFilter(String rawFilter) {
		this.dynamicFilters = StringUtils.stripAll(StringUtils.split(rawFilter));
	}

}
