package fr.wf3.alphabetise.web;

import fr.wf3.alphabetise.entities.Image;
import fr.wf3.alphabetise.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<List<Image>> findAllImages(){
        return new ResponseEntity<>(imageService.findAllImages(), HttpStatus.OK);
    }


}
