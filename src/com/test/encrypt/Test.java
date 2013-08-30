package com.test.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testMD5();
	}
	
	public static void testMD5()
	{
		System.out.println(encryptMD5("I'm Persian."));
		System.out.println(encryptMD5("0123456789"));
		System.out.println(encryptMD5(null));
		System.out.println(encryptMD5(""));
	}
	
	public static String encyptMD5(String passwd)
    {
        try
        {
            byte[] md5Msg = MessageDigest.getInstance("MD5").digest(
                    passwd.getBytes());
            return new String(new Base64().encode(md5Msg));
        }
        catch (NoSuchAlgorithmException e)
        {
//            CATEGORY.error("The system didn't support the Md5 ALGORITHM", e);
        }

        return passwd;
    }
	
	// Encrypt the message, the result length is 32.
	public static String encryptMD5(String passwd) {
		if(passwd == null)
			return passwd;
		
		String hashtext = passwd;
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(passwd.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
		} catch (NoSuchAlgorithmException e) {
			// System doesn't support MD5.
		}

		return hashtext;
	}

}
