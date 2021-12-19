package uz.team.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
    private String message;
    private boolean success;
    private Object object;

    public ResultDto(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
