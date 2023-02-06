package fr.wf3.alphabetise.config.databaseContentInitialisers;

import fr.wf3.alphabetise.entities.Adresse;
import fr.wf3.alphabetise.entities.User;
import fr.wf3.alphabetise.enums.Role;
import fr.wf3.alphabetise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserContentInitialiser {
    @Autowired
    private UserService userService;

    public Map<String, User> contentInitialiser(){
        // Obtenir tout ce qui est déjà en base
//        List<User> userInBase = new ArrayList<>();
        List<User> userInBase = userService.findAllUsers();
//        System.err.println(editeurInBase);

//        // Future liste de tous les éléments que l'on attend dans la base
        Set<User> usersExpected = new HashSet<>();
//
//        // Peupler la liste attendue
        usersExpected.add(new User("User", "User", "a@a.com", "Passw0rd!",
                new Adresse(
                        "12 rue de la trouvaille", "", "31123", "Une Ville"
                )));
        usersExpected.add(new User("Admin", "Admin", "b@a.com", "Passw0rd!",
                new Adresse(
                        "13 rue de la trouvaille", "", "31123", "Une Ville"
                ), Role.ADMIN));

        System.err.println("user");
        System.err.println(usersExpected);

//
//
//        // Obtenir juste les noms pour faire un filtrage
        List<String> names = new ArrayList<>();

        for(User e : userInBase){
            names.add(e.getEmail());
        }
//
//        // Comparer ce qui est en base
        List<User> missingUser = usersExpected.stream().filter(
                e -> !(names.contains(e.getEmail()))
        ).collect(Collectors.toList());

        System.err.println(missingUser.size());
        System.err.println(missingUser);

        // Si des éléments étaient manquant, on les rajoute en base
        if(missingUser.size() > 0){
            userService.addMultipleUsers(missingUser);

            userInBase = userService.findAllUsers();
        }

        Map<String, User> map = new HashMap<>();

        for(User user : userInBase){
            map.put(user.getEmail(), user);
        }


        return map;
//        System.err.println(e1);
    }

}
