package az.coders.FinalProject.controller;

import az.coders.FinalProject.dto.request.EditImageRequest;
import az.coders.FinalProject.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PutMapping("/contact")
    public String editContactImage(@RequestBody EditImageRequest request) {
            return imageService.editContactImage(request);
    }

    @PutMapping("/company")
    public String editCompanyImage(@RequestBody EditImageRequest request) {
        return imageService.editCompanyImage(request);
    }
}
