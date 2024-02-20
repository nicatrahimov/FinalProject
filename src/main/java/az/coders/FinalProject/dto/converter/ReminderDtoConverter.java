package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.request.ReminderRequestDto;
import az.coders.FinalProject.dto.response.ReminderResponseDto;
import az.coders.FinalProject.enums.TimeType;
import az.coders.FinalProject.model.Reminder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReminderDtoConverter {

   public ReminderResponseDto toResponseDto(Reminder reminder){
       return ReminderResponseDto.builder()
               .id(reminder.getId())
               .timeType(reminder.getTimeType().toString())
               .timePeriod(reminder.getTimePeriod())
               .build();
   }

    public Reminder toEntity(ReminderRequestDto reminder) {
        return Reminder.builder()
                .timePeriod(reminder.getTimePeriod())
                .timeType(TimeType.valueOf(reminder.getTimeType()))
                .build();
    }
}
