package com.example.getmesocialservice.model;

import com.example.getmesocialservice.Validation.ValidName;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


public class UserDb {

    @Id
    private String id;
    @NotEmpty @ValidName
    private String name;
    @Length(max = 10) @NotEmpty @ValidName
    private String address;
    @Min(value = 13) @Max(value = 150)
    private int age;

    private String profilePicUrl;
    private Date dateAdded;



    public UserDb(String name, String address, int age, String profilePicUrl) {
        this.name = name ;
        this.address = address;
        this.age = age;
        this.profilePicUrl = profilePicUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

}
