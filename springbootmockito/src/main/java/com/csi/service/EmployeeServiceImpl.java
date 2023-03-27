package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRespositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee saveData(Employee employee){
        return employeeDaoImpl.saveData(employee);
    }

    public List<Employee> getAllData(){
        return employeeDaoImpl.getAllData();
    }
    public Employee updateData(Employee employee){
        return employeeDaoImpl. updateData(employee);
    }
    public void deleteAllData(){
        employeeDaoImpl.deleteAllData();
    }
    public void deleteById(int empId){
        employeeDaoImpl.deleteById(empId);
    }
}
