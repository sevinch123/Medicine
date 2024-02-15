package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;
    private String mondeyOpen;
    private String TuesdayOpen;
    private String WendesdayOpen;
    private String ThursdayOpen;
    private String fridayOpen;
    private String saturdayOpen;
    private String sundayOpen;
    private String mondeyClose;
    private String TuesdayClose;
    private String WendesdayClose;
    private String ThursdayClose;
    private String fridayClose;
    private String saturdayClose;
    private String sundayClose;
    private String phone1;
    private String phone2;
    private String phone3;
    private String phone4;
    private String facebook;
    private String instagram;
    private String telegram;
    private String sayt;
    private Boolean isActive;
    private String companyName;
    private String address;
    private String mail;
    private String cardNumber;
    private String bankName;
}
