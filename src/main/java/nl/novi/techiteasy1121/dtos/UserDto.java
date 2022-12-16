package nl.novi.techiteasy1121.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import nl.novi.techiteasy1121.models.Authority;

import javax.persistence.Column;
import java.util.Set;

public class UserDto {

    public String username;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String firstname;
    public String lastname;
    public int phoneNumber;
    public String email;
    public String bio;

//    private DriverProfileDto driverProfileDto;

    @JsonSerialize
    public Set<Authority> authorities;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getApikey() {
        return apikey;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

//    public DriverProfileDto getDriverProfileDto() {
//        return driverProfileDto;
//    }
//
//    public void setDriverProfileDto(DriverProfileDto driverProfileDto) {
//        this.driverProfileDto = driverProfileDto;
//    }
}