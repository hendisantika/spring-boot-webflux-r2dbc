package id.my.hendisantika.webfluxr2dbc;

import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class GenerateKey {
    @Test
    public void generateKey() throws NoSuchAlgorithmException {
        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        byte[] privateKeyBytes = privateKey.getEncoded();
        byte[] publicKeyBytes = publicKey.getEncoded();

        String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKeyBytes);
        String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKeyBytes);

        System.out.println("privateKeyBase64 key: " + privateKeyBase64);
        System.out.println("---------------------------------------");
        System.out.println("publicKeyBase64 key: " + publicKeyBase64);

    }
}
