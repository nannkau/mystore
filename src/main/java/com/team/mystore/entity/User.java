package com.team.mystore.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email", nullable = false, unique = true )
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "flagDelete", nullable = false)
    private String flagDelete;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(@NotEmpty(message = "Name may not be empty")int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email may not be empty")String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "password may not be empty")String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "username may not be empty")String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(@NotEmpty(message = "role may not be empty")Set<Role> roles) {
        this.roles = roles;
    }

    public String getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(String flagDelete) {
        this.flagDelete = flagDelete;
    }
}

