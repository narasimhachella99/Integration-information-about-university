package com.example.university.controller;

import com.example.university.model.Scholarship;
import com.example.university.model.Stream;
import com.example.university.model.University;
import com.example.university.service.IScholarshipService;
import com.example.university.service.IStreamService;
import com.example.university.service.IUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class UniversityController {
    @Autowired
    private IUniversityService universityService;
    @Autowired
    private IStreamService streamService;
    @Autowired
    private IScholarshipService scholarshipService;

    @GetMapping("/university/{id}")
    private ResponseEntity<?> getById(@PathVariable String id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(universityService.getById(id),HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getByLocation/{location}")
    private ResponseEntity<?> getByLocation(@PathVariable String location) {
        HashMap<String, String> res = new HashMap<>();
        try {
            List<University> universities= universityService.all();
            Set<University> universitySet= new HashSet<>();
            for(University u:universities){
                if(u.getLocation().equals(location)){
                    universitySet.add(u);
                }
            }
            return new ResponseEntity<>(universitySet,HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/locations")
    private ResponseEntity<?> all() {
        HashMap<String, String> res = new HashMap<>();
        try {
            Set<String> locations= new HashSet<>();
            List<University>universities=universityService.all();
            for(University u:universities){
                locations.add(u.getLocation());
            }
            return new ResponseEntity<>(locations, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     
    @GetMapping("/university")
    private ResponseEntity<?> addUser() {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(universityService.all(), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/scholarshipData")
    private ResponseEntity<?> ScholarshipData(@RequestBody HashMap<String,String[]> body) {
        String[] data = body.get("universities");
        HashMap<String, String> res = new HashMap<>();
        List<Scholarship> scholarships = new ArrayList<>();
        try {
            for(String u:data) {
                University university=universityService.getById(u);
                scholarships.add(university.getScholarship());
            }
            System.out.println(scholarships);
            return new ResponseEntity<>(scholarships, HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/university")
    private ResponseEntity<?> addUser(@RequestBody University user) {
        HashMap<String, String> res = new HashMap<>();
        try {
            return new ResponseEntity<>(universityService.add(user), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addScholarship/{id}/{sId}")
    private ResponseEntity<?> add(@PathVariable String id,@PathVariable String sId) {
        HashMap<String, String> res = new HashMap<>();
        try {
            University university=universityService.getById(id);
            Scholarship stream=scholarshipService.getById(sId);
            university.setScholarship(stream);
            return new ResponseEntity<>(universityService.update(university), HttpStatus.OK);

        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addStream/{id}/{sId}")
    private ResponseEntity<?> addUser(@PathVariable String id,@PathVariable String sId) {
        HashMap<String, String> res = new HashMap<>();
        try {
            University university=universityService.getById(id);
            Stream stream=streamService.getById(sId);
            university.getStreams().add(stream);
            return new ResponseEntity<>(universityService.update(university), HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/university/{id}")
    private ResponseEntity<?> addUser(@PathVariable String id) {
        HashMap<String, String> res = new HashMap<>();
        try {
            universityService.delete(id);
            res.put("msg","Course deleted successfully");
            return new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            res.put("msg", e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
