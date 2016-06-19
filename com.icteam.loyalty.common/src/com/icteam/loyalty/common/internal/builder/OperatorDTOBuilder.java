package com.icteam.loyalty.common.internal.builder;

import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.model.Operator;
import com.icteam.loyalty.common.service.DTOBuilder;

@Component(property = { DTOBuilder.PROPERTY_DTO_CLASS_NAME + "=OperatorDTO",
		DTOBuilder.PROPERTY_OBJECT_CLASS_NAME + "=Operator" })
public class OperatorDTOBuilder implements DTOBuilder<OperatorDTO, Operator> {

	@Override
	public OperatorDTO buildDTO(Operator operator) {
		final OperatorDTO operatorDTO = new OperatorDTO();

		//		operatorDTO.login = operator.getLogin();
		//		operatorDTO.name = operator.getName();
		//		operatorDTO.surname = operator.getSurname();
		//		operatorDTO.changePassword = operator.getChangePassword();
		//
		//		final String[] groups = StringUtils.split(StringUtils.defaultString(operator.getGroups()), ",");
		//		operatorDTO.groups = (List<GroupDTO>) Arrays.asList(groups).stream().map(group -> {
		//			final GroupDTO groupDTO = new GroupDTO();
		//			groupDTO.group = group;
		//
		//			return groupDTO;
		//		});

		return operatorDTO;
	}

	@Override
	public Operator buildObject(OperatorDTO operatorDTO) {
		final Operator operator = new Operator("");

		//		operator.setChangePassword(operatorDTO.changePassword);
		//		operator.setLogin(operatorDTO.login);
		//		operator.setName(operatorDTO.name);
		//		operator.setSurname(operatorDTO.surname);
		//
		//		operator.setGroups(operatorDTO.groups.stream().map(g -> g.group).collect(Collectors.joining(",")));

		return operator;
	}

}
