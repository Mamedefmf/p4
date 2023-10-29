package br.com.fiap.p4.p4;

import java.util.Collection;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/itens-ppp")
public class ItemPPPController {

    @Autowired
    private ItemPPPService itemPPPService;

    @GetMapping
    public ResponseEntity<Collection<ItemPPP>> findAll() {
        var itemppp = itemPPPService.findAll();
        return ResponseEntity.ok(itemppp);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPPP> findById(@PathVariable UUID id) {
        var itemPPP = itemPPPService.findById(id);
        if (itemPPP != null) {
            return ResponseEntity.ok(itemPPP);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ItemPPP> save(@RequestBody ItemPPP itemPPP) {
        itemPPP = itemPPPService.save(itemPPP);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemPPP);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPPP> update(@PathVariable UUID id, @RequestBody ItemPPP itemPPP) {
        itemPPP = itemPPPService.update(id, itemPPP);
        if (itemPPP != null) {
            return ResponseEntity.ok(itemPPP);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        itemPPPService.delete(id);
        return ResponseEntity.noContent().build();
    }
}