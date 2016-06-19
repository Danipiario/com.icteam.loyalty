package com.icteam.loyalty.common;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface CryptService {

    String encrypt(String key);

    String decrypt(String key);
}
