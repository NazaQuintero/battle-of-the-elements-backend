package com.nazareno.battleoftheelements.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CharacterErrorResponse {
    int status;
    String message;
    long timeStamp;
}
