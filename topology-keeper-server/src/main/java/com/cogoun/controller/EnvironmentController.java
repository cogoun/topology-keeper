package com.cogoun.controller;

import antlr.ASTNULLType;
import com.cogoun.domain.Environment;
import com.cogoun.entity.EnvironmentEntity;
import com.cogoun.repository.EnvironmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/environment")
public class EnvironmentController {

    @Autowired
    private EnvironmentRepository environmentRepository;

    @CrossOrigin
    @PostMapping(produces = "application/json")
    @ResponseBody
    public Environment create(@RequestBody Environment environment) {
        EnvironmentEntity environmentEntity = new EnvironmentEntity();
        BeanUtils.copyProperties(environment, environmentEntity);
        environmentEntity = environmentRepository.save(environmentEntity);
        BeanUtils.copyProperties(environmentEntity, environment);
        return environment;
    }

    @CrossOrigin
    @GetMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public List<Environment> all() {
        List<Environment> environments = new ArrayList<>();
        List<EnvironmentEntity> environmentEntities = environmentRepository.findAll();
        environmentEntities.stream().forEach(environmentEntity -> {
            Environment environment = new Environment();
            BeanUtils.copyProperties(environmentEntity, environment);
            environments.add(environment);
        });
        return environments;
    }

    @CrossOrigin
    @GetMapping(value = "/{environmentId}", produces = "application/json")
    @ResponseBody
    public Environment submittedByUser(@PathVariable long environmentId) {
        EnvironmentEntity environmentEntity = environmentRepository.findById(environmentId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Environment environment = new Environment();
        BeanUtils.copyProperties(environmentEntity, environment);
        return environment;
    }

    @CrossOrigin
    @DeleteMapping(value = "/{environmentId}", produces = "application/json")
    @ResponseBody
    public void delete(@PathVariable long environmentId) {
        EnvironmentEntity environmentEntity = environmentRepository.findById(environmentId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        environmentRepository.delete(environmentEntity);
    }
}
