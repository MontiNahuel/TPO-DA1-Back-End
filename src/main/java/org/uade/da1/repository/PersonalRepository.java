package org.uade.da1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uade.da1.model.entity.Personal;

public interface PersonalRepository extends JpaRepository<Personal, Integer> {
    public Personal findByLegajo(Integer legajo);
}
