package com.example.demo.Repositary;

import com.example.demo.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface ExpenseRepo extends JpaRepository<Expense,Integer> {
    public Expense findByCommodityName(String commodityName);
    @Transactional
    public Integer deleteExpenseByCommodityName(String name);
}
