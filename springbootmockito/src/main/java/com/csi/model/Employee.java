package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int empId;

    @Pattern(regexp = "[A-Za-z]*", message="First Name could not contain space and special charecter")
    private String empFirstName;

    @Pattern(regexp = "[A-Za-z]*", message="Last Name could not contain space and special charecter")
    private String empLastName;

    @NotNull
    private double empSalary;

    @NotNull
    private long empContactNo;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date empDOB;

    @Email(message="Email id must be valid")
    private String empEmailId;
}
