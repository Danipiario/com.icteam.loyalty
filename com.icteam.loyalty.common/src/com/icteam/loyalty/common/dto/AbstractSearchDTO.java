package com.icteam.loyalty.common.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.icteam.loyalty.common.interfaces.ISearchDTO;
import com.querydsl.sql.RelationalPathBase;

public class AbstractSearchDTO<M extends RelationalPathBase<M>> extends AbstractDTO<M> implements ISearchDTO<M> {

	private String[] dynamicFilters;

	private final List<String> dynamicFilterProperties = new ArrayList<>();

	@Override
	public void setRawFilter(String rawFilter) {
		this.dynamicFilters = StringUtils.stripAll(StringUtils.split(rawFilter));
	}

}
