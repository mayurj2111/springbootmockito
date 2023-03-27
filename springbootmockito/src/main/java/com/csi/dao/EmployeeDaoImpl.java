package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRespositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl {
    @Autowired
    EmployeeRespositiry employeeRespositiryImpl;

    public Employee saveData(Employee employee){
        return employeeRespositiryImpl.save(employee);
    }

    public List<Employee> getAllData(){
        return employeeRespositiryImpl.findAll();
    }
    public Employee updateData(Employee employee){
        return employeeRespositiryImpl.save(employee);
    }
    public void deleteAllData(){
        employeeRespositiryImpl.deleteAll();
    }
    public void deleteById(int empId){
        employeeRespositiryImpl.deleteById(empId);
    }
}
