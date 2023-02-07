package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.*;
import fr.wf3.alphabetise.entities.Livre;
import fr.wf3.alphabetise.enums.Categorie;
import fr.wf3.alphabetise.services.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LivreContentInitialiser {
    @Autowired
    private LivreService livreService;

    private Map<String, Auteur> auteurs;
    private Map<String, Image> images;
    private Map<String, Editeur> editeurs;

    public Map<Long, Livre> contentInitialiser(Map<String, Auteur> auteurs_in, Map<String, Image> images_in, Map<String, Editeur> editeurs_in){
        auteurs = auteurs_in;
        images = images_in;
        editeurs = editeurs_in;

        System.err.println(images.keySet());
        System.err.println(auteurs.keySet());
        System.err.println(editeurs.keySet());

        // Obtenir tout ce qui est déjà en base
        List<Livre> livreInBase = livreService.findAllLivres();

        // Future liste de tous les éléments que l'on attend dans la base
        List<Livre> livresExpected = new ArrayList<>();

        // Peupler la liste attendue
        String[] temp = {"Perez", "Lacombe"};
        List<String> auteurs_names = new ArrayList<>(Arrays.asList(temp));

        livresExpected.add(creerLivre("L'ETONNANTE FAMILLE APPENZELL", 9791095184249l,
                "Ma grand-mère se nommait Eugénie. Eugénie Appenzell. D'elle, je tiens mes longs cheveux bouclés et, dit-on, mon caractère bien trempé. Peu de jours avant ma naissance, grand-mère Eugénie quitta les siens. En héritage, elle me laissa une boîte remplie de photographies et de lettres. \"Pour que tu connaisses ta famille\", m'avait-elle écrit. Durant des années, j'ai démêlé les liens et les intrigues qui unissent ces personnes extraordinaires.\n" +
                        "J'ai pleuré et j'ai ri... Aujourd'hui, je vous livre leur histoire. Mon histoire. Celle de l'étonnante famille Appenzell.",
                19.90f, Categorie.BEBES, "", auteurs_names, "etonnanteFamilleAppenzel.jfif", "Margot"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Lang", "Lang Max"}));

        livresExpected.add(creerLivre("GASTON GROGNON - T02 - C'EST LA FETE !", 9782203211506l,
                "N'avez-vous jamais été un peu inquiet en allant à une fête ? c'est le cas de Gaston. Son ami Porc-Epic organise une fiesta de folie, et tous les animaux n'ont qu'une hâte... danser jusqu'au bout de la nuit ! Il est HORS DE QUESTION pour Gaston de mettre un pied sur la piste de danse. D'abord, il ne sait même pas comment bouger son corps. Et puis, qu'est-ce qu'ils ont tous à vouloir lui apprendre ? Pourquoi n'aurait-il pas droit de ne pas aimer ça ?",
                13.90f, Categorie.BEBES, "", auteurs_names, "GastonGrognon.jfif", "Les Albums Casterman"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Jouannigot"}));

        livresExpected.add(creerLivre("LA FAMILLE PASSIFLORE, PIROUETTE & NYMPHEAS", 9782356740878l,
                "Au pays multicolore des nymphéas, vit la famille Blanche. La maman est une artiste peintre très connue. Ses deux enfants Ajonc et Genet veulent construire une cabane parmi les nymphéas, aidés par leurs jeunes invités : les Passiflore. 1987, premier livre pour enfants aux éditions Milan : Le Premier Bal d'Agaric Passiflore, texte de Geneviève Huriet. C'est le succès. Succès couronné par des prix littéraires et des récompenses diverses (prix Saint-Exupéry).\n" +
                        "S'ensuivra une longue série (24 titres parus), pour le plus grand plaisir des enfants (à partir de quatre ans). Aujourd'hui, les petits lapins Passiflore sont traduits en 28 langues et font l'objet d'une série télé, 52 épisodes de 26 minutes (production Euro Visual TF1) et diffusée depuis 2004 (TF1, Disney Chanel, etc.). En 2012, chez Dargaud, Loïc Jouannigot reprend seul les personnages des Passiflore en bande dessinée avec deux albums : L'Anniversaire de Dendelion et La Chorale.\n" +
                        "Suivent deux autres titres avec les textes de Michel Plessix, Mélodie potagère et La Chasse au trésor. Depuis l'arrêt en 2007 de l'édition, la sympathique et néanmoins célèbre Famille Passiflore est rééditée aux éditions Maghen. Ce nouvel album, Pirouette & Nymphéas, contient une histoire inédite de la famille Passiflore écrite et dessinée par Loïc Jouannigot.",
                13.00f, Categorie.BEBES, "", auteurs_names, "GastonGrognon.jfif", "JSP"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Jalbert"}));

        livresExpected.add(creerLivre("LES GESTES BARRIERES EXPLIQUES AUX ENFANTS", 9782017866763l,
                "Un petit ouvrage documentaire à destination des enfants de l'école maternelle pour leur expliquer simplement les gestes barrières pour qu'ils puissent se protéger et protéger les autres du coronavirus et des virus en général. Un dessin animé conçu par l'auteur et adapté de ce livre est également disponible sur YouTube et a dépassé les 100 000 vues en à peine quelques jours.",
                2.95f, Categorie.BEBES, "", auteurs_names, "LesGestesBariiere.jfif", "Deux Coqs d'Or"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Higgins"}));

        livresExpected.add(creerLivre("MAMAN OURS A LA RESCOUSSE", 9782226454140l,
                "Michel, l'ours grincheux, ne supporte pas ses voisins. Ils sont bruyants, envahissants, collants, et ils sont partout, tout le temps. Heureusement, son sale caractère lui assure une paix relative... jusqu'au jour où une énorme tempête se déclare. Tout le monde se réfugie alors chez Michel, qui doit même participer à une chaîne humaine géante pour sauver un petit lapin des bourrasques ! L'ours ronchon, horripilé par cette invasion, risque pourtant bien de changer d'avis : parfois, l'entraide appelle...\n" +
                        "l'entraide. À partir de 5 ans",
                12.00f, Categorie.BEBES, "", auteurs_names, "MamanOursALaRescousse.jfif", "Albin Michel Jeunesse"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Séchan", "Jourdy"}));

        livresExpected.add(creerLivre("CACHÉE OU PAS, J'ARRIVE - UNE AVENTURE SANS AVENTURE DE BARTOK BILOBA", 9782330130152l,
                "Une partie de cache-cache écrite et dessinée à quatre mains. Lolita Séchan et Camille Jourdy s'amusent à faire jouer leur personnages respectifs dans l'univers de la famille Biloba. À partir de 4 ans.",
                13.50f, Categorie.ENFANTS, "", auteurs_names, "cacheeOuPasJarrive.jfif", "Actes Sud BD"

        ));
        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"NOB"}));

        livresExpected.add(creerLivre("LA CANTOCHE, TOME 05 - EN AVANT, MACHE !", 9791036314919l,
                "La cloche a sonné, c'est l'heure du repas, direction... la cantoche ! Tous les enfants se retrouvent dans ce lieu mythique, qu'on connaît forcément de près ou de loin. Entre les batailles de nourriture, les disputes, les chutes et les réclamations auprès du cuisiner fan de légumes, la pause déjeuner peut rapidement se transformer... en catastrophe ! Toujours pas de héros récurrent mais les gags s'enchaînent autour de cet univers délicieux.\n" +
                        "L'auteur de \"Dad\" et de \"Mamette\" permet à chacun de retrouver, avec tendresse et parfois un brin de nostalgie, les mots d'enfants à la cantine, la philosophie de réfectoire et surtout les plats gastronomiques du cuistot !",
                13.50f, Categorie.ENFANTS, "", auteurs_names, "cacheeOuPasJarrive.jfif", "BD Kids",
                "Quand il était petit, Nob voulait devenir pâtissier, pour pouvoir manger des gâteaux toute la journée. C'est finalement vers la bande dessinée qu'il s'est tourné, pour le plus grand plaisir des petits et des grands... Mais il est toujours aussi gourmand !"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Jourdy", "Dunand-Pallaz"}));

        livresExpected.add(creerLivre("LE CHAT RITABLE", 9782350670744l,
                "Il était une fois un petit chat bienveillant, qui toujours secourait les pauvres et les mendiants. Le coeur sur la patte, généreux et fort aimable, ce chat exceptionnel, c'était le chat Ritable.",
                8.50f, Categorie.ENFANTS, "", auteurs_names, "LeChatRitable.jfif", "Balivernes Éditions"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Jolibois", "Heinrich"}));

        livresExpected.add(creerLivre("LES P'TITES POULES - ALBUM COLLECTOR (TOMES 1 A 4) - VOL01", 9782266177054l,
                "Connaissez-vous Carmen, la petite poulette qui en a sous la crête ? Son frère Carmélito, le téméraire petit poulet rose ? Leurs copains Coquenpâte, Coqsix, Molédecoq, Hucocotte et les autres agités du poulailler ? Voyages, humour, émotion, frisson et fantaisie... Voilà ce que vous trouverez dans le collector des quatre premières aventures des P'tites Poules.",
                15.10f, Categorie.ENFANTS, "", auteurs_names, "LesPtitesPoules.jfif", "PKJ"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Cathon"}));

        livresExpected.add(creerLivre("MIMOSE ET SAM, TOME 01 - BASILIC EN PANIQUE ! - HISTOIRE COMPLETE", 9791036310119l,
                "\"Où étiez-vous la nuit dernière ?\"  Mimose et Sam ont lancé leur enquête. Ils veulent découvrir qui a grignoté les feuilles de leur ami Basile. Aucun des insectes interrogés n'admet être le coupable. Les deux amis doivent trouver des moyens pour le démasquer. Mais cela est plus facile à dire qu'à faire ! Il faudra user de beaucoup d'ingéniosité.",
                7.95f, Categorie.ENFANTS, "", auteurs_names, "MimoseEtSam.jfif", "Mini BD KIDS"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Bertrand", "Bonniol"}));

        livresExpected.add(creerLivre("LA VENGEANCE DE CORNEBIDOUILLE", 9782211203166l,
                "Ses parents l’ont envoyé au lit pour avoir renâclé devant sa soupe de légumes. Mais Pierre est décidé à ruser et à trouver un moyen imparable pour éliminer non seulement Cornebidouille, la sorcière coincée dans les cabinets, mais aussi l’horrible potage de sa propre mère !",
                12.70f, Categorie.ENFANTS, "", auteurs_names, "VengeanceCornebidouille.jfif", "JSP"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Pedrosa"}));

        livresExpected.add(creerLivre("L'AGE D'OR - TOME 2",
                9791034732647l,
                "Avec l'hiver, la guerre a commencé. Tandis que les insurgés rassemblent leurs troupes et remontent depuis la Péninsule, la princesse Tilda assiège le château de son frère pour reconquérir son trône. En haut des remparts, en première ligne, les \"gueux\" se préparent à l'assaut.Ce deuxième tome conclut en majesté l'épopée flamboyante de \" L'Age d'or \", ce livre assez puissant pour déchaîner la tempête et la révolution, la force d'une utopie qui donne envie de croire en l'avenir.",
                32.00f, Categorie.ROMANS_ADULTES, "", auteurs_names, "AgeDOr.jfif", "Aire Libre"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Rochette", "Bocquet"}));

        livresExpected.add(creerLivre("AILEFROIDE - ALTITUDE 3954",
                9782203121935l,
                "De Grenoble à la Bérarde en mobylette. Des rappels tirés sur la façade du Lycée Champollion. Avec l'exaltation pure qui tape aux tempes, quand on bivouaque suspendu sous le ciel criblé d'étoiles, où qu'à seize ans à peine on se lance dans des grandes voies. La Dibona, le pilier Frendo, le Coup de Sabre, la Pierre Alain à la Meije, la Rébuffat au Pavé : le Massif des Ecrins tout entier offert comme une terre d'aventure, un royaume, un champ de bataille parfois.\n" +
                        "Car la montagne réclame aussi son dû et la mort rôde dans les couloirs glacés.",
                28.00f, Categorie.ROMANS_ADULTES, "", auteurs_names, "ailefroide.jpg", "Casterman"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Deveney", "Tamarit"}));

        livresExpected.add(creerLivre("GEANTE - ONE-SHOT - GEANTE - HISTOIRE DE CELLE QUI PARCOURUT LE MONDE A LA RECHERCHE DE LA LIBERTE",
                9782413000167l,
                "Elle était une fois Céleste, géante véritable, orpheline recueillie au coeur de la montagne, petite dernière d'une famille de six frères. Et quand vient le temps où chacun s'envole du cocon familial, Céleste veut elle aussi arpenter de nouveaux horizons. De la Vallée aux Marais en passant par Dorsodoro, elle découvrira l'hostilité créée par la différence, les injustices de la guerre ou de la religion mais aussi l'amour et pourquoi pas, au bout du chemin, la liberté d'être elle-même ?",
                27.95f, Categorie.ROMANS_ADULTES, "", auteurs_names, "Geante.jfif", "Editions Delcourt"
        ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Lambda"}));

        livresExpected.add(creerLivre("LE MONDE AU BALCON - CARNET DESSINE D'UN PRINTEMPS CONFINE",
                9782226455789l,
                "J'ai commencé ce carnet en janvier 2020, je voulais dessiner mon quotidien avec légèreté, sans objectif précis... Qui aurait pu prévoir que ce petit projet insouciant allait se changer en journal de bord de l'événement mondial le plus inédit du 21e siècle ? Dessinatrice vedette d'instagram, Sophie Lambda est l'autrice de la remarquable bd tant pis pour l'amour, parue en 2019. Dans le monde au balcon, elle donne aux petites histoires personnelles et grandes réalités collectives un coup de crayon libérateur.",
                18.90f, Categorie.ROMANS_ADULTES, "", auteurs_names, "LeMondeAuBalcon.jfif", "Albin Michel"
                ));

        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Cy"}));

        livresExpected.add(creerLivre("RADIUM GIRLS",
                9782344033449l,
                "\"Des destins de femmes sacrifiées sur l’autel du progrès.\n" +
                        "\n" +
                        "New Jersey, 1918. Edna Bolz entre comme ouvrière à l’United State Radium Corporation, une usine qui fournit l’armée en montres. Aux côtés de Katherine, Mollie, Albina, Quinta et les autres, elle va apprendre le métier qui consiste à peindre des cadrans à l’aide de la peinture Undark (une substance luminescente très précieuse et très chère) à un rythme constant. Mais bien que la charge de travail soit soutenue, l’ambiance à l’usine est assez bonne. Les filles s’entendent bien et sortent même ensemble le soir. Elles se surnomment les « Ghost Girls » : par jeu, elles se peignent les ongles, les dents ou le visage afin d’éblouir (littéralement) les autres une fois la nuit tombée. Mais elles ignorent que, derrière ses propriétés étonnantes, le Radium, cette substance qu’elles manipulent toute la journée et avec laquelle elles jouent, est en réalité mortelle. Et alors que certaines d’entre elles commencent à souffrir d’anémie, de fractures voire de tumeur, des voix s’élèvent pour comprendre. D’autres, pour étouffer l’affaire...\n" +
                        "\n" +
                        "La dessinatrice Cy nous raconte le terrible destin des Radium Girls, ces jeunes femmes injustement sacrifiées sur l’autel du progrès technique. Un parcours de femmes dans la turbulente Amérique des années 1920 où, derrière l’insouciance lumineuse de la jeunesse, se joue une véritable tragédie des temps modernes.\"\n",
                22.00f, Categorie.ROMANS_ADULTES, "", auteurs_names, "radiumGirls.jfif", "Glénat",
                "Autrice de bande dessinée, Cy. est, à la base, graphiste de formation. Après plusieurs années en tant que directrice artistique, elle se lance en freelance pour développer ses projets. Elle publie aux éditions Lapin Le vrai sexe de la vraie vie (tome 1 et 2) où elle prend le parti de montrer des bribes de sexualité sur base de témoignages. Son leitmotiv ; montrer pour déculpabiliser. Sa BD suivante ne parle pas de sexualité, mais de luttes de femmes dans les années 20 aux États-Unis : Radium Girls parait chez Glénat en avril 2020. Réside en région parisienne."
                ));



        auteurs_names = new ArrayList<>(Arrays.asList(new String[]{"Gaiman", "Neyret"}));

        livresExpected.add(creerLivre("CORALINE (ED 2020 ILLUSTRE) - EDITION LUXE ILLUSTREE",
                9782226453587l,
                "Coraline vient d'emménager dans une étrange maison et, comme ses parents n'ont pas le temps de s'occuper d'elle, elle décide de jouer les exploratrices. Ouvrant une porte condamnée, elle pénètre dans un appartement identique au sien. Identique, et pourtant... Dans la droite ligne d'Alice au pays des merveilles, ce roman à l'atmosphère inoubliable a déjà conquis des millions de lecteurs. A partir de 13 ans",
                19.90f, Categorie.ADOS, "", auteurs_names, "Coraline.jfif", "Albin Michel"
                ));
















//        livresExpected.add(new Livre("Magali", "Bonniol"));
//        livresExpected.add(new Livre("Pierre", "Bertrand"));
//        livresExpected.add(new Livre("", "", "Cathon"));
//        livresExpected.add(new Livre("", "", "Cy"));
////        livresExpected.add(4 = new Livre("Magali", "Bonniol"));
//        livresExpected.add(new Livre("J.C.", "Deveney"));
//        livresExpected.add(new Livre("Tania", "Tamarit"));
//        livresExpected.add(new Livre("Neil", "Gaiman"));
//        livresExpected.add(new Livre("Aurélie", "Neyret"));
//        livresExpected.add(new Livre("Ryan T.", "Higgins"));
//        livresExpected.add(new Livre("Philippe", "Jalbert"));
//        livresExpected.add(new Livre("Christian", "Jolibois"));
//        livresExpected.add(new Livre("Christian", "Heinrich"));
//        livresExpected.add(new Livre("Loïc", "Jouannigot"));
//        livresExpected.add(new Livre("Julien", "Béziat"));
//        livresExpected.add(new Livre("Sophie", "Lambda"));
//        livresExpected.add(new Livre("Suzanne", "Lang"));
//        livresExpected.add(new Livre("Max", "Lang"));
//        livresExpected.add(new Livre("", "", "NOB"));
//        livresExpected.add(new Livre("Cyril", "Pedrosa"));
//        livresExpected.add(new Livre("Roxanne", "Moreil"));
//        livresExpected.add(new Livre("Sébastien", "Perez"));
//        livresExpected.add(new Livre("Benjamin", "Lacombe"));
//        livresExpected.add(new Livre("Rémi", "Simard"));
//        livresExpected.add(new Livre("", "", "La Pastèque"));
//        livresExpected.add(new Livre("Olivier", "Bocquet"));
//        livresExpected.add(new Livre("Jean-Marc", "Rochette"));
//        livresExpected.add(new Livre("Jean-François", "Rey"));
//        livresExpected.add(new Livre("Fanny", "Hurtrel"));
//        livresExpected.add(new Livre("Joanne K.", "Rowling", "J.K. Rowling"));
//        livresExpected.add(new Livre("Lolita", "Séchan"));
//        livresExpected.add(new Livre("Camille", "Jourdy"));
//        livresExpected.add(new Livre("Joann", "Sfar"));
//        livresExpected.add(new Livre("Diana", "Wynne Jones"));

//        Map<Long, Livre> mapExpected = mapFromList(livresExpected);
        System.err.println("Size livre expected : " + livresExpected.size());

        System.err.println(livresExpected);
//        System.err.println(mapExpected);

        List<Long> names = livreInBase.stream().map(c -> c.getCodeEAN()).collect(Collectors.toList());


        // Comparer ce qui est en base
        List<Livre> comparison = livresExpected.stream().filter(
                e -> !names.contains(e.getCodeEAN())
        ).collect(Collectors.toList());

        // Si des éléments étaient manquant, on les rajoute en base
        System.err.println("Comparaison : " + comparison.size() + " élément(s) manquant(s)");

        if(comparison.size() > 0){
            livreService.addMultipleLivres(comparison);

            livreInBase = livreService.findAllLivres();
        }

        Map<Long, Livre> map = mapFromList(livreInBase);

        System.err.println(map.keySet());
        System.err.println(map.size());


        return map;
//        System.err.println(e1);
    }


    private Livre creerLivre(String titre, long codeEan, String resume, float prix, Categorie categorie, String collection, List<String> auteurs, String image, String editeur_name){
        Livre livre;
        List<Auteur> auteurs1 = getFromMap(auteurs);
        List<Image> images1 = getImageFromMap(image);
        Editeur editeur = editeurs.get(editeur_name);
        livre = new Livre(codeEan, titre, resume, collection, categorie, new Date(), 10, prix, editeur, auteurs1, images1);

        return livre;

    }

    private Livre creerLivre(String titre, long codeEan, String resume, float prix, Categorie categorie, String collection, List<String> auteurs, String image, String editeur_name, String biblio){
        Livre livre;
        livre = creerLivre(titre, codeEan, resume, prix, categorie, collection, auteurs, image, editeur_name);
        livre.setNotesBiographiques(biblio);
        return livre;

    }

    private List<Auteur> getFromMap(List<String> noms){
        List<Auteur> auteurs_out = new ArrayList<>();

        for (String nom : noms){
            auteurs_out.add(auteurs.get(nom));
        }

        return auteurs_out;
    }

    private List<Image> getImageFromMap(String nom){
        List<Image> image_out = new ArrayList<>();
        image_out.add(images.get(nom));

        return image_out;
    }



    private Map<Long, Livre> mapFromList(List<Livre> livres){
        System.err.println("mapFromList");
//        System.err.println(livres);
        Map<Long, Livre> map = new HashMap<>();

        for(Livre livre : livres){
//            System.err.println(livre);
            map.put(livre.getCodeEAN(), livre);
        }

        System.err.println("map size output :" + map.size());

        return map;
    }
}
