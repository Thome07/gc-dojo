package com.gc_dojo.demo.repositories;

import com.gc_dojo.demo.enums.Raca;
import com.gc_dojo.demo.models.Pirata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PiratesRepositories extends JpaRepository<Pirata,Integer> {

    // e agora?
    Optional<Pirata> findByRace(Raca race);
}
