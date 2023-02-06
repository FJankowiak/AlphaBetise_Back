package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.Evenement;
import fr.wf3.alphabetise.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> findAllUsers();

    public User findById(long id);

    public User addUser(User user);

    // public User updateUser(User user);

    public void deleteUser(User user);

//    public User updatePassword(UserPasswordUpdate update);
}
