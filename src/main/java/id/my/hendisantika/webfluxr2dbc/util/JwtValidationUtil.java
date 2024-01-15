package id.my.hendisantika.webfluxr2dbc.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:21
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JwtValidationUtil {

    private final JwtKeyUtil jwtKeyUtil;
    @Value("${application.security.jwt.secretkey}")
    private String secretKey;

    public JwtValidationUtil(JwtKeyUtil jwtKeyUtil1) {
        this.jwtKeyUtil = jwtKeyUtil1;
    }

    public Claims getClaimsToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtKeyUtil.getPrivateKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getPhone(String token) {
        return getClaimsToken(token).getSubject();
    }

    public Date getExpiryTime(String token) {
        return getClaimsToken(token).getExpiration();
    }

    private Boolean isExpired(String token) {
        return getExpiryTime(token).before(new Date());
    }
}
