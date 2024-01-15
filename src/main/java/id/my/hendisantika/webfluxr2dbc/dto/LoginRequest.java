package id.my.hendisantika.webfluxr2dbc.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:31
 * To change this template use File | Settings | File Templates.
 */
@Data
public class LoginRequest {

    //TODO : catch error from DTO validation
    @Pattern(regexp = "^08\\d{8,10}$", message = "Phone number is invalid")
    private String phoneNumber;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9]).{6,16}$", message = "Password must contain at least 1 capital letter and 1 number, and be between 6 and 16 characters long")
    private String password;
}
