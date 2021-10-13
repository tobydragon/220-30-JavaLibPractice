package edu.ithaca.dragon.wildlife;

public class Animal {
    private String name;
    private int currentWeight;
    private int idealWeight;
    private long lastFeedingTime;
    
    public Animal(String name, int currentWeight, int idealWeight){
        this.name = name;
        this.currentWeight = currentWeight;
        this.idealWeight = idealWeight;
        this.lastFeedingTime = -1;
    }

    @Override
    public String toString(){
        return name + ":" + currentWeight;
    }

    public String createReport(){
        String response = name + " weighs " + currentWeight + " pounds";
        return  response;
    }

    public void eat(){
        currentWeight +=3;
        lastFeedingTime = System.nanoTime();
    }

    public int getCurrentWeight(){
        return currentWeight;
    }

    public boolean underWeight(){
        return idealWeight>currentWeight;
    }

    public boolean lastMealWasBefore(Animal other){
        return this.lastFeedingTime < other.lastFeedingTime;
    }

}