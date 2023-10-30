package br.com.fiap.p4.p4.service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import br.com.fiap.p4.p4.entities.PPP;
import br.com.fiap.p4.p4.repository.PPPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PPPService {
    
    @Autowired
    private PPPRepository repo;

    public Collection<PPP> findAll() {
        var ppp = repo.findAll();
        return ppp; 
    }

    public Optional<PPP> findById(UUID id){
        var ppp = repo.findById(id);
        return ppp;
    }

    public PPP save(PPP ppp){
        ppp = repo.save(ppp);
        return ppp;
    }

    public PPP update(UUID id, PPP ppp) {
        PPP buscaPPP = repo.getReferenceById(id);
        buscaPPP.setDescricao(ppp.getDescricao());
        buscaPPP.setResponsavel(ppp.getResponsavel());
        buscaPPP.setDataCriacao(ppp.getDataCriacao());
        buscaPPP.setItensPesquisa(ppp.getItensPesquisa());
        buscaPPP = repo.save(buscaPPP);
        return buscaPPP;
    }

    public void delete(UUID id){
        repo.deleteById(id);
    }
}
