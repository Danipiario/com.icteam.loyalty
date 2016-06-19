package com.icteam.loyalty.common;

import org.osgi.annotation.versioning.ProviderType;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;

@ProviderType
public interface AuthService {

    OperatorDTO login(OperatorLoginDTO operatorLoginDTO);
}
