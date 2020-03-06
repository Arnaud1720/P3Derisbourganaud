package com.arnaud.Poo;

public abstract class Player {
    /**
     *
     * @param player
     * @return typePlayer
     */

   String nom;
   int vie;

    public Player(String nom, int vie) {
        this.nom = nom;
        this.vie = vie;
    }

    // Getters && Setters
    public int getVie() {
        return vie;
    }
    public void setVie(int vie) {
        this.vie = vie;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

}