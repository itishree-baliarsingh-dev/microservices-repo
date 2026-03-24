package distributornetwork.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "network")
@Data
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
public class NetworkSettings {
    String businessType;
    String locationType;
}
