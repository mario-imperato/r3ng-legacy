package org.r3.system.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class CryptoUtils
{

	private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
	private static final byte[] SALT = { (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12, (byte) 0xde, (byte) 0x33, (byte) 0x10,
					(byte) 0x12, };

	public static void main(String[] args) throws Exception
	{
		String originalPassword = "secret";
		System.out.println("Original password: " + originalPassword);
		String encryptedPassword = encrypt(originalPassword);
		System.out.println("Encrypted password: " + encryptedPassword);
		String decryptedPassword = decrypt(encryptedPassword);
		System.out.println("Decrypted password: " + decryptedPassword);
	}

	public static String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException
	{
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
		Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
		pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
		return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
	}

	private static String base64Encode(byte[] bytes)
	{
		// NB: This class is internal, and you probably should use another impl
		return Base64.encodeBytes(bytes);
		// return new BASE64Encoder().encode(bytes);
	}

	public static String decrypt(String property) throws GeneralSecurityException, IOException
	{
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
		Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
		pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
		byte[] decodedProperty = base64Decode(property);
		System.out.println("decodedProperty: " + property + "/" + ((decodedProperty != null) ? decodedProperty.length : -1));
		return new String(pbeCipher.doFinal(decodedProperty), "UTF-8");
	}

	private static byte[] base64Decode(String property) throws IOException
	{
		// NB: This class is internal, and you probably should use another impl
		return Base64.decode(property);
		// return new BASE64Decoder().decodeBuffer(property);
	}

}
