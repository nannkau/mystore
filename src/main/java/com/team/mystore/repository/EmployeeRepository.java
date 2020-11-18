package com.team.mystore.repository;

import com.team.mystore.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select *" +
            "from employee " +
            "where employee_id not in (" +
                                    "select user.employee_id " +
                                    "from user)",
            nativeQuery = true)
    public List<Employee> findEmployeeNotExistAccount();
    public Employee findByEmployeeId(int id);
    @Query(value = "select *" +
            " from employee " +
            " where status='0' ", nativeQuery = true)
    public List<Employee> findEmployeeActive();
    @Query("select e from Employee e join e.user u where  u.username =:userName")
    public List<Employee> findEmployeeByUserName(@Param("userName") String userName);
}
