package az.coders.FinalProject.dto.request;

import az.coders.FinalProject.enums.TimeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ReminderRequestDto {
   @NotBlank(message = "Time period cannot be empty")
   private Integer timePeriod;

   @Pattern(regexp = "MINUTE|HOUR|DAY", message = "Time type should be MINUTE, HOUR or DAY")
   @NotNull(message = "Time type cannot be null")
   private String timeType;
}
