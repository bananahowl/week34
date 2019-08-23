/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ahmed
 */
 
public class Animal {
    private String type;
    private int bithYear;
    private String sound;

    public Animal(String type, int bithYear, String sound) {
        this.type = type;
        this.bithYear = bithYear;
        this.sound = sound;
    }

    public Animal() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBithYear() {
        return bithYear;
    }

    public void setBithYear(int bithYear) {
        this.bithYear = bithYear;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
    
    
    
}
