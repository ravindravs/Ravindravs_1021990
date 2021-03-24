package com.javatech.com.service;

import com.javatech.com.entity.Card;
import com.javatech.com.exception.CustomException;

import java.util.List;

public interface CardService {

    Card addCard(Card card) throws CustomException;

    List<Card> getCardList() throws CustomException;
}
