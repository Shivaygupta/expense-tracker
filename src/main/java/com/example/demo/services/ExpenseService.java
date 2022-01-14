package com.example.demo.services;

import com.example.demo.Model.Expense;
import com.example.demo.Repositary.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Service
public class ExpenseService {

    @Autowired
    ExpenseRepo expenseRepo;

    public List<Expense> getAllExpense(){
        List<Expense> expenseList = new ArrayList<>();
        expenseRepo.findAll().forEach(expense -> expenseList.add(expense));
        return expenseList;
    }

    public Expense getByName(String name){
        return expenseRepo.findByCommodityName(name);
    }


    public void createExpense(Expense expense) throws Exception {

        if(expense.getAmount() == null || expense.getAmount() == 0 ){
            throw new Exception("Amount can not be null");
        }

        if(Objects.isNull(expense.getCommodityName())){
            throw new Exception("Please Enter Commodity Name");
        }

        expenseRepo.save(expense);
    }

    @Transactional
    public Integer deleteExpense(String name) throws Exception {
        if(Objects.isNull(expenseRepo.findByCommodityName(name))){
            throw  new Exception("Expense does not exist");
        }
        return expenseRepo.deleteExpenseByCommodityName(name);
    }
}
