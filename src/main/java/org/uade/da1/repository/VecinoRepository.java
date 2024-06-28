package org.uade.da1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uade.da1.model.entity.Vecino;

import java.util.List;

public interface VecinoRepository extends JpaRepository<Vecino, String>{
    List<Vecino> findByNombreContains(String name);
}
