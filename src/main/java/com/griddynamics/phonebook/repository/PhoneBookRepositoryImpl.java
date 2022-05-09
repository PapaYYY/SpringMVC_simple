package com.griddynamics.phonebook.repository;

import com.google.common.collect.ImmutableList;
import com.griddynamics.phonebook.exception.ResourceNotFoundException;
import com.griddynamics.phonebook.model.Record;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PhoneBookRepositoryImpl implements PhoneBookRepository {

    private final Map<String, Record> phoneBookContainer = new HashMap<>();

    @Override
    public List<Record> getAll() {
        return ImmutableList.copyOf(phoneBookContainer.values());
    }

    @Override
    public Record find(String name) {
        return phoneBookContainer.get(name);
    }

    @Override
    public Record add(Record record) {
        return phoneBookContainer.put(record.getName(), record);
    }

    @Override
    public Record update(String name, String phone) {
        Record record = phoneBookContainer.get(name);
        if (!record.getPhoneNumbers().contains(phone)) {
            record.getPhoneNumbers().add(phone);
        } else
            throw new ResourceNotFoundException(String.format("Record for name '%s' already contains provided phone '%s'!",
                    name, phone));
        return record;
    }

    @Override
    public Record delete(String name) {
        return phoneBookContainer.remove(name);
    }
}
