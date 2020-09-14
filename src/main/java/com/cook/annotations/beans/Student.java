package com.cook.annotations.beans;

import com.cook.annotations.custom.Init;
import com.cook.annotations.custom.JsonElement;
import com.cook.annotations.custom.JsonSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonSerializable
public class Student {
    @JsonElement
    private String firstName;

    @JsonElement
    private String lastName;

    @JsonElement(key = "studentAge")
    private Double age;

    /**
     * Ensures that firstName and lastName starts with Uppercase and rest is all Lowercase.
     */
    @Init
    private void formatNames() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase() +
                this.firstName.substring(1).toLowerCase();
        this.lastName = this.lastName.substring(0, 1).toUpperCase() +
                this.lastName.substring(1).toLowerCase();
    }
}
