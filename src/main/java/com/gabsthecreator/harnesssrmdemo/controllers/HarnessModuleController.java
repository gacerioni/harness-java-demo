package com.gabsthecreator.harnesssrmdemo.controllers;

import com.gabsthecreator.harnesssrmdemo.dtos.HarnessModuleDto;
import com.gabsthecreator.harnesssrmdemo.models.HarnessModuleModel;
import com.gabsthecreator.harnesssrmdemo.services.HarnessModuleService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "api/v1/harness-modules")
public class HarnessModuleController {

    final HarnessModuleService harnessModuleService;


    public HarnessModuleController(HarnessModuleService harnessModuleService) {
        this.harnessModuleService = harnessModuleService;
    }

    @PostMapping
    public ResponseEntity<Object> saveHarnessModule(@RequestBody @Valid HarnessModuleDto harnessModuleDto) {

        if(harnessModuleService.existsByShortName(harnessModuleDto.getShortName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This module '"+ harnessModuleDto.getShortName() + "' already exists!");
        }

        var harnessModuleModel = new HarnessModuleModel();
        BeanUtils.copyProperties(harnessModuleDto, harnessModuleModel);

        //System.out.println("Object: " + harnessModuleModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(harnessModuleService.save(harnessModuleModel));
    }

    @GetMapping
    public ResponseEntity<List<HarnessModuleModel>> getAllHarnessModules(){
        return ResponseEntity.status(HttpStatus.OK).body(harnessModuleService.findAll());
    }

    @GetMapping("/{shortname}")
    public ResponseEntity<Object> getOneHarnessModule(@PathVariable(value = "shortname") String shortName){
        System.out.println("shortName FROM GET: " + shortName);
        Optional<HarnessModuleModel> harnessModuleModelOptional = harnessModuleService.findByShortName(shortName.toUpperCase());
        System.out.println("Object: " + harnessModuleModelOptional);
        if (!harnessModuleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A Harness Module with this name was not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(harnessModuleModelOptional.get());
    }

    @DeleteMapping("/{shortname}")
    public ResponseEntity<Object> deleteOneHarnessModule(@PathVariable(value = "shortname") String shortName){
        Optional<HarnessModuleModel> harnessModuleModelOptional = harnessModuleService.findByShortName(shortName.toUpperCase());
        System.out.println("!!! OBJECT: " + harnessModuleModelOptional);
        if (!harnessModuleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A Harness Module with this name was not found.");
        }
        harnessModuleService.delete(harnessModuleModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Harness Module deleted successfully.");
    }

    @PutMapping("/{shortname}")
    public ResponseEntity<Object> updateOneHarnessModule(@PathVariable(value = "shortname") String shortName,
                                                    @RequestBody @Valid HarnessModuleDto harnessModuleDto){
        Optional<HarnessModuleModel> harnessModuleModelOptional = harnessModuleService.findByShortName(shortName.toUpperCase());
        if (!harnessModuleModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A Harness Module with this name was not found.");
        }
        var harnessModuleModel = harnessModuleModelOptional.get();
        harnessModuleModel.setImagePath(harnessModuleDto.getImagePath());
        harnessModuleModel.setUrl(harnessModuleDto.getUrl());
        harnessModuleModel.setDescription(harnessModuleDto.getDescription());

        harnessModuleService.saveByShortName(harnessModuleModel);
        return ResponseEntity.status(HttpStatus.OK).body("alright");
    }



}
