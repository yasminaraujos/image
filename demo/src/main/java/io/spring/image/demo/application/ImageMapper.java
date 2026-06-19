package io.spring.image.demo.application;

import io.spring.image.demo.domain.entity.Image;
import io.spring.image.demo.domain.enums.ImageExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class ImageMapper {

    public Image mapToImage(MultipartFile file, String name, List<String> tags) throws IOException { // pegar o json(dto) e converter para imagem
        return Image.builder()
                .name(name)
                .tags(String.join(",", tags)) // ["tag1, "tag2"] -> "tag1, tag2"
                .size(file.getSize())
                .extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType()))) //como vamos fazer isso? vamos imprimir no console através de nosso log.
                .file(file.getBytes()) //exception de throws
                .build();

    }
    public ImageDTO imageToDTO(Image image, String url){ //converter imagem para dto
        return ImageDTO.builder()
                .url(url)
                .extension(image.getExtension().name())
                .name(image.getName())
                .size(String.valueOf(image.getSize())) // de string para long
                .uploadDate(image.getUploadDate().toLocalDate())
                .build();
    }
}