package pl.mz.wineryclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mz.wineryclient.model.WineDto;

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
}