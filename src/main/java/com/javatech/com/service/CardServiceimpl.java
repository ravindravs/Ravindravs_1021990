package com.javatech.com.service;

import com.javatech.com.entity.Card;
import com.javatech.com.exception.CustomException;
import com.javatech.com.exception.ResourceNotFoundException;
import com.javatech.com.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class CardServiceimpl implements CardService {

    @Autowired
    private CardRepo cardRepo;

    @Override
    public Card addCard(Card card) throws CustomException {
        try {
            String maskedCardNumber = maskCardNumber(card.getCardNumber(),"####-xxxx-xxxx-xxxx");
            Card cardReturn = cardRepo.findById(card.getId()).orElseThrow(
                    () -> new ResourceNotFoundException("Card doesn't exist with id:" + card.getId()));
            card.setCardNumber(maskedCardNumber);
            return cardRepo.save(cardReturn);
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public List<Card> getCardList() throws CustomException {
        try {
            List<Card> cardlist = cardRepo.findAll();
            Collections.sort(cardlist);
            return cardlist;
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    public static String maskCardNumber(String cardNumber, String mask) {

        // format the number
        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }

        // return the masked number
        return maskedNumber.toString();
    }
}

