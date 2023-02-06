package fr.wf3.alphabetise.repositories;

import fr.wf3.alphabetise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String mail);
}
