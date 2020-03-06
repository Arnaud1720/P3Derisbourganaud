package com.arnaud.Poo;

public class Main {
    
    public static void main(String[] args) {
        
        //affiche la configuration du joueur en début de jeu
        GestionConfiguration.afficheConfiguration();

        /**
         * @param true == new Humain
         * @param false == new Ia
         */

        // le joueur Selectione un mode de jeu
        System.out.println("Veillez selectionner un mode de jeu: ");
        SelectGameMode selectGameMode = new SelectGameMode();
        selectGameMode.runMenu();
        

    }
    
}