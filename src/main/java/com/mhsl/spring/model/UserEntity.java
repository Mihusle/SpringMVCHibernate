package com.mhsl.spring.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by MHSL on 21.06.2017.
 */
@Entity
@Table(name = "user", schema = "test")
public class UserEntity {
    private int id;
    private String name;
    private Integer age;
    private Boolean isAdmin;
    private Timestamp createdDate;
    
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "name", nullable = true, length = 25)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Basic
    @Column(name = "isAdmin", nullable = true)
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    
    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }
    
    @Basic
    @Column(name = "createdDate", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(createdDate, that.createdDate);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, createdDate);
    }
}
