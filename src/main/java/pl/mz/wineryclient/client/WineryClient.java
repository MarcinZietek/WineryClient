package pl.mz.wineryclient.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.mz.wineryclient.model.WineDto;

import java.util.UUID;

@ConfigurationProperties(prefix = "api.winery", ignoreUnknownFields = false)
@Component
public class WineryClient {

    public final String WINE_PATH_V1 = "/api/v1/wine/";
    private String apihost;
    private final RestTemplate restTemplate;

    public WineryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public WineDto getWineById(UUID uuid){
        return restTemplate.getForObject(apihost + WINE_PATH_V1 + uuid.toString(), WineDto.class);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
