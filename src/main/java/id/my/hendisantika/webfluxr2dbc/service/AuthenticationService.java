package id.my.hendisantika.webfluxr2dbc.service;

import id.my.hendisantika.webfluxr2dbc.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */
@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final UserPasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
}
