package az.coders.FinalProject.dto.request;

import az.coders.FinalProject.dto.response.CompanyContactDto;
import az.coders.FinalProject.model.Contact;
import az.coders.FinalProject.model.Image;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequestDto {
    String id;
    String name;
    String email;
    String website;
    String phoneNumber;
    String faxNumber;
    String city;
    String address;
    String description;
    ImageRequestDto image;
    Set<CompanyContactDto> contacts;
}
