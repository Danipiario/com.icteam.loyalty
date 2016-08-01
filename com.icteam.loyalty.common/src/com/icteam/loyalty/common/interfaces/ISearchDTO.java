package com.icteam.loyalty.common.interfaces;

import com.icteam.loyalty.common.dto.IDTO;
import com.querydsl.sql.RelationalPathBase;

public interface ISearchDTO<M extends RelationalPathBase<M>> extends IDTO<M> {

	void setRawFilter(String rawFilter);

}
