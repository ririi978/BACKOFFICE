package org.sid.msproduct.Service;

import org.sid.msproduct.Entity.Option;
import org.sid.msproduct.Repository.OptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OptionService {
    private final OptionRepo optionRepo;

    @Autowired
    public OptionService(OptionRepo optionRepo) {

        this.optionRepo = optionRepo;
    }

    public Page<Option> searchOptions(String title, Pageable pageable) {
        return optionRepo.findByTitleContainingIgnoreCase(title, pageable);
    }
    public Option addOption(Option option) {

        return optionRepo.save(option);
    }


    public Option updateOption(Option option) {
        return optionRepo.save(option);
    }


    public List<Option> findAllOptions() {

        return optionRepo.findAll();
    }


    public Optional<Option> findOptionById(Long id) {

        return optionRepo.findById(id);
    }


    public void deleteOptionById(Long id) {

        optionRepo.deleteById(id);
    }
}
