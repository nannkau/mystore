package com.team.mystore;

import com.team.mystore.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MystoreApplication.class)
public class EmployeeTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void myTest() throws Exception {

        Assert.assertNotNull(employeeRepository.findAll());
    }
}
