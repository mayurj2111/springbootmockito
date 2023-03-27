package com.csi.repository;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Repository
public interface EmployeeRespositiry extends JpaRepository<Employee, Integer>{

}
