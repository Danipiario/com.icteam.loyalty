package com.icteam.loyalty.common.dto;

import java.io.Serializable;
import java.util.Optional;

import com.querydsl.sql.RelationalPathBase;

public interface IDTO<M extends RelationalPathBase<M>> extends Serializable {

	boolean isDirty();

	boolean is_new();

	Optional<M> newModelInstance();

	void enableTrackChanges();
}