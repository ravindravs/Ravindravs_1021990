package com.javatech.com.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CardDto {

    private Long id;

    private String cardNumber;

    private String bankName;

    private String expiryDate;
}
