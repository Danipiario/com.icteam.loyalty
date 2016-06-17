package com.icteam.loyalty.common.internal.provider;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.icteam.loyalty.common.api.AuthService;
import com.icteam.loyalty.common.api.CryptService;
import com.icteam.loyalty.common.api.DTOService;
import com.icteam.loyalty.common.api.dto.OperatorDTO;
import com.icteam.loyalty.common.api.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.api.model.Operator;

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
