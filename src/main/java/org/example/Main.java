package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void heapsort(Player[] pa){
        PQHeap heap = new PQHeap();
        for (int i = 0; i < pa.length; i++) {
            heap.add(pa[i]);
        }// end - For

        int sortedNextOpen = 0;
        Player max;
        while (!heap.isEmpty()){
            max = heap.getHighestScorePlayer();
            pa[sortedNextOpen] = max;
            sortedNextOpen ++;
        }
    }// end - heapsort
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("players.txt");
            Scanner infile = new Scanner(fr);
            String line;
            String line2;
            int score;
            Player[] pList = new Player[1000];
            int i = 0;

            while (infile.hasNextLine()) {
                line = infile.nextLine();
                line2 = infile.nextLine();
                score = Integer.parseInt(line2);
                Player player = new Player(line, score);
                pList[i] = player;
                i++;
            }
            for (Player player : pList){
                System.out.print("(" + player.getName() + " " + player.getScore() + ") ");
            }
            System.out.println();
            infile.close();

            heapsort(pList);
            for (Player player : pList){
                System.out.print("(" + player.getName() + " " + player.getScore() + ") ");
            }
        }

        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}