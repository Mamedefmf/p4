package br.com.fiap.p4.p4.service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.fiap.p4.p4.controller.exception.ControllerNotFoundException;
import br.com.fiap.p4.p4.dto.PPPDto;
import br.com.fiap.p4.p4.entities.PPP;
import br.com.fiap.p4.p4.repository.PPPRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PPPService {
    
    @Autowired
    private PPPRepository repo;

    public Collection<PPPDto> findAll() {
        var ppp = repo.findAll();
        return ppp.stream().map(this::toPPPdto).collect(Collectors.toList());
    }

    public PPPDto findById(UUID id){
        var ppp = repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("PPP não encontrada"));
        return toPPPdto(ppp);
    }

    public PPPDto save(PPPDto pppDto){
        PPP ppp = toPPP(pppDto);
        ppp = repo.save(ppp);
        return toPPPdto(ppp);
    }

    public PPPDto update(UUID id, PPPDto pppDto) {

        try{
            PPP ppp = repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("PPP não encontrada"));
            ppp.setDescricao(pppDto.descricao());
            ppp.setResponsavel(pppDto.responsavel());
            ppp.setDataCriacao(pppDto.dataCriacao());
            ppp.setItensPesquisa(pppDto.itensPesquisa());
            ppp = repo.save(ppp);

            return toPPPdto(ppp);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("PPP não encontrada");
        }
    }

    public void delete(UUID id){
        repo.deleteById(id);
    }

    private PPPDto toPPPdto(PPP ppp) {
        return new PPPDto(
                ppp.getId(),
                ppp.getDescricao(),
                ppp.getResponsavel(),
                ppp.getDataCriacao(),
                ppp.getItensPesquisa()
        );
    }

    private PPP toPPP(PPPDto pppDTO){
        return new PPP(
                pppDTO.id(),
                pppDTO.descricao(),
                pppDTO.responsavel(),
                pppDTO.dataCriacao(),
                pppDTO.itensPesquisa()
        );
    }
}

