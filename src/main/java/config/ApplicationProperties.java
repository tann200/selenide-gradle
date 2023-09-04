package config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private final ServiceProperties service = new ServiceProperties();

    @Getter
    @Setter
    public static class ServiceProperties {

        private final Service baseService = new Service();

        @Getter
        @Setter
        public static class Service {

            private String uri;
        }
    }
}

