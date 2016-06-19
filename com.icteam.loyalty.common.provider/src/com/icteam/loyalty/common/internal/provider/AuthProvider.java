package com.icteam.loyalty.common.internal.provider;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.icteam.loyalty.common.AuthService;
import com.icteam.loyalty.common.CryptService;
import com.icteam.loyalty.common.DTOService;
import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.model.Operator;

@Component
public class AuthProvider implements AuthService {

    @Reference
    private CryptService cryptService;

    @Reference
    private DTOService dtoService;

    @Override
    public OperatorDTO login(OperatorLoginDTO operatorLoginDTO) {
        Operator operator = new Operator();
        operator.setLogin(operatorLoginDTO.login);
        operator.setPassword(cryptService.encrypt(operatorLoginDTO.password));

        return dtoService.toDTO(operator, OperatorDTO.class);
    }

}
