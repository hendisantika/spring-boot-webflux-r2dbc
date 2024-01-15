package id.my.hendisantika.webfluxr2dbc.service;

import id.my.hendisantika.webfluxr2dbc.entity.User;
import id.my.hendisantika.webfluxr2dbc.repository.UserRepository;
import id.my.hendisantika.webfluxr2dbc.util.JwtValidationUtil;
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
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtValidationUtil jwtValidationUtil;

    public Mono<String> getName(String token) {
        return Mono.just(jwtValidationUtil.getPhone(token))
                .flatMap(userRepository::findByPhone)
                .filter(Objects::nonNull)
                .map(User::getUsername)
                .switchIfEmpty(Mono.error(new RuntimeException("error when get username - not found phone number")));
    }

    public Mono<User> updateName(String token, String newName) {
        return Mono.just(jwtValidationUtil.getPhone(token))
                .flatMap(userRepository::findByPhone)
                .filter(Objects::nonNull)
                .switchIfEmpty(Mono.error(new RuntimeException("error when get username - not found phone number")))
                .flatMap(user -> {
                    user.setUsername(newName);
                    return userRepository.save(user);
                });
    }
}
