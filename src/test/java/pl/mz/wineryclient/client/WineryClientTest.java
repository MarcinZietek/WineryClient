package pl.mz.wineryclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mz.wineryclient.model.WineDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WineryClientTest {

    @Autowired
    WineryClient client;

    @Test
    void getWineById() {
        WineDto wineDto = client.getWineById(UUID.randomUUID());
        assertNotNull(wineDto);
    }

    @Test
    void testSaveBeer(){
        WineDto wineDto = WineDto.builder().wineName("Merlot").build();
        URI uri = client.saveNewWine(wineDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateWine(){
        WineDto wineDto = WineDto.builder().wineName("Syrah").build();
        client.updateWine(UUID.randomUUID(), wineDto);
    }

    @Test
    void testDeleteWine(){
        client.deleteWine(UUID.randomUUID());
    }
}