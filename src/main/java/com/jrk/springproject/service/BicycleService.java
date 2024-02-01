package com.jrk.springproject.service;

import com.jrk.springproject.entity.Bicycle;
import com.jrk.springproject.repository.BicycleRepository;
import lombok.AllArgsConstructor;
import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BicycleService {

    private final BicycleRepository bicycleRepository;

    public List<Bicycle> readAll(){
        return bicycleRepository.findAll();
    }

    public Bicycle readById(Long id){
        return bicycleRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
