package uz.team.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputProductDto {

    private Integer productId;
    private Double amount;
    private Double price;

    @JsonFormat(pattern = "dd.MM.yyyy", timezone = "UTC", locale = "UZB")
    @JsonProperty(value = "expireDate")
    private Date expireDate;
    private Integer inputId;

}
