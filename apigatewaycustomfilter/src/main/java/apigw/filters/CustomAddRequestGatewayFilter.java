package apigw.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class CustomAddRequestGatewayFilter implements GatewayFilter {
    private HeaderConfig headerConfig;

    public CustomAddRequestGatewayFilter(HeaderConfig headerConfig) {
        this.headerConfig = headerConfig;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Mono<Void> response = null;

        ServerHttpRequest request = exchange.getRequest();
        request.mutate().headers(httpHeaders -> httpHeaders.add(headerConfig.getName(), headerConfig.getValue())).build();
        response = chain.filter(exchange.mutate().request(request).build());


        return response;
    }
}
