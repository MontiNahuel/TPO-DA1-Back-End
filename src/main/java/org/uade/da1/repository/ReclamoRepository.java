package org.uade.da1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uade.da1.model.entity.Reclamo;

import java.util.List;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {

    public List<Reclamo> findByDocumento(String doc);
}
