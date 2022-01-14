package com.example.demo.controllers;


import com.example.demo.Model.Expense;
import com.example.demo.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/" ,
                produces = {MediaType.APPLICATION_JSON_VALUE}
               )
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/allExpenses")
    private List<Expense> allExpense(){
            return expenseService.getAllExpense();
    }

    @GetMapping("/expenseByName")
    private Expense expenseByName(@RequestParam String name){
        return expenseService.getByName(name);
    }

    @PostMapping("/addExpense")
    private String addExpense(@RequestBody Expense expense) throws Exception {
        expenseService.createExpense(expense);
        return "Expense Added";
    }

    @DeleteMapping("/deleteExpense")
    private Integer deleteExpense(@RequestParam String name) throws Exception {
        return expenseService.deleteExpense(name);

    }

}
