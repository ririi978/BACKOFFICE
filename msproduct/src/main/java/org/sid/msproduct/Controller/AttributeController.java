package org.sid.msproduct.Controller;

import org.sid.msproduct.Entity.Attribute;
import org.sid.msproduct.Service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attributes")
public class AttributeController {
    private final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }


    @PostMapping
    public ResponseEntity<Attribute> addAttribute(@RequestBody Attribute attribute) {
        Attribute savedAttribute = attributeService.addAttribute(attribute);
        return ResponseEntity.ok(savedAttribute);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Attribute> updateAttribute(@PathVariable Long id, @RequestBody Attribute attribute) {
        attribute.setId(id);
        Attribute updatedAttribute = attributeService.updateAttribute(attribute);
        return ResponseEntity.ok(updatedAttribute);
    }


    @GetMapping
    public ResponseEntity<List<Attribute>> getAllAttributes() {
        List<Attribute> attributes = attributeService.findAllAttributes();
        return ResponseEntity.ok(attributes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable Long id) {
        return attributeService.findAttributeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable Long id) {
        attributeService.deleteAttributeById(id);
        return ResponseEntity.ok().build();
    }
}

