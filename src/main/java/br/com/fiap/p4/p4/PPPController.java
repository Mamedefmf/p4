package br.com.fiap.p4.p4;

import java.util.Optional;
import java.util.UUID;

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
    public ResponseEntity<java.util.Collection<PPP>> findAll(){
        var ppp = service.findAll();
        return ResponseEntity.ok(ppp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PPP>> findById(@PathVariable UUID id){
        var ppp = service.findById(id);
        return ResponseEntity.ok(ppp);
    }

    @PostMapping
    public ResponseEntity<PPP> save(@RequestBody PPP ppp){
        ppp = service.save(ppp);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(ppp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PPP> update(@PathVariable UUID id, @RequestBody PPP ppp) {
        ppp = service.update(id, ppp);
        return ResponseEntity.ok(ppp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
