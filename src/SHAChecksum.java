import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHAChecksum {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        if (args.length != 1) {
            System.out.println("Podaj ciąg znaków do obliczenia funkcji skrótu.");
   //         return;
        }
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        System.out.println(md);
        byte[] mdbytes = md.digest(args[0].getBytes());
        StringBuffer hexBuffer = new StringBuffer();
        String hex;
        for (int i = 0; i < mdbytes.length; ++i) {
            hex = Integer.toHexString(0xFF & mdbytes[i]);
            if (hex.length() == 1) {
                hexBuffer.append('0');
            }
            hexBuffer.append(hex);
        }
        System.out.println(hexBuffer.toString());
    }
}

