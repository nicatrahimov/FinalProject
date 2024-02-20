package az.coders.FinalProject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditImageRequest {
    private String targetObjectId;
    private String base64;
}
