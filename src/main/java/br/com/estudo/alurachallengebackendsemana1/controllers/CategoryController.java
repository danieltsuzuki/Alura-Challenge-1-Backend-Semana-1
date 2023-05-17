package br.com.estudo.alurachallengebackendsemana1.controllers;

import br.com.estudo.alurachallengebackendsemana1.domain.entities.Category;
import br.com.estudo.alurachallengebackendsemana1.domain.entities.Video;
import br.com.estudo.alurachallengebackendsemana1.dtos.category.CategoryDTO;
import br.com.estudo.alurachallengebackendsemana1.dtos.category.CategoryDTOInsert;
import br.com.estudo.alurachallengebackendsemana1.servicies.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
        CategoryDTO categoryDTO = new CategoryDTO(service.findById(id));
        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryDTOInsert> post(@RequestBody @Valid CategoryDTOInsert categoryDTO, UriComponentsBuilder uriBuilder) {
        Category categoryInsert = service.save(new Category(categoryDTO));

        URI uri = uriBuilder.path("/{id}").buildAndExpand(categoryInsert.getId()).toUri();

        return ResponseEntity.created(uri).body(categoryDTO);
    }
}
