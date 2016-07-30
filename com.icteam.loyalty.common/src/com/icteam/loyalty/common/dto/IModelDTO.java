package com.icteam.loyalty.common.dto;

import com.querydsl.core.Tuple;
import com.querydsl.sql.RelationalPathBase;

public interface IModelDTO<M extends RelationalPathBase<M>> extends IDTO<M> {

	void fill(Tuple tuple, M model);
}
