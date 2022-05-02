package com.griddynamics.phonebook.controller;

import com.griddynamics.phonebook.exception.ResourceNotFoundException;
import com.griddynamics.phonebook.model.Record;
import com.griddynamics.phonebook.service.PhoneBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("rest")
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class PhoneBookController {
    
    private final PhoneBookService phoneBookService;

    @GetMapping("/phoneBook")
    public List<Record> getAllRecords() {
        return phoneBookService.getAllRecords();
    }

    // Find
    @GetMapping("/phoneBook/{name}")
    public Record findRecordByName(@PathVariable String name) throws ResourceNotFoundException {
        return phoneBookService.findRecordByName(name);
    }

    // Update
    @PutMapping("/phoneBook/{name}")
    public Record updateRecord(@PathVariable String name, @RequestBody Record theRecord) throws ResourceNotFoundException {
        return phoneBookService.updateRecord(name, theRecord);
    }

    @PostMapping("/phoneBook")
    @ResponseStatus(HttpStatus.CREATED)
    public Record createRecord(@RequestBody Record record) throws ResourceNotFoundException {
        return phoneBookService.addRecord(record);
    }

    //delete
    @DeleteMapping("/phoneBook/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Record deleteRecord(@PathVariable String name) throws ResourceNotFoundException {
        return phoneBookService.deleteRecord(name);
    }

}

