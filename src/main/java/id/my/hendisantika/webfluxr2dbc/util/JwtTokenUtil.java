package id.my.hendisantika.webfluxr2dbc.util;

import id.my.hendisantika.webfluxr2dbc.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", user.getRoles());
        return buildToken(claims, user, jwtExpiryTime);
    }

    public String generateRefreshToken(User user) {
        return buildToken(new HashMap<>(), user, jwtRefreshTime);
    }

    private String buildToken(Map<String, Object> extraClaims, User user, long expiration) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getPhone())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(jwtKeyUtil.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }
}
