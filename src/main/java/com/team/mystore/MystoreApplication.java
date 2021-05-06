package com.team.mystore;

import com.team.mystore.common.Constants;
import com.team.mystore.entity.Employee;
import com.team.mystore.entity.Role;
import com.team.mystore.entity.User;
import com.team.mystore.repository.EmployeeRepository;
import com.team.mystore.repository.RoleRepository;
import com.team.mystore.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication()
public class MystoreApplication {
    final private RoleRepository roleRepository;
    final private UserRepository userRepository;
    final private PasswordEncoder passwordEncoder;
    final private EmployeeRepository employeeRepository;
    @Autowired
    public MystoreApplication(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, EmployeeRepository employeeRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.employeeRepository = employeeRepository;

    }
    public static void main(String[] args) {
        SpringApplication.run(MystoreApplication.class, args);
    }
    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            if(roleRepository.findAll()==null||roleRepository.findAll().size()<1) {
                Role roleAdmin= new Role();
                roleAdmin.setFlagDelete("0");
                roleAdmin.setName(Constants.ADMIN_ROLE);
                roleRepository.save(roleAdmin);
                Role roleStaff= new Role();
                roleStaff.setFlagDelete("0");
                roleStaff.setName(Constants.STAFF_ROLE);
                roleRepository.save(roleStaff);
                Role roleSeller= new Role();
                roleSeller.setFlagDelete("0");
                roleSeller.setName(Constants.SELLER_ROLE);
                roleRepository.save(roleSeller);
            }
            if (employeeRepository.findAll()==null||employeeRepository.findAll().size()<1)
            {
                Employee employee= new Employee();
                employee.setStatus("0");
                employee.setBirthDate("25/07/1999");
                employee.setIdNo("12345678");
                employee.setPhoneNumber("079954257");
                employee.setName("admin");
                employeeRepository.save(employee);
            }
            if(userRepository.findAll()==null||userRepository.findAll().size()<1) {
                User user= new User();
                user.setEmail("admin@gmail.com");
                user.setUsername("admin");
                Set<Role> roles= new HashSet<>();
                roles.add(roleRepository.getRoleByName("admin"));
                user.setRoles(roles);
                user.setFlagDelete("0");
                user.setEmployee(employeeRepository.getEmployeeByIdNo("12345678"));
                user.setPassword(passwordEncoder.encode("123456"));
                userRepository.save(user);
            }
        };
    }
}
