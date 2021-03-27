package com.mehmetpekdemir.tdd.controller.request;

import javax.validation.constraints.NotBlank;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public final class CreateEmployeeRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
