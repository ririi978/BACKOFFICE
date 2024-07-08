package org.sid.msproduct.Service;

import org.sid.msproduct.Entity.Family;
import org.sid.msproduct.Repository.FamilyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FamilyService {
    private final FamilyRepo familyRepo;

    @Autowired
    public FamilyService(FamilyRepo familyRepo) {
        this.familyRepo = familyRepo;
    }


    public Family addFamily(Family family) {
        return familyRepo.save(family);
    }


    public Family updateFamily(Family family) {
        return familyRepo.save(family);
    }
    public Page<Family> searchFamilies(String title, Pageable pageable) {
        return familyRepo.findByTitleContainingIgnoreCase(title, pageable);
    }


    public List<Family> findAllFamilies() {
        return familyRepo.findAll();
    }


    public Optional<Family> findFamilyById(Long id) {
        return familyRepo.findById(id);
    }


    public void deleteFamilyById(Long id) {
        familyRepo.deleteById(id);
    }
}
