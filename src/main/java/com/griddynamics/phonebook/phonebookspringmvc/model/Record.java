package com.griddynamics.phonebook.phonebookspringmvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Record {

    @NotEmpty
    private String name;

    @NotEmpty
    private List<String> phoneNumbers;
}
