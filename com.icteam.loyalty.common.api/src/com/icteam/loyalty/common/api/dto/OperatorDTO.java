package com.icteam.loyalty.common.dto;

import java.util.List;

import org.osgi.dto.DTO;

public class OperatorDTO extends DTO {

    public String login;

    public String name;

    public String surname;

    public Boolean changePassword;

    public List<OperatorGroupDTO> operatorGroups;
}
