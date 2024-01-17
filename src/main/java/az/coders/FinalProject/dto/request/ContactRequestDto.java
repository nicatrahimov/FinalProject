package az.coders.FinalProject.dto.request;

import az.coders.FinalProject.dto.response.ImageResponseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestDto {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotBlank
    String email;
    String address;
    String city;
    String country;
    String peopleGroup;
    ImageRequestDto image;
    String companyId;
}
