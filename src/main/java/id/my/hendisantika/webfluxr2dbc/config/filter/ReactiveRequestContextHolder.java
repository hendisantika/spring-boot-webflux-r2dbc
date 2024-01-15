package id.my.hendisantika.webfluxr2dbc.config.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-r2dbc
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/15/24
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
public class ReactiveRequestContextHolder {
    private static final String BEARER = "Bearer ";

    public static Mono<String> getTokenAuth() {
        return Mono.deferContextual(Mono::just)
                .filter(contextView -> Objects.nonNull(contextView.get(ServerWebExchange.class).getRequest()))
                .map(contextView -> {
                    HttpHeaders headers = contextView.get(ServerWebExchange.class).getRequest().getHeaders();
                    return Optional.ofNullable(headers.getFirst(ContextKey.AUTHORIZATION))
                            .filter(authHeader -> authHeader.startsWith(BEARER))
                            .map(authHeaderBearer -> authHeaderBearer.substring(BEARER.length()))
                            .get();
                });
    }
}
