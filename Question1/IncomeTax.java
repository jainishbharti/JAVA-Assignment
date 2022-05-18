package com.assignment.java.question1;

public class IncomeTax {

    public static double calculateIncomeTax(int salary){
        double taxGenerated = 0;
        if(salary <= 50000) return taxGenerated;
        else if (salary> 50000 && salary <= 60000) {
            taxGenerated = (salary - 50000) * 0.1;
            return taxGenerated;
        } else if ( salary > 60000 && salary <= 150000){
            taxGenerated = (salary - 50000) * 0.2;
        } else if (salary >= 150000) {
            taxGenerated = (salary- 50000) *0.3;

        }
        return taxGenerated;
    }

}
