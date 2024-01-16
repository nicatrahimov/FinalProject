package az.coders.FinalProject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponseDto {
    private String id;
    private String name;
    private String email;
    private String website;
    private String phoneNumber;
    private String faxNumber;
    private String city;
    private String address;
    private String description;
    private ImageResponseDto image;
    private Set<CompanyContactDto> contacts = new HashSet<>();
}
