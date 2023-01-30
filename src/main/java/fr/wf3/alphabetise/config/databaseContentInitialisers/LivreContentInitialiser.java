package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.Image;
import fr.wf3.alphabetise.entities.Livre;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivreContentInitialiser {
//    @Autowired
//    private LivreService livreService;
//
//
//    public Map<String, Image> contentInitialiser(List<Image> imgs){
//        // Obtenir tout ce qui est déjà en base
//        List<Livre> imagesInBase = livreService.findAllImages();
////        System.err.println(imagesInBase);
//
//        // Future liste de tous les éléments que l'on attend dans la base
//        List<Image> imagesExpected = new ArrayList<>();
//
//        // Peupler la liste attendue
////        Editeur e1 = new Editeur("Bayard");
//        imagesExpected.add(new Image("AgeDOr.jfif"));
//        imagesExpected.add(new Image("ailefroide.jpg"));
//        imagesExpected.add(new Image("cacheeOuPasJarrive.jfif"));
//        imagesExpected.add(new Image("Coraline.jfif"));
//        imagesExpected.add(new Image("etonnanteFamilleAppenzel.jfif"));
//        imagesExpected.add(new Image("GastonGrognon.jfif"));
//        imagesExpected.add(new Image("Geante.jfif"));
//        imagesExpected.add(new Image("Ickabog.jfif"));
//        imagesExpected.add(new Image("la-cantoche.jfif"));
//        imagesExpected.add(new Image("LaFamillePassiflore.jfif"));
//        imagesExpected.add(new Image("LaNuitDeBerk.jfif"));
//        imagesExpected.add(new Image("leChateauDesNuages.jfif"));
//        imagesExpected.add(new Image("leChateauHurle.jfif"));
//        imagesExpected.add(new Image("LeChatRitable.jfif"));
//        imagesExpected.add(new Image("LeMondeAuBalcon.jfif"));
//        imagesExpected.add(new Image("LesGestesBariiere.jfif"));
//        imagesExpected.add(new Image("LesPierresAFeu.jfif"));
//        imagesExpected.add(new Image("LesPtitesPoules.jfif"));
//        imagesExpected.add(new Image("MamanOursALaRescousse.jfif"));
//        imagesExpected.add(new Image("MimoseEtSam.jfif"));
//        imagesExpected.add(new Image("PetitVampire.jfif"));
//        imagesExpected.add(new Image("radiumGirls.jfif"));
//        imagesExpected.add(new Image("VengeanceCornebidouille.jfif"));
//
////        imagesExpected.add();
//
//        // Obtenir juste les noms pour faire un filtrage
//        List<String> names = new ArrayList<>();
//        for(Livre e : imagesInBase){
//            names.add(e.getImgUrl());
//        }
//
////        System.err.println(names);
////        System.err.println(names.size());
//
//        // Comparer ce qui est en base
//        List<Livre> missingLivres = imagesExpected.stream().filter(
//                e -> !names.contains(e.getImgUrl())
//        ).collect(Collectors.toList());
//
////        System.err.println(missingLivres.size());
////        System.err.println(missingLivres);
//
//        // Si des éléments étaient manquant, on les rajoute en base
//        if(missingLivres.size() > 0){
//            livreService.addMultipleLivres(missingLivres);
//
//            imagesInBase = livreService.findAllLivres();
//        }
//
//        Map<String, Livre> map = new HashMap<>();
//
//        for(Livre e : imagesInBase){
////            String[] split = e.get().split("\\\\");
////            String name = split[split.length - 1];
////            map.put(e.getImgUrl(), e);
//        }
//
//        return map;
////        System.err.println(e1);
//    }
}
