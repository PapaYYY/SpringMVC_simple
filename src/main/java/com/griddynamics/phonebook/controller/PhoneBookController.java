package com.griddynamics.phonebook.controller;

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
    public Record findRecordByName(@PathVariable String name) {
        return phoneBookService.findRecordByName(name);
    }

    // Update
    @PutMapping("/phoneBook/{name}/{phone}")
    public Record updateRecord(@PathVariable String name, @PathVariable String phone) {
        return phoneBookService.updateRecord(name, phone);
    }

    @PostMapping("/phoneBook")
    @ResponseStatus(HttpStatus.CREATED)
    public Record createRecord(@RequestBody Record record) {
        return phoneBookService.addRecord(record);
    }

    // Delete
    @DeleteMapping("/phoneBook/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Record deleteRecord(@PathVariable String name) {
        return phoneBookService.deleteRecord(name);
    }

}

