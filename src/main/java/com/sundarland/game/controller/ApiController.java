package com.sundarland.game.controller;

import com.sundarland.game.bean.Api;
import com.sundarland.game.services.ApiService;
import com.sundarland.game.services.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private ValidationErrorService validationErrorService;


    @PostMapping("/newApiKey")
    public ResponseEntity<?> addNewApiKey(@Valid @RequestBody Api apiKey, BindingResult result){
        
        ResponseEntity<?> errorMap = validationErrorService.ValidationService(result);
        if(errorMap!=null) return errorMap;

        Api newApiKey=apiService.addNewApiKey(apiKey);
        return new ResponseEntity<Api>(newApiKey, HttpStatus.CREATED);
    }

    @DeleteMapping("/dApi/{key}")
    public ResponseEntity<?> deleteApiKey(@PathVariable Long key){
        apiService.deleteApiKey(key);
        return new ResponseEntity<String>("API key deleted",HttpStatus.OK);}
}
