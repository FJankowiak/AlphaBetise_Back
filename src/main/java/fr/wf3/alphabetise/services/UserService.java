package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Adresse;
import fr.wf3.alphabetise.entities.User;
import fr.wf3.alphabetise.exceptions.EmptyFieldException;
import fr.wf3.alphabetise.exceptions.MissingEntityById;
import fr.wf3.alphabetise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IAdresseService adresseService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User addUser(User user){
        if(user.fullEntity()){
            System.err.println("Dans le service user");
            Adresse adresse = adresseService.addAdresse(user.getAdresse());
            System.err.println(adresse);

            user.setAdresse(adresse);
            // Encrypter le mdp
            user.setPassword(encryptPassword(user.getPassword()));
            return userRepository.save(user);
        } else {
            throw new EmptyFieldException("user");
        }
    }

    private User updateUser(User user){
        if(user.fullEntity()){
            return userRepository.save(user);
        } else {
            throw new EmptyFieldException("user");
        }
    }



    public User findById(long id){

        return userRepository.findById(id).orElseThrow(() -> new MissingEntityById("User", id));
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(User user){
        userRepository.deleteById(user.getId());
    }

    public List<User> addMultipleUsers(List<User> users){
        List<User> toBeAdded = users.stream().filter(
                e -> e.fullEntity()
        ).collect(Collectors.toList());

        List<User> notAdded = users.stream().filter(
                e -> !e.fullEntity()
        ).collect(Collectors.toList());

        for(User e : notAdded){
            System.err.println(String.format("User non ajouté à cause de champs obligatoires vides : %s", e.toString()));
        }

        for(User u : toBeAdded){
            Adresse adresse = adresseService.addAdresse(u.getAdresse());
            u.setAdresse(adresse);

            u.setPassword(encryptPassword(u.getPassword()));
        }

        return userRepository.saveAll(toBeAdded);
    }


    private String encryptPassword(String password){
        return passwordEncoder.encode(password);
    }

    private boolean comparePasswords(String rawPassword, String encryptedPasswordInBase){
        return passwordEncoder.matches(rawPassword, encryptedPasswordInBase);
    }


}
