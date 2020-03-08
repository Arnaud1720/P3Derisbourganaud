package com.arnaud.poo;

import com.arnaud.poo.modes.Challengeur;
import com.arnaud.poo.modes.Defenseur;
import com.arnaud.poo.modes.Duel;
import java.util.Scanner;

public  class SelectGameMode {

    static final int CHALLENGER = 1;
    static final int DEFENSEUR = 2;
    static final int DUEL = 3;
    static final int SORTIR = 4;
    public static Scanner sc = new Scanner(System.in);
    
    public static void runMenu() {
        
        Player humain = new Player("Arnaud", 0) {
        };
        
        //The players salect game mode
        System.out.println(" ");
        System.out.println("1 - mode Challenger ");
        System.out.println("2 - mode défenseur ");
        System.out.println("3 - mode duel");
        System.out.println("4 - Sortir du jeu!");
        int modeChoisi = sc.nextInt();

        switch (modeChoisi){
            
            case (CHALLENGER):
                Challengeur challengeur = new Challengeur();
                challengeur.humainSwitchChallengeur(humain);
                break;
            case (DEFENSEUR):
                Defenseur defenseur = new Defenseur();
                defenseur.humainSwitchDefenseur(humain);
                break;
            case (DUEL):
                Duel duel = new Duel();
                System.out.println("vous avez choisi le mode Dueliste L'IA est vous même jouer au tour par tour le premier a avoir trouver la combinaison a gagner");
                duel.HumainVsIa();
                break;
            case (SORTIR):
                System.out.println("au revoir "+humain.getNom());
                break;
            default:
                System.out.println("seulement 3 modes de jeu son disponible");
                runMenu();
        }

    
    }
}
