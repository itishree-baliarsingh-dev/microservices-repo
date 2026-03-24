package apigw.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RequestResponseLoggingGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Mono<Void> response = null;

        log.info("received request with path: {}", exchange.getRequest().getPath());
        response = chain.filter(exchange);
        log.info("completed the request of the path: {} with status code: {}", exchange.getRequest().getPath(),
                exchange.getResponse().getStatusCode());

        return response;
    }
}
