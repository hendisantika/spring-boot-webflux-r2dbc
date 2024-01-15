package id.my.hendisantika.webfluxr2dbc.service;

import id.my.hendisantika.webfluxr2dbc.config.security.UserPasswordEncoder;
import id.my.hendisantika.webfluxr2dbc.dto.RegisterRequest;
import id.my.hendisantika.webfluxr2dbc.entity.User;
import id.my.hendisantika.webfluxr2dbc.repository.UserRepository;
import id.my.hendisantika.webfluxr2dbc.util.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

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

    public Mono<User> register(RegisterRequest registerRequest) {
        return userRepository.findByPhone(registerRequest.getPhoneNumber())
                .filter(Objects::nonNull)
                .flatMap(user -> Mono.<User>error(new RuntimeException("Phone number already registered")))
                .switchIfEmpty(saveNewUser(registerRequest));
    }
}
