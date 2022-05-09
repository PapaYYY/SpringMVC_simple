package com.griddynamics.phonebook.service;

import com.griddynamics.phonebook.model.Record;

import java.util.List;

public interface PhoneBookService {

    List<Record> getAllRecords();

    Record findRecordByName(String name);

    Record addRecord(Record record);

    Record updateRecord(String name, String phone);

    Record deleteRecord(String name);

}
    
