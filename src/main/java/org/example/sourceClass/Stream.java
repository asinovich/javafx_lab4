package org.example.sourceClass;

public class Stream extends Thread{

    private int firstNumber;
    private int secondNumber;
    private int result;

    public int calculate(){
        return this.firstNumber * this.secondNumber;
    }

    public void setting (int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getResult(){
        return this.result;
    }

    @Override
    public void run() {
        result = calculate();
    }


}
