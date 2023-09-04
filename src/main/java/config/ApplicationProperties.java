package config;

import lombok.Getter;
import lombok.Setter;

public class ConfigProperties {
    @Getter
    @Setter
    public static class ServiceProperties {

        private final Service baseUrl = new Service();
    }
}
}
