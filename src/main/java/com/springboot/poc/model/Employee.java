package com.springboot.poc.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@Getter @Setter
@Table
public class Employee {

    @PrimaryKey
    @Column("employee_id")
    private String employeeId;

    @Column("first_name")
    private @NonNull String firstName;

    @Column("last_name")
    private @NonNull String lastName;

    @Column("email_id")
    private String email;
}
