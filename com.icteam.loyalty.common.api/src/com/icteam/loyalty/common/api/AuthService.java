package com.icteam.loyalty.common.api;

import org.osgi.annotation.versioning.ProviderType;

import com.icteam.loyalty.common.api.dto.OperatorDTO;
import com.icteam.loyalty.common.api.dto.OperatorLoginDTO;

@ProviderType
public interface AuthService {

    OperatorDTO login(OperatorLoginDTO operatorLoginDTO);
}
