package com.jrk.springproject.service;

import com.jrk.springproject.dto.EmployeeDTO;
import com.jrk.springproject.entity.Employee;
import com.jrk.springproject.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BicycleService bicycleService;

    public Employee create(EmployeeDTO dto){
        Employee employee = Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .gender(dto.getGender())
                .email(dto.getEmail())
                .dateOfBirth(dto.getDateOfBirth())
                .countryOfBirth(dto.getCountryOfBirth())
                .bicycle(bicycleService.readById(dto.getBicycleId()))
                .build();
        return employeeRepository.save(employee);
    }

    public List<Employee> readAll(){
        return employeeRepository.findAll();
    }

    public Employee readById(Long id){
        return employeeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Employee> readByBicycleId(Long id){
        return employeeRepository.findByBicycleId(id);
    }

    public Employee update(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
