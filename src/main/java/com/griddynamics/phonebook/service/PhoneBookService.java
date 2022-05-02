package com.griddynamics.phonebook.service;

import com.griddynamics.phonebook.model.Record;
import com.griddynamics.phonebook.exception.ResourceNotFoundException;

import java.util.List;

public interface PhoneBookService {

    List<Record> getAllRecords();

    Record findRecordByName(String name) throws ResourceNotFoundException;

    Record addRecord(Record record) throws ResourceNotFoundException;

    Record updateRecord(String name, Record record) throws ResourceNotFoundException;

    Record deleteRecord(String name) throws ResourceNotFoundException;
    
}
    
