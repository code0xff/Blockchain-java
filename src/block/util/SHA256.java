package block.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	public String encode(byte[] param) {
		MessageDigest digest = null;
		String endcodedData = "";
		try {
			digest = MessageDigest.getInstance("SHA-256");

			byte[] hash = digest.digest(param);
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			endcodedData = hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return endcodedData;
	}
}
