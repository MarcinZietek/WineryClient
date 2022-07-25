package pl.mz.wineryclient.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(prefix = "api.winery", ignoreUnknownFields = false)
public class WineryClient {

    public final String WINE_PATH_V1 = "/api/v1/wine/";
    private String apihost;
    private final RestTemplate restTemplate;

    public WineryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
