package com.example.sgmowltnowtest;

import java.util.HashMap;
enum Axis{
    X,
    Y
}
public class DataTondeuse {
    private int maxX;
    private int maxY;
    private char direction;
    private String result;
    private HashMap<Character,Character> east;
    private HashMap<Character,Character> west;
    private HashMap<Character,Character> north;
    private HashMap<Character,Character> south;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public HashMap<Character, Character> getEast() {
        return east;
    }

    public void setEast(HashMap<Character, Character> east) {
        this.east = east;
    }

    public HashMap<Character, Character> getWest() {
        return west;
    }

    public void setWest(HashMap<Character, Character> west) {
        this.west = west;
    }

    public HashMap<Character, Character> getNorth() {
        return north;
    }

    public void setNorth(HashMap<Character, Character> north) {
        this.north = north;
    }

    public HashMap<Character, Character> getSouth() {
        return south;
    }

    public void setSouth(HashMap<Character, Character> south) {
        this.south = south;
    }
    public Integer getMaxX() {
        return maxX;
    }

    public void setMaxX(Integer maxX) {
        this.maxX = maxX;
    }

    public Integer getMaxY() {
        return maxY;
    }

    public void setMaxY(Integer maxY) {
        this.maxY = maxY;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public DataTondeuse(){
        this.maxX=0;
        this.maxY=0;
        this.direction=' ';
        this.result="";
        this.east = new HashMap<>();
        this.west = new HashMap<>();
        this.north = new HashMap<>();
        this.south = new HashMap<>();
        this.east.put('D','S');
        this.east.put('G','N');
        this.west.put('D','N');
        this.west.put('G','S');
        this.north.put('D','E');
        this.north.put('G','W');
        this.south.put('D','W');
        this.south.put('G','E');
    }
}
