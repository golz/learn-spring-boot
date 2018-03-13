package com.blibli.learnspringboot.controller;

import com.blibli.learnspringboot.model.Staff;
import com.blibli.learnspringboot.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("")
    public @ResponseBody Iterable<Staff> getAll () {
        return staffRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Staff getById (
            @RequestParam("id") Long id
            ) {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        Staff staff = optionalStaff.orElse(null);
        return staff;
    }

    @PostMapping("")
    public @ResponseBody
    Staff store (
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("dob") Date dob,
            @RequestParam("gender") String gender,
            @RequestParam("age") int age
            ) {
        Staff staff = new Staff();
        staff.setName(name);
        staff.setEmail(email);
        staff.setDob(dob);
        staff.setGender(gender);
        staff.setAge(age);
        staffRepository.save(staff);

        return staff;
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Staff edit (
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("dob") Date dob,
            @RequestParam("gender") String gender,
            @RequestParam("age") int age
            ) {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        Staff staff = optionalStaff.orElse(null);
        if(null == staff) return null;
        staff.setName(name);
        staff.setEmail(email);
        staff.setDob(dob);
        staff.setGender(gender);
        staff.setAge(age);
        staffRepository.save(staff);

        return staff;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String destroy (
            @PathVariable("id") Long id
            ) {
        staffRepository.deleteById(id);
        return "Success";
    }
}
