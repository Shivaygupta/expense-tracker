package com.example.demo.controllers;

import com.example.demo.Model.DueEntity;
import com.example.demo.services.DueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/" , produces = {MediaType.APPLICATION_JSON_VALUE})
public class DueController {

    @Autowired
    private DueService dueService;

    @GetMapping("/allDues")
    private List<DueEntity> allExpense(){
        return dueService.getAllDues();
    }

    @PostMapping("/addDue")
    private String addDue(@RequestBody DueEntity dueEntity) throws Exception {
        dueService.addDue(dueEntity);
        return "due added";
    }

    @GetMapping("/getByName")
    private  DueEntity getByName(@RequestParam String name){
         return dueService.getDueByName(name);
    }

    @GetMapping("/getDueForOldestRepaymentDate")
    private DueEntity getByOldestDate(){
        return dueService.getByOldestDate();
    }

    @GetMapping("/getDueForNewestRepaymentDate")
    private DueEntity getByLatestDate(){
        return dueService.getByLatestDate();
    }



}
