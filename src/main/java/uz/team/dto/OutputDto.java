package uz.team.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputDto {

    @JsonFormat(pattern = "dd.MM.yyyy", timezone = "UTC", locale = "UZB")
    @JsonProperty(value = "date")
    private Timestamp date;
    private Integer warehouseId;
    private Integer currencyId;
    private String factureNumber;
    private String code;
    private Integer clientId;

}
