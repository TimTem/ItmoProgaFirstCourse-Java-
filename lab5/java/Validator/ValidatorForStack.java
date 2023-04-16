package Validator;

import Flat.Flat;

import java.util.Stack;

public class ValidatorForStack {
    public static void validator(Stack<Flat> flats){
        for(Flat flat : flats){
            flat.setId();
        }
    }
}
