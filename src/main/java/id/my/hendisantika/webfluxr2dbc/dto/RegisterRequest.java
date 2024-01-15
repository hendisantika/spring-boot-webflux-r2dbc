package id.my.hendisantika.webfluxr2dbc.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:30
 * To change this template use File | Settings | File Templates.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterRequest extends LoginRequest {

    @Size(max = 60, message = "Name must not exceed {max} characters")
    private String name;
}
