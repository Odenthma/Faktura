package Tools;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

public class EncryptDecrypt_ {
	
	
	public static void createPassword(String user, String password) throws Exception {
	    SecureRandom random = new SecureRandom();
	    byte[] salt = new byte[12];
	    random.nextBytes(salt);
	    String toEnctyption = user + ":"+password;
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(salt);
	    md.update(toEnctyption.getBytes("UTF8"));
	    byte[] digest = md.digest();

	    FileOutputStream fos = new FileOutputStream("password");
	    fos.write(salt);
	    fos.write(digest);
	    fos.close();
	  }
	
	public static void authenticatePassword(String user, String password) throws Exception {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    FileInputStream fis = new FileInputStream("password");
	    String toEnctyption = user + ":"+password;
	    int theByte = 0;
	    while ((theByte = fis.read()) != -1) {
	      baos.write(theByte);
	    }
	    fis.close();
	    byte[] hashedPasswordWithSalt = baos.toByteArray();
	    baos.reset();

	    byte[] salt = new byte[12];
	    System.arraycopy(hashedPasswordWithSalt, 0, salt, 0, 12);

	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(salt);
	    md.update(toEnctyption.getBytes("UTF8"));
	    byte[] digest = md.digest();

	    byte[] digestInFile = new byte[hashedPasswordWithSalt.length - 12];
	    System.arraycopy(hashedPasswordWithSalt, 12, digestInFile, 0,
	        hashedPasswordWithSalt.length - 12);

	    System.out.println(Arrays.equals(digest, digestInFile));
	  }
}
