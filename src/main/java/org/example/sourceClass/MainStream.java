package org.example.sourceClass;

import java.util.ArrayList;

public class MainStream {

    private ArrayList<Integer> firstVector;
    private ArrayList<Integer> secondVector;
    private int result = 0;

    public MainStream(ArrayList<Integer> vectorA, ArrayList<Integer> vectorB){
        this.firstVector = vectorA;
        this.secondVector = vectorB;
        this.result = 0;
    }

    public synchronized void calculateValue() throws InterruptedException {

        for(int i = 0; i < 3; i++) {
            Stream s = new Stream();
            s.setting(this.firstVector.get(i), this.secondVector.get(i));
            s.start();
            s.join();
            result += s.getResult();
        }

    }

    public int getResult(){
        return this.result;
    }

}
