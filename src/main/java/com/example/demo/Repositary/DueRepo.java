package com.example.demo.Repositary;

import com.example.demo.Model.DueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DueRepo extends JpaRepository<DueEntity,Integer> {

    public DueEntity findDueByName(String Name);
    public DueEntity findFirstByOrderByRepaymentDate();
    public DueEntity findFirstByOrderByRepaymentDateDesc();


}
