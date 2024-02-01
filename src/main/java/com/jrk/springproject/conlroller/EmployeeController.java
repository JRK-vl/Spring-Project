package com.jrk.springproject.conlroller;

import com.jrk.springproject.dto.EmployeeDTO;
import com.jrk.springproject.entity.Employee;
import com.jrk.springproject.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeDTO dto){
        return new ResponseEntity<>(employeeService.create(dto), OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> readAll(){
        return new ResponseEntity<>(employeeService.readAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> readById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.readById(id), OK);
    }

    @GetMapping("bicycles/{id}")
    public ResponseEntity<List<Employee>> readByBicycleId(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.readByBicycleId(id), OK);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.update(employee), OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        employeeService.delete(id);
        return OK;
    }
}
