package com.example.demo.services;

import com.example.demo.Model.DueEntity;
import com.example.demo.Repositary.DueRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class DueService {

    private  final DueRepo dueRepo;

    public List<DueEntity> getAllDues(){
        List<DueEntity> dueList = new ArrayList<>();
        dueRepo.findAll().forEach(due -> dueList.add(due));
        return dueList;
    }

    public List<DueEntity> getDuesById(int id){
        return new ArrayList(Collections.singleton(dueRepo.findById(id)));
    }

    public void addDue(DueEntity dueEntity) throws Exception {
        if(dueEntity.getAmount()== null || dueEntity.getAmount() == 0){
            throw new Exception("amount can not be null");
        }
        if(Objects.isNull(dueEntity.getName())){
            throw new Exception("Please Enter Name ");
        }

        if(Objects.isNull(dueEntity.getRepaymentDate())){
            throw new Exception("Date can not be null");
        }

        if(dueEntity == dueRepo.findDueByName(dueEntity.getName())){
            throw new Exception(("Due already exists"));
        }
        dueRepo.save(dueEntity);
    }

    public DueEntity getDueByName(String name){
          DueEntity due = dueRepo.findDueByName(name);
          return due;
    }

    public DueEntity getByOldestDate(){
         return dueRepo.findFirstByOrderByRepaymentDate();
    }

    public  DueEntity getByLatestDate(){
        return dueRepo.findFirstByOrderByRepaymentDateDesc();
    }





}
