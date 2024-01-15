package id.my.hendisantika.webfluxr2dbc.config.security;

import lombok.AllArgsConstructor;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
@Component
@AllArgsConstructor
public class SecurityContextRepository implements ServerSecurityContextRepository {

    private static final String BEARER = "Bearer ";
    private final AuthenticationManager authenticationManager;
}
