package com.example.sgmowltnowtest;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;

@SpringBootApplication
public class Main {
    public static HashMap<Character,Character> east;
    public static HashMap<Character,Character> west;
    public static HashMap<Character,Character> north;
    public static HashMap<Character,Character> south;

    public static void main(String[] args) throws IOException {
        main();
    }

    public static String main() throws IOException {
        String res = "";
        initialize();
        File file = new File("src/main/java/input4.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
        int maxX = 0,maxY = 0;
        String line = null;
        if ((line = br.readLine()) != null){
            String[] position = line.split(" ");
            maxX = Integer.parseInt(position[0]);
            maxY = Integer.parseInt(position[1]);
        }
        while((line = br.readLine()) != null){
            String[] position = line.split(" ");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            char direction = position[2].charAt(0);
            line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) != 'A'){
                    if(direction == 'E'){
                        direction = east.get(line.charAt(i));
                    }
                    else if(direction == 'W') {
                        direction = west.get(line.charAt(i));
                    }
                    else if(direction == 'N') {
                        direction = north.get(line.charAt(i));
                    }
                    else{
                        direction = south.get(line.charAt(i));
                    }
                }
                else{
                    if(direction == 'W' && x >0){
                        x--;
                    }
                    else if(direction == 'E' && x < maxX){
                        x++;
                    }
                    else if(direction == 'N' && y < maxY){
                        y++;
                    }
                    else if(direction == 'S' && y > 0){
                        y--;
                    }

                }
            }
            res += String.format("%d %d %c ",x,y,direction);
            //System.out.printf("%d %d %c ",x,y,direction);
        }
        return res;
    }
    public static void initialize(){
        east = new HashMap<>();
        west = new HashMap<>();
        north = new HashMap<>();
        south = new HashMap<>();
        east.put('D','S');
        east.put('G','N');
        west.put('D','N');
        west.put('G','S');
        north.put('D','E');
        north.put('G','W');
        south.put('D','W');
        south.put('G','E');
    }
}
