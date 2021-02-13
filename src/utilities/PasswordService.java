package utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * This class converts plaintext password to a SHA256 hash.
 * 
 */
public final class PasswordService {

	/**Encrypt string pass to a hashed SHA256 encrypted version
	 */
	public String encrypt(String pass) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			md.update(pass.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte raw[] = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);
		return hash;
	}
	
	public boolean isGood(String password) {
		
		if(password.trim().equals("")) {
			return false;
		}
		
		boolean hasLetter = false;
	    boolean hasDigit = false;

		if (password.length() >= 7) {
            for (int i = 0; i < password.length(); i++) {
                char x = password.charAt(i);
                if (Character.isLetter(x)) {
                    hasLetter = true;
                }
                else if (Character.isDigit(x)) {
                    hasDigit = true;
                }
                // no need to check further, break the loop
                if(hasLetter && hasDigit){
                    break;
                }
            }
            if (hasLetter && hasDigit) {
                return true;
            } else {
            	return false;
            }
        } else {
            System.out.println("HAVE AT LEAST 8 CHARACTERS");
        }

		return true;
	}
}
