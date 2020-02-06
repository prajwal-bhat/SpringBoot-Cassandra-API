package com.springboot.poc.repository;


import com.springboot.poc.model.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CassandraRepository<Employee, String> {

}
