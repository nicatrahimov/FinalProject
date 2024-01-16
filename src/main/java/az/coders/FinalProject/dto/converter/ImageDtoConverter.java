package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.response.ImageResponseDto;
import az.coders.FinalProject.model.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageDtoConverter {


    public ImageResponseDto toImageResponseDto(Image image){
        return ImageResponseDto.builder()
                .id(image.getId())
                .base64(image.getBase64())
                .build();
    }
}
