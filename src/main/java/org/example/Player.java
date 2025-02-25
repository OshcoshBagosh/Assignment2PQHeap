package org.example;

/**
 * This class contains methods and attributes for the Player Object
 */
public class Player {
    private int score;
    private String name;

    public Player(){ //default constructor
        this.name = "";
        this.score = 0;
    }

    public Player(String name, int score){
        this.name =  name;
        this.score = score;
    }
    public Player(Player other){ //Copy constructor
        this.name = other.name;
        this.score = other.score;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public Player createClone(){
        Player clone = new Player(this);
        return clone;
    }

    /**
     * overrides equals() method so Players with the same name are equal
     * @param o
     * @return True or False
     */
    @Override
    public boolean equals(Object o){
        Player player = (Player)o; //casts Object to Player
        if (this.name.equals(player.name)){
            return true;
        }
        return false;
    }

}
