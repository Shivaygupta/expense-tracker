package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Expense")
@Data
public class Expense {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date timestamp;
    @PrePersist
    private void onCreate() {
        timestamp = new Date();
    }
    @Column
    private String commodityName;
    @Column
    private  String place;
    @Column
    private String modeOfPayment;
    @Column
    private Integer billNo;

}
