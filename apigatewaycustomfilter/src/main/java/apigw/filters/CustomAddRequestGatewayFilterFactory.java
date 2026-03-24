package apigw.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomAddRequestGatewayFilterFactory extends AbstractGatewayFilterFactory<HeaderConfig> {
    public CustomAddRequestGatewayFilterFactory() {
        super(HeaderConfig.class);
    }

    @Override
    public GatewayFilter apply(HeaderConfig config) {
        CustomAddRequestGatewayFilter customAddRequestGatewayFilter = new CustomAddRequestGatewayFilter(config);
        return customAddRequestGatewayFilter;
    }
}
