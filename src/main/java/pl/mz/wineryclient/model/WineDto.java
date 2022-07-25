package pl.mz.wineryclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by mz on 25.07.22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WineDto {

    private UUID id;
    private String wineName;
    private String wineType;
}
