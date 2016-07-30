package com.icteam.loyalty.common.provider.internal;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.service.CryptService;

@Component(scope = ServiceScope.SINGLETON)
public class CryptProvider implements CryptService {

	private static final String CRYPTO_ALGORITHM = "DESede";
	private static final String DEFAULT_KEY = "Security.addProvider(new com.sun.crypto.provider.SunJCE());";

	private static final byte[] CHUNK_SEPARATOR = { 13, 10 };

	private SecretKey secretKey;

	@Activate
	public void activate() throws Exception {
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(CRYPTO_ALGORITHM);

		DESedeKeySpec secKeySpec = new DESedeKeySpec(DEFAULT_KEY.getBytes());

		secretKey = secretKeyFactory.generateSecret(secKeySpec);
	}

	@Override
	public String encrypt(String input) {
		assert input != null;
		try {
			byte[] data = input.getBytes();

			Cipher cipher = Cipher.getInstance(CRYPTO_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] result = cipher.doFinal(data);

			String output = new String(Base64.encodeBase64Chunked(result));
			output = output.substring(0, output.length() - CHUNK_SEPARATOR.length);

			return output;
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String decrypt(String input) {
		assert input != null;

		try {
			Cipher cipher = Cipher.getInstance(CRYPTO_ALGORITHM);

			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			byte[] original = cipher.doFinal(Base64.decodeBase64(input.getBytes()));

			return new String(original);
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
	}
}
