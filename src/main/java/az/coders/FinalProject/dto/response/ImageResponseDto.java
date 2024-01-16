package az.coders.FinalProject.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponseDto {
    private String id;
    private String base64;
}
