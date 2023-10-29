package br.com.fiap.p4.p4;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPPPService {
    
    @Autowired
    private ItemPPPRepository repo;

    public Collection<ItemPPP> findAll() {
        return repo.findAll();
    }

    public ItemPPP findById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    public ItemPPP save(ItemPPP itemPPP) {
        return repo.save(itemPPP);
    }

    public ItemPPP update(UUID id, ItemPPP itemPPP) {
        if (repo.existsById(id)) {
            itemPPP.setId(id);
            return repo.save(itemPPP);
        }
        return null;
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
