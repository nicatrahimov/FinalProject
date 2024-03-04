package az.coders.FinalProject.dto.converter;

import az.coders.FinalProject.dto.request.ImageRequestDto;
import az.coders.FinalProject.dto.response.ImageResponseDto;
import az.coders.FinalProject.model.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageDtoConverter {


    public ImageResponseDto toImageResponseDto(Image image){
        try{
            return ImageResponseDto.builder()
                    .id(image.getId())
                    .base64(image.getBase64())
                    .build();
        }catch (NullPointerException e){
            return null;
        }

    }
    public ImageRequestDto toImageRequestDto(Image image){
        return ImageRequestDto.builder()
                .base64(image.getBase64())
                .build();
    }

    public Image toImage(ImageResponseDto responseDto){
        try{
            return Image.builder()
                    .id(responseDto.getId())
                    .base64(responseDto.getBase64())
                    .build();
        }catch (NullPointerException e){
            return null;
        }
    }
}
