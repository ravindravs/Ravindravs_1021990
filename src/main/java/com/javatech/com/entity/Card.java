package com.javatech.com.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "card")
@Data
public class Card implements Comparable<Card>{
    @Id
    @GeneratedValue(generator = "card_seq_gen")
    @SequenceGenerator(name = "card_seq_gen", initialValue = 2, allocationSize = 1)
    private Long id;

    @Column
    private String cardNumber;

    @Column
    private String bankName;

    @Column
    private String expiryDate;

    @Override
    public int compareTo(Card o) {
        if (getExpiryDate() == null || o.getExpiryDate() == null) {
            return 0;
        }
        return getExpiryDate().compareTo(o.getExpiryDate());
    }
}

