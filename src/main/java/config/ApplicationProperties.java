package config;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ApplicationProperties {
    private final ServiceProperties service = new ServiceProperties();

    @Getter
    @Setter
    public static class ServiceProperties {


        private final Service baseService = new Service();
    }
    @Getter
    public static class Service {

        private String uri;
    }
}

