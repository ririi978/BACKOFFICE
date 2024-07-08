package org.sid.msproduct.Service;

import org.sid.msproduct.Entity.Attribute;
import org.sid.msproduct.Repository.AttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AttributeService {
    private final AttributeRepo attributeRepo;

    @Autowired
    public AttributeService(AttributeRepo attributeRepo) {

        this.attributeRepo = attributeRepo;
    }


    public Attribute addAttribute(Attribute attribute) {

        return attributeRepo.save(attribute);
    }


    public Attribute updateAttribute(Attribute attribute) {
        return attributeRepo.save(attribute); // JpaRepository's save method handles both creating and updating.
    }


    public List<Attribute> findAllAttributes() {

        return attributeRepo.findAll();
    }


    public Optional<Attribute> findAttributeById(Long id) {

        return attributeRepo.findById(id);
    }


    public void deleteAttributeById(Long id) {

        attributeRepo.deleteById(id);
    }
}

