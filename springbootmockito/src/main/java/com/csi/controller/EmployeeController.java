package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRespositiry;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    EmployeeRespositiry employeeRespositiry;


    @PostMapping("/savedata")
    public ResponseEntity<Employee>saveData(@Valid @RequestBody Employee employee){
        log.info("trying to save data for Employee:"+employee.getEmpFirstName());
        return new ResponseEntity<>(employeeServiceImpl.saveData(employee), HttpStatus.CREATED);
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>>getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping("/updateData/{empId}")
    public ResponseEntity<Employee>updateData(@Valid @PathVariable int empId, @RequestBody Employee employee){
        Employee employee1= employeeRespositiry.findById(empId).orElseThrow(() -> new RecordNotFoundException("Id does not exist"));
        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpLastName(employee.getEmpLastName());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpEmailId(employee.getEmpEmailId());

        return new ResponseEntity<>(employeeServiceImpl.updateData(employee1),HttpStatus.CREATED);
    }
    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId) {
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("Delete data sucessfully");
    }

    @DeleteMapping("/deletedata")
    public ResponseEntity<String> deleteAllData() {
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("Delete data sucessfully");
    }

}
