package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Image;

import java.util.List;

public interface IImageService {
    public Image addImage(Image image);
    public Image updateImage(Image image);
    public Image findImageById(Long id);
    public List<Image> findAllImages();
    public void deleteImage(Long id);
    public List<Image> addMultipleImages(List<Image> images);
}
