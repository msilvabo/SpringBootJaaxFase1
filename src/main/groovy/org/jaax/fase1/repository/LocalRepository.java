package org.jaax.fase1.repository;

import org.jaax.fase1.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {

    @Query("SELECT l FROM Local l where l.name = :name")
    Optional<Local> findByNameJPQL(String name);

    Optional<Local> findByName(String name);

    Optional<Local> findByNameIgnoreCase(String name);
}
