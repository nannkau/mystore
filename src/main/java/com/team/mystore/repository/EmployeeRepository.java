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
    List<Employee> findEmployeeNotExistAccount();
    Employee findByEmployeeId(int id);
    @Query(value = "select *" +
            " from employee " +
            " where status='0' ", nativeQuery = true)
    List<Employee> findEmployeeActive();
    @Query("select e from Employee e join e.user u where  u.username =:userName")
    List<Employee> findEmployeeByUserName(@Param("userName") String userName);
    Employee getEmployeeByIdNo(String idNo);
}
