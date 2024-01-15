package id.my.hendisantika.webfluxr2dbc.controller;

import id.my.hendisantika.webfluxr2dbc.dto.BaseResponse;
import id.my.hendisantika.webfluxr2dbc.dto.LoginRequest;
import id.my.hendisantika.webfluxr2dbc.dto.LoginResponse;
import id.my.hendisantika.webfluxr2dbc.service.AuthenticationService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController extends BaseController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully logged user"),
            @ApiResponse(responseCode = "500", description = "failed login user"),
            @ApiResponse(responseCode = "403", description = "user or password is invalid")
    })
    public Mono<ResponseEntity<BaseResponse<LoginResponse>>> login(@RequestBody LoginRequest loginRequest) {
        //TODO : catch error from DTO validation
        return authenticationService.login(loginRequest.getPhoneNumber(), loginRequest.getPassword())
                .map(token -> ResponseEntity.ok(BaseResponse.<LoginResponse>builder()
                        .code(200)
                        .message("success")
                        .data(new LoginResponse(token))
                        .build()))
                .onErrorResume(throwable -> Mono.just(ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body(BaseResponse.<LoginResponse>builder()
                                .code(HttpStatus.FORBIDDEN.value())
                                .message(throwable.getMessage())
                                .data(new LoginResponse(null))
                                .build())));
    }
}
