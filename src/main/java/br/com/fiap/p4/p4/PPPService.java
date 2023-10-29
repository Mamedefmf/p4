package br.com.fiap.p4.p4;

import java.util.Collection;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PPPService {
    
    @Autowired
    private PPPRepository repo;

    public Collection<PPP> findAll() {
        var ppp = repo.findAll();
        return ppp;
    }

    public PPP findById(UUID id){
        var ppp = repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("Produto não encontrado"));
        return ppp;
    }

    public PPP save(PPP ppp) {
        ppp = repo.save(ppp);
        return ppp;
    }

    public PPP update(UUID id, PPP ppp) {

        try{
             PPP buscaPPP = repo.getReferenceById(id);
        buscaPPP.setDataCriacao(ppp.getDataCriacao());
        buscaPPP.setDescricao(ppp.getDescricao());
        buscaPPP.setResponsavel(ppp.getResponsavel());
        buscaPPP = repo.save(buscaPPP);
        return buscaPPP; 
        } catch(EntityNotFoundException e) {
            throw new ControllerNotFoundException("Produto não encontrado");
        }
    }

    public void delete(UUID id){
        repo.deleteById(id);
    }
}
