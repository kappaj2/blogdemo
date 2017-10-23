package org.jhipster.blog.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class GCUser {
    
    @NotNull
    private String id;
    
    @NotNull
    @Email
    private String email;
    
    @NotBlank
    private String password;
    
    @NotBlank
    private String fullName;
    
    @NotNull
    @Min(1)
    private Integer age;
    
    public GCUser() {
    }
    
    public String getId() {
        return id;
    }
    
    public GCUser setId(String id) {
        this.id = id;
        return this;
    }
    
    public String getEmail() {
        return email;
    }
    
    public GCUser setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public String getPassword() {
        return password;
    }
    
    public GCUser setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public GCUser setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public GCUser setAge(Integer age) {
        this.age = age;
        return this;
    }
}
