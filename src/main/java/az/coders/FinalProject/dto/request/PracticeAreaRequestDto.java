package az.coders.FinalProject.dto.request;

import az.coders.FinalProject.dto.response.ImageResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PracticeAreaRequestDto {

    String id;
    String name;
    String city;
    ImageResponseDto image;
}
