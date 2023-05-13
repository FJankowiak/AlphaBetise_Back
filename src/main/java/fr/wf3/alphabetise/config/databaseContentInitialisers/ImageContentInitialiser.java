package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.Image;
import fr.wf3.alphabetise.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ImageContentInitialiser {
    @Autowired
    private ImageService imageService;

    private List<Image> imagesInBase;

    public Map<String, Image> contentInitialiser(){
        // Obtenir tout ce qui est déjà en base
        imagesInBase = imageService.findAllImages();
        System.err.println(imagesInBase);

        // Future liste de tous les éléments que l'on attend dans la base
        List<Image> imagesExpected = new ArrayList<>();
//
//        // Peupler la liste attendue
////        Editeur e1 = new Editeur("Bayard");
        imagesExpected.add(new Image("assets/images/livres/AgeDOr.jfif"));
        imagesExpected.add(new Image("assets/images/livres/ailefroide.jpg"));
        imagesExpected.add(new Image("assets/images/livres/cacheeOuPasJarrive.jfif"));
        imagesExpected.add(new Image("assets/images/livres/Coraline.jfif"));
        imagesExpected.add(new Image("assets/images/livres/etonnanteFamilleAppenzel.jfif"));
        imagesExpected.add(new Image("assets/images/livres/GastonGrognon.jfif"));
        imagesExpected.add(new Image("assets/images/livres/Geante.jfif"));
        imagesExpected.add(new Image("assets/images/livres/Ickabog.jfif"));
        imagesExpected.add(new Image("assets/images/livres/la-cantoche.jfif"));
        imagesExpected.add(new Image("assets/images/livres/LaFamillePassiflore.jfif"));
        imagesExpected.add(new Image("assets/images/livres/LaNuitDeBerk.jfif"));
        imagesExpected.add(new Image("assets/images/livres/leChateauDesNuages.jfif"));
        imagesExpected.add(new Image("assets/images/livres/leChateauHurle.jfif"));
        imagesExpected.add(new Image("assets/images/livres/LeChatRitable.jfif"));
        imagesExpected.add(new Image("assets/images/livres/LeMondeAuBalcon.jfif"));
        imagesExpected.add(new Image("assets/images/livres/LesGestesBariiere.jfif"));
        imagesExpected.add(new Image("assets/images/livres/LesPierresAFeu.jfif"));
        imagesExpected.add(new Image("assets/images/livres/LesPtitesPoules.jfif"));
        imagesExpected.add(new Image("assets/images/livres/MamanOursALaRescousse.jfif"));
        imagesExpected.add(new Image("assets/images/livres/MimoseEtSam.jfif"));
        imagesExpected.add(new Image("assets/images/livres/PetitVampire.jfif"));
        imagesExpected.add(new Image("assets/images/livres/radiumGirls.jfif"));
        imagesExpected.add(new Image("assets/images/livres/VengeanceCornebidouille.jfif"));

////        imagesExpected.add();
//
//        // Obtenir juste les noms pour faire un filtrage
        List<String> names = new ArrayList<>();
        for(Image e : imagesInBase){
            names.add(e.getImgUrl());
        }
////        System.err.println(names);
////        System.err.println(names.size());
//
//        // Comparer ce qui est en base
        List<Image> missingImages = imagesExpected.stream().filter(
                e -> !names.contains(e.getImgUrl())
        ).collect(Collectors.toList());

//        System.err.println(missingImages.size());
//        System.err.println(missingImages);

//        // Si des éléments étaient manquant, on les rajoute en base
        if(missingImages.size() > 0){
            imageService.addMultipleImages(missingImages);

            imagesInBase = imageService.findAllImages();
        }
//
        Map<String, Image> map = new HashMap<>();
////
        for(Image e : imagesInBase){
            String[] split = e.getImgUrl().split("\\\\");
            String name = split[split.length - 1];
            map.put(name, e);
        }

        return map;
//        System.err.println(e1);
    }
}
