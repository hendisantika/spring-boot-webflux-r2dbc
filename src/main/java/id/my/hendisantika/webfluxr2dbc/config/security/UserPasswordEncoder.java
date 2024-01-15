package id.my.hendisantika.webfluxr2dbc.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserPasswordEncoder implements PasswordEncoder {

    @Value("${application.password.encoder.secretSaltKey}")
    private String secretSaltKey;

    @Value("${application.password.encoder.iteration}")
    private Integer iteration;

    @Value("${application.password.encoder.keylength}")
    private Integer keyLength;

}
