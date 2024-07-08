package org.sid.msproduct.Controller;

import org.sid.msproduct.Entity.Family;
import org.sid.msproduct.Service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/families")
public class FamilyController {
    private final FamilyService familyService;

    @Autowired
    public FamilyController(FamilyService familyService) {

        this.familyService = familyService;
    }
    @GetMapping("/search")
    public ResponseEntity<Page<Family>> searchFamilies(@RequestParam(required = false) String title, Pageable pageable) {
        Page<Family> families = familyService.searchFamilies(title, pageable);
        return ResponseEntity.ok(families);
    }

    @PostMapping("create")
    public Family addFamily(@RequestBody Family family) {

        return familyService.addFamily(family);
    }

    @PutMapping("/{id}")
    public Family updateFamily(@PathVariable Long id, @RequestBody Family family) {
        family.setId(id);
        return familyService.updateFamily(family);
    }

    @GetMapping
    public List<Family> getAllFamilies() {

        return familyService.findAllFamilies();
    }

    @GetMapping("/{id}")
    public Family getFamilyById(@PathVariable Long id) {

        return familyService.findFamilyById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteFamily(@PathVariable Long id) {

        familyService.deleteFamilyById(id);
    }
}