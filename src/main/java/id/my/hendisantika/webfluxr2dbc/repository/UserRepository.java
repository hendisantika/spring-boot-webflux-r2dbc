package id.my.hendisantika.webfluxr2dbc.repository;

import id.my.hendisantika.webfluxr2dbc.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

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
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByPhoneAndPassword(String phone, String password);

    Mono<User> findByPhone(String phone);
}
