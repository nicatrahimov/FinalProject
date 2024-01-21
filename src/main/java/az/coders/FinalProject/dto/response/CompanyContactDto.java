package az.coders.FinalProject.dto.response;

import az.coders.FinalProject.dto.response.ImageResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyContactDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String country;
    private String peopleGroup;
    private ImageResponseDto image;
}
