package com.javatech.com.controller;

import com.javatech.com.dto.CardDto;
import com.javatech.com.entity.Card;
import com.javatech.com.exception.CustomException;
import com.javatech.com.service.CardService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "card", produces = "application/json")
public class TestController {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CardService cardService;

    @PostMapping
    @ApiOperation(value = "Create card", response = CardDto.class)
    public ResponseEntity<CardDto> addCard(
            @RequestBody CardDto cardDto) throws CustomException {
        Card card = modelMapper.map(cardDto, Card.class);
        Card returnCard = cardService.addCard(card);
        CardDto returnCardDto = modelMapper.map(returnCard,
                CardDto.class);
        return new ResponseEntity<CardDto>(returnCardDto, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Get all card list", response = Card.class, responseContainer = "List")
    public ResponseEntity<List<Card>> getAssignmentList()
            throws CustomException {
        List<Card> returnAssignmentList = cardService.getCardList();
        return new ResponseEntity<List<Card>>( returnAssignmentList, HttpStatus.CREATED);
    }
}
