package com.griddynamics.phonebook.service;

import com.google.common.collect.ImmutableList;
import com.griddynamics.phonebook.exception.ResourceNotFoundException;
import com.griddynamics.phonebook.model.Record;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    private Map<String, Record> phoneBookContainer = new HashMap<>();

    @Override
    public List<Record> getAllRecords() {
        return ImmutableList.copyOf(phoneBookContainer.values());
    }

    @Override
    public Record findRecordByName(String name) throws ResourceNotFoundException {
        Record theRecord = phoneBookContainer.get(name);
        if (null != theRecord) return theRecord;
        else throw new ResourceNotFoundException(String.format("Record for name '%s' not found!", name));
    }

    @Override
    public Record updateRecord(String name, Record theRecord) throws ResourceNotFoundException {
        Record record = findRecordByName(name);
        if (!CollectionUtils.containsAny(record.getPhoneNumbers(), theRecord.getPhoneNumbers())) {
            record.getPhoneNumbers().addAll(theRecord.getPhoneNumbers());
        } else
            throw new ResourceNotFoundException(String.format("Record for name '%s' already contains some of provided phones '%s'!",
                    name, theRecord.getPhoneNumbers()));
        return record;
    }

    @Override
    public Record addRecord(Record theRecord) throws ResourceNotFoundException {
        if (phoneBookContainer.get(theRecord.getName()) != null) {
            throw new ResourceNotFoundException(String.format("Record for name '%s' already exists!", theRecord.getName()));
        } else phoneBookContainer.put(theRecord.getName(), theRecord);
        return theRecord;
    }

    @Override
    public Record deleteRecord(String name) throws ResourceNotFoundException {
        Record record = phoneBookContainer.remove(name);
        if (record == null) throw new ResourceNotFoundException(String.format("Record for name '%s' not found!", name));
        return record;
    }
}
