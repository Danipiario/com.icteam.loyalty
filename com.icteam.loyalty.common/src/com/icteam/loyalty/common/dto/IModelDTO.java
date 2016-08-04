package com.icteam.loyalty.common.dto;

import java.util.Optional;

import com.querydsl.core.Tuple;
import com.querydsl.sql.RelationalPathBase;

public interface IModelDTO<M extends RelationalPathBase<M>> extends IDTO {

	void fill(Tuple tuple, M model);

	String getValueID();

	String getEditorInstanceID();

	String getEditorID();

	Optional<M> newModelInstance();

	Optional<Class<M>> getModelClass();

}
