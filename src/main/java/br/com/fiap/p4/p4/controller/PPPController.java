package br.com.fiap.p4.p4.controller;

import java.util.Optional;
import java.util.UUID;

import br.com.fiap.p4.p4.dto.PPPDto;
import br.com.fiap.p4.p4.entities.PPP;
import br.com.fiap.p4.p4.service.PPPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ppp")
public class PPPController {

    @Autowired
    private PPPService service;

    @GetMapping
    public ResponseEntity<java.util.Collection<PPPDto>> findAll(){
        var ppp = service.findAll();
        return ResponseEntity.ok(ppp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PPPDto> findById(@PathVariable UUID id){
        var ppp = service.findById(id);
        return ResponseEntity.ok(ppp);
    }

    @PostMapping
    public ResponseEntity<PPPDto> save(@RequestBody PPPDto pppDto){
        pppDto = service.save(pppDto);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(pppDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PPPDto> update(@PathVariable UUID id, @RequestBody PPPDto pppDto) {
        pppDto = service.update(id, pppDto);
        return ResponseEntity.ok(pppDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
