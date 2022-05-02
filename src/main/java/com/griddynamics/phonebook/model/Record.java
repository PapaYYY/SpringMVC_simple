package com.griddynamics.phonebook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class Record {

    @NotEmpty
    private String name;

    @NotEmpty
    private Set<String> phoneNumbers;
}
