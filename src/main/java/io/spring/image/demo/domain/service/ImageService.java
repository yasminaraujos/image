package io.spring.image.demo.domain.service;

import io.spring.image.demo.domain.entity.Image;

import java.util.Optional;


public interface ImageService {
    //salva imagem
    Image save (Image image);

    //retorna imagem
    Optional<Image> getById(String id);
}