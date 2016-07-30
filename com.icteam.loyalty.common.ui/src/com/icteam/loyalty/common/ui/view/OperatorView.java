package com.icteam.loyalty.common.ui.view;

import java.util.List;

import javax.inject.Inject;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorSearchDTO;
import com.icteam.loyalty.common.service.AuthService;

public class OperatorView extends VirtualView<OperatorDTO, OperatorSearchDTO> {

	@Inject
	private AuthService authService;

	@Override
	public List<OperatorDTO> search() {
		return authService.search(getSearchDTO());
	}

	@Override
	public long count() {
		return authService.count(getSearchDTO());
	}

}