package pl.mz.wineryclient.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.mz.wineryclient.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById(){
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveCustomer(){
        //given
        CustomerDto customerDto = CustomerDto.builder()
                .firstName("Marek")
                .lastName("Markowski")
                .email("marek@marek.pl")
                .build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer(){
        //given
        CustomerDto customerDto = CustomerDto.builder()
                .firstName("Alicja")
                .lastName("Alojza")
                .email("alicja@alojza.pl")
                .build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
        assertNotNull(customerDto);
    }

    @Test
    void testDeleteCustomer() { client.deleteCustomer(UUID.randomUUID()); }
}