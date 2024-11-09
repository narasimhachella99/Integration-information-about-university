package com.example.university.controller;

import com.example.university.model.Course;
import com.example.university.model.Scholarship;
import com.example.university.service.IScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class ScholarshipController {
    @Autowired
    private IScholarshipService scholarshipService;

    @GetMapping("/scholarship")
    private ResponseEntity<?> addUser() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(scholarshipService.all(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/scholarship/{id}")
    private ResponseEntity<?> getById(@PathVariable String id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(scholarshipService.getById(id),HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/scholarship")
    private ResponseEntity<?> addUser(@RequestBody Scholarship user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(scholarshipService.add(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/scholarship/{id}")
    private ResponseEntity<?> addUser(@PathVariable String id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            scholarshipService.delete(id);
            res.put("msg","Course deleted successfully");
            return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
