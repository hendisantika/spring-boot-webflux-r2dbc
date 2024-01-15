package id.my.hendisantika.webfluxr2dbc.controller;

import id.my.hendisantika.webfluxr2dbc.config.filter.ReactiveRequestContextHolder;
import id.my.hendisantika.webfluxr2dbc.dto.BaseResponse;
import id.my.hendisantika.webfluxr2dbc.dto.UserResponse;
import id.my.hendisantika.webfluxr2dbc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping
    public Mono<ResponseEntity<BaseResponse<UserResponse>>> getUser() {
        return ReactiveRequestContextHolder.getTokenAuth()
                .flatMap(userService::getName)
                .map(userName -> ResponseEntity.ok(BaseResponse.<UserResponse>builder()
                        .code(200)
                        .message("success")
                        .data(new UserResponse(userName))
                        .build()))
                .onErrorResume(throwable -> Mono.just(ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(BaseResponse.<UserResponse>builder()
                                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .message(throwable.getMessage())
                                .data(null)
                                .build()))
                );

        //TODO : handle error from service or create global error handler
    }

}
