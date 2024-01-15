package id.my.hendisantika.webfluxr2dbc.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:20
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JwtTokenUtil {
    private final JwtKeyUtil jwtKeyUtil;
    @Value("${application.security.jwt.expiration}")
    private Long jwtExpiryTime; //ms
    @Value("${application.security.jwt.refresh-time}")
    private Long jwtRefreshTime; //ms

    public JwtTokenUtil(JwtKeyUtil jwtKeyUtil1) {
        this.jwtKeyUtil = jwtKeyUtil1;
    }

}
