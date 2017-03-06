package Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Doda on 05/03/2017.
 */
public class Criptografia {

    public static String gerarMD5(String string) throws NoSuchAlgorithmException {


        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(string.getBytes()));

        return String.format("%32x",hash);
    }

    public static boolean compararSenhas(String senha,String senhaComparar) throws NoSuchAlgorithmException {

        if (gerarMD5(senha).equals(gerarMD5(senhaComparar)))
            return true;
        else
            return false;

    }


}
