package org.uade.da1.service.denuncia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uade.da1.model.entity.Denuncia;
import org.uade.da1.repository.DenunciaRepository;

import java.util.List;

@Service
public class DenunciaService {
    @Autowired
    private DenunciaRepository denunciaRepository;

    public List<Denuncia> obtenerTodos() {
        return denunciaRepository.findAll();
    }

    public List<Denuncia> obtenerPorDocumento(String documento) {
        return denunciaRepository.findByDocumento(documento);
    }

    public void guardarDenuncia(Denuncia d) {
        denunciaRepository.save(d);
    }
}
