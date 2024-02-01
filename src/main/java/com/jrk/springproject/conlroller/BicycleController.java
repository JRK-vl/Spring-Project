package com.jrk.springproject.conlroller;

import com.jrk.springproject.entity.Bicycle;
import com.jrk.springproject.service.BicycleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/bicycles")
@AllArgsConstructor
public class BicycleController {

    private final BicycleService bicycleService;

    @GetMapping
    public ResponseEntity<List<Bicycle>> readAll(){
        return new ResponseEntity<>(bicycleService.readAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bicycle> readById(@PathVariable Long id){
        return new ResponseEntity<>(bicycleService.readById(id), OK);
    }
}
