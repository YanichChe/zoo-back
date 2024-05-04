package ru.nsu.ccfit.chernovskaya.zoo.animal.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualDto;
import ru.nsu.ccfit.chernovskaya.zoo.animal.dto.IndividualRequest;
import ru.nsu.ccfit.chernovskaya.zoo.animal.service.AnimalService;
import ru.nsu.ccfit.chernovskaya.zoo.util.ApiPathUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPathUtils.ANIMAL, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping(ApiPathUtils.INDIVIDUAL + "/{id}")
    public ResponseEntity<IndividualDto> getAnimalById(@PathVariable int id) {
        return ResponseEntity.ok(animalService.getIndividualById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getAllAnimalsCount(
            @RequestParam(required = false) Map<String, String> filters,
            @RequestParam(required = false) List<String> sorts) {

        return ResponseEntity.ok(animalService.getCount(filters, sorts));
    }

    @GetMapping
    public ResponseEntity<List<IndividualDto>> getAllAnimals(
            @RequestParam(required = false) Map<String, String> filters,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false) List<String> sorts) {
        return ResponseEntity.ok(animalService.getAllIndividuals(filters, sorts, page, size));
    }

    @GetMapping(ApiPathUtils.TITLES)
    public ResponseEntity<List<String>> getAllAnimalsTitle() {
        return ResponseEntity.ok(animalService.getAllAnimalsTitle());
    }

    @PostMapping
    public ResponseEntity<Object> saveAnimal(@ModelAttribute IndividualRequest individualRequest) throws IOException {
        animalService.saveAnimal(individualRequest);
        return ResponseEntity.ok().build();
    }
}
