package com.icteam.loyalty.common.internal.builder;

import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.common.DTOBuilder;
import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.model.Operator;

@Component(property = { DTOBuilder.PROPERTY_DTO_CLASS_NAME + "=OperatorDTO", DTOBuilder.PROPERTY_OBJECT_CLASS_NAME + "=Operator" })
public class OperatorDTOBuilder implements DTOBuilder<OperatorDTO, Operator> {

    @Override
    public OperatorDTO buildDTO(Operator operator) {
        OperatorDTO operatorDTO = new OperatorDTO();

        operatorDTO.login = operator.getLogin();
        operatorDTO.name = operator.getName();
        operatorDTO.surname = operator.getSurname();
        operatorDTO.changePassword = operator.getChangePassword();

        return operatorDTO;
    }

    @Override
    public Operator buildObject(OperatorDTO operatorDTO) {
        Operator operator = new Operator();

        operator.setChangePassword(operatorDTO.changePassword);
        operator.setLogin(operatorDTO.login);
        operator.setName(operatorDTO.name);
        operator.setSurname(operatorDTO.surname);

        return operator;
    }

}
