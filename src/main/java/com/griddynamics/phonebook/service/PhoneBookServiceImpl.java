package com.griddynamics.phonebook.service;

import com.griddynamics.phonebook.exception.ResourceNotFoundException;
import com.griddynamics.phonebook.model.Record;
import com.griddynamics.phonebook.repository.PhoneBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneBookServiceImpl implements PhoneBookService {

    private final PhoneBookRepository repository;

    @Override
    public List<Record> getAllRecords() {
        return repository.getAll();
    }

    @Override
    public Record findRecordByName(String name) {
        Record theRecord = repository.find(name);
        if (null != theRecord) return theRecord;
        else throw new ResourceNotFoundException(String.format("Record for name '%s' not found!", name));
    }

    @Override
    public Record updateRecord(String name, String phone) {
        return repository.update(name, phone);
    }

    @Override
    public Record addRecord(Record theRecord) {
        if (repository.find(theRecord.getName()) != null) {
            throw new ResourceNotFoundException(String.format("Record for name '%s' already exists!", theRecord.getName()));
        } else repository.add(theRecord);
        return theRecord;
    }

    @Override
    public Record deleteRecord(String name) throws ResourceNotFoundException {
        Record record = repository.delete(name);
        if (record == null) throw new ResourceNotFoundException(String.format("Record for name '%s' not found!", name));
        return record;
    }
}
