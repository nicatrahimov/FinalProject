package az.coders.FinalProject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PracticeAreaResponseDto {
    String id;
    String name;
    String city;
    Boolean isActiveCase;
    ImageResponseDto image;
}
