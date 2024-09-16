package com.example.demo.dto.request;

import com.example.demo.utils.EnumPattern;
import com.example.demo.utils.OtherEnumPattern;
import com.example.demo.utils.PhoneNumber;
import com.example.demo.utils.UserStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class UserRequestDetail implements Serializable {

    @NotBlank(message = "first name can not be a blank")
    private String firstName;

    @NotNull(message = "last name can not be a null")
    private String lastName;

    @PhoneNumber(message = "phone invalid format")
    private String phone;

    @Email(message = "email must follow to valid format")
    private String email;

    @NotEmpty(message = "address can not be empty")
    private Set<AddressDTO> address;

    @NotNull(message = "dateOfBirth must be not null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateOfBirth;

    @OtherEnumPattern(anyOf = {UserStatus.ACTIVE, UserStatus.INACTIVE, UserStatus.NONE})
    private UserStatus status;

    public UserRequestDetail(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Set<AddressDTO> getAddress() {
        return address;
    }

    public @NotNull(message = "dateOfBirth must be not null") Date getDateOfBirth() {
        return dateOfBirth;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(@EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE") UserStatus status) {
        this.status = status;
    }

    public void setDateOfBirth(@NotNull(message = "dateOfBirth must be not null") Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(Set<AddressDTO> address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
