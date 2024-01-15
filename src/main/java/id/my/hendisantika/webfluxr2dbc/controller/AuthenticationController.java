package id.my.hendisantika.webfluxr2dbc.controller;

import id.my.hendisantika.webfluxr2dbc.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
