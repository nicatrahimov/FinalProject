package az.coders.FinalProject.service;

import az.coders.FinalProject.dto.request.EditImageRequest;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {
    String editContactImage(EditImageRequest request);
    String editCompanyImage(EditImageRequest request);
    String editCaseImage(EditImageRequest request);
}
