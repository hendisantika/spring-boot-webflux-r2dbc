package id.my.hendisantika.webfluxr2dbc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:41
 * To change this template use File | Settings | File Templates.
 */
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;
    private List<String> errors;
    private long serverTime;

    public long getServerTime() {
        return System.currentTimeMillis();
    }
}
