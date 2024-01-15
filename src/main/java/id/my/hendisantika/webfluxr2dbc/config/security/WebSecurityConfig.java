package id.my.hendisantika.webfluxr2dbc.config.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:27
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@AllArgsConstructor
public class WebSecurityConfig {
    private static final String LOGIN_URL = "/login";
    private static final String REGISTER_URL = "/register";
    private static final String SWAGGER_URL = "/webjars/swagger-ui/**";

    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository securityContextRepository;
}
