package com.reto.mudanzas.service.validation;

public class BusinessValidation {

    public static boolean checkDays(int value) {
        return 1 <= value && value <= 500;
    }

    public static boolean checkElementsQuantity(int value) {
        return 1 <= value && value <= 100;
    }

    public static boolean checkMaxWeight(int value) {
        return 1 <= value && value <= 100;
    }
    
    public static boolean checkTotalWeight(int element,  int maxWeight) {
        return (element * maxWeight) < 50;
    }
    
    
    

}
