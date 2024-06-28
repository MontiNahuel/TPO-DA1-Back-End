package org.uade.da1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uade.da1.model.entity.Denuncia;

import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository <Denuncia, Integer>{
    List<Denuncia> findByDocumento(String documento);
}
