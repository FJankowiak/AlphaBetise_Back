package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Image;
import fr.wf3.alphabetise.exceptions.EmptyFieldException;
import fr.wf3.alphabetise.exceptions.MissingEntityById;
import fr.wf3.alphabetise.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImageService implements IImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image addImage(Image image){
        if(image.fullEntity()){
            return imageRepository.save(image);
        } else {
            throw new EmptyFieldException("image");
        }
    }

    public Image updateImage(Image image){
        if(image.fullEntity()){
            return imageRepository.save(image);
        } else {
            throw new EmptyFieldException("image");
        }
    }

    public Image findImageById(Long id){
        return imageRepository.findById(id).orElseThrow(() -> new MissingEntityById("Image", id));
    }

    public List<Image> findAllImages(){
        return imageRepository.findAll();
    }

    public void deleteImage(Long id){
        imageRepository.deleteById(id);
    }

    public List<Image> addMultipleImages(List<Image> images){
        List<Image> toBeAdded = images.stream().filter(
                e -> e.fullEntity()
        ).collect(Collectors.toList());

        List<Image> notAdded = images.stream().filter(
                e -> !e.fullEntity()
        ).collect(Collectors.toList());

        for(Image e : notAdded){
            System.err.println(String.format("Image non ajouté à cause de champs obligatoires vides : %s", e.toString()));
        }

        return imageRepository.saveAll(toBeAdded);
    }


}
