package Tools;
import java.security.MessageDigest;

public class Encrypter {
	public static String Password(String data) {
	        StringBuffer sb = new StringBuffer();

	        try {
	            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
	            messageDigest.update(data.getBytes("UTF-8"));
	            byte[] digestBytes = messageDigest.digest();


	            String hex = null;

	            for (int i = 0; i < digestBytes.length; i++) {
	                //Convert it to positive integer and then to Hex String

	                hex = Integer.toHexString(0xFF & digestBytes[i]);

	                //Append "0" to the String to made it exactly 128 length (SHA-512 alogithm)
	                if (hex.length() < 2) 
	                    sb.append("0");
	                sb.append(hex);
	                }
	            }
	        catch (Exception ex) {
	            System.out.println(ex.getMessage());
	            }

	        return new String(sb);
	    }
}
