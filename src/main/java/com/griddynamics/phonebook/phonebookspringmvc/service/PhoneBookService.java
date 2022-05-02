package com.griddynamics.phonebook.phonebookspringmvc.service;

import com.griddynamics.phonebook.phonebookspringmvc.exception.ResourceNotFoundException;
import com.griddynamics.phonebook.phonebookspringmvc.model.Record;

import java.util.List;

public interface PhoneBookService {

    List<Record> getAllRecords();

    Record findRecordByName(String name) throws ResourceNotFoundException;

    Record addRecord(Record record) throws ResourceNotFoundException;

    Record updateRecord(String name, Record record) throws ResourceNotFoundException;

    Record deleteRecord(String name) throws ResourceNotFoundException;
}
    
