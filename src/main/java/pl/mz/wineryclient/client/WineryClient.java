package pl.mz.wineryclient.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.mz.wineryclient.model.WineDto;

import java.net.URI;
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

    public URI saveNewWine(WineDto wineDto){
        return restTemplate.postForLocation(apihost + WINE_PATH_V1, wineDto);
    }

    public void updateWine(UUID uuid, WineDto wineDto){
        restTemplate.put(apihost + WINE_PATH_V1 + "/" + uuid.toString(), wineDto);
    }

    public void deleteWine(UUID uuid) { restTemplate.delete(apihost + WINE_PATH_V1 + uuid); }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
