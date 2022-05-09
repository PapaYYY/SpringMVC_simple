package com.griddynamics.phonebook.repository;

import com.griddynamics.phonebook.model.Record;

import java.util.List;

public interface PhoneBookRepository {

    List<Record> getAll();

    Record find(String name);

    Record add(Record record);

    Record update(String name, String phone);

    Record delete(String name);
}
