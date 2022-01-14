package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "DueEntity")
public class DueEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    @Temporal(TemporalType.DATE)
    private Date repaymentDate;
    @Column
    private Integer amount;
    @Column
    private String reasonForDue;




}
