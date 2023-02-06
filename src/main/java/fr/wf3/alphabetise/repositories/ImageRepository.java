package fr.wf3.alphabetise.repositories;

import fr.wf3.alphabetise.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
