package org.sid.msproduct.Controller;

import org.sid.msproduct.Entity.Option;
import org.sid.msproduct.Service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionController {
    private final OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Option>> searchOptions(@RequestParam(required = false) String title, Pageable pageable) {
        Page<Option> options = optionService.searchOptions(title, pageable);
        return ResponseEntity.ok(options);
    }
    @PostMapping("create")
    public ResponseEntity<Option> addOption(@RequestBody Option option) {
        Option savedOption = optionService.addOption(option);
        return ResponseEntity.ok(savedOption);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Option> updateOption(@PathVariable Long id, @RequestBody Option option) {
        option.setId(id);
        Option updatedOption = optionService.updateOption(option);
        return ResponseEntity.ok(updatedOption);
    }


    @GetMapping
    public ResponseEntity<List<Option>> getAllOptions() {
        List<Option> options = optionService.findAllOptions();
        return ResponseEntity.ok(options);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Option> getOptionById(@PathVariable Long id) {
        return optionService.findOptionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOption(@PathVariable Long id) {
        optionService.deleteOptionById(id);
        return ResponseEntity.ok().build();
    }
}
