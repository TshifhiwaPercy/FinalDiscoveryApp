package za.ac.nwu.ac.logic.flow.impl;

public class Modulo {
    public Integer doMod(int dividend, int divisor){
        if(divisor == 0){
            throw new RuntimeException("For some reason");
        }
        return dividend%divisor;
    }
}
