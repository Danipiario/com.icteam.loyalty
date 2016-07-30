package com.icteam.loyalty.common.dto;

import com.querydsl.sql.RelationalPathBase;

public abstract class AbstractModelDTO<M extends RelationalPathBase<M>> extends AbstractDTO<M> implements IModelDTO<M> {

	private static final long serialVersionUID = -5518989305089483914L;

}