package com.icteam.loyalty.common.dto;

import java.security.Principal;
import java.util.List;

import org.osgi.dto.DTO;

public class OperatorDTO extends DTO implements Principal {

	public String login;

	public String name;

	public String surname;

	public Boolean changePassword;

	public List<GroupDTO> groups;

	@Override
	public String getName() {
		return name;
	}

}
