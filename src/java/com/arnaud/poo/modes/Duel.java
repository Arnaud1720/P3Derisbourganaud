package com.arnaud.poo.modes;

import com.arnaud.poo.*;

public class Duel extends GestionJeu {

    public Duel() {

    }



    public void humainVsIa() {
        String modeleIa = "";
        String modeleHumain = "";
        String reponseIa = "";
        String reponseJoueur;
        String combinaisonIa;
        String combinaisonJoueur;
        int tour = 0;

        Player humain = new Player("Arnaud", 0) ;
        Player cpu = new Player("Cpu", 0) ;

        System.out.println("Proposez une combinaison de " + GestionConfiguration.tailleCode + " que l'IA va devoir trouver");
        combinaisonJoueur = this.definirCombinaison();
        // l'ia génére une combinaison
        combinaisonIa = this.genererConbinaison();
        if (GestionConfiguration.devMode==true) {
            System.out.println("mode développeur activé ! Combinaison secrete l'IA : " + combinaisonIa);
        }

        do {
            System.out.println("Tour: " + (tour + 1));
            // tour Joueur

            if (!modeleIa.equalsIgnoreCase("")) {
                System.out.println(modeleIa);
            }
            System.out.println("Proposez une combinaison de " + GestionConfiguration.tailleCode + " chiffre(s)");

            reponseJoueur = this.definirCombinaison();
            modeleIa = this.comparerCombinaison(combinaisonIa, reponseJoueur);
            System.out.println("Fin du tour de " +humain.getNom());
            // tour IA
            System.out.println("début du tour de "+cpu.getNom());
            reponseIa = this.genererReponse(reponseIa, modeleHumain);

            System.out.println("Définissez un modele pour chaques chiffres avec les symbôles +, - et = :");
            System.out.println(reponseIa);

            // comparaison de la réponse avec la combinaison à trouver pour générer un modèle
            modeleHumain = this.definirModele();
            System.out.println("=========================");
            tour++;
        } while (!combinaisonJoueur.equals(reponseIa) && !combinaisonIa.equals(reponseJoueur));

        if (combinaisonJoueur.equals(reponseIa)&&  !combinaisonIa.equals(reponseJoueur)) {
            System.out.println("bravo" + cpu.getNom() + " vous avez trouver la combinaison du Joueur : " + combinaisonJoueur);
            SelectGameMode.runMenu();
        } else if (combinaisonIa.equals(reponseJoueur)&& !combinaisonJoueur.equals(reponseIa)) {

            System.out.println("bravo" + humain.getNom() + " vous avez trouver la combinaison de l'ia : " + combinaisonIa);
            SelectGameMode.runMenu();
        } else
            System.out.println("Match nul " + combinaisonIa + combinaisonJoueur);
            SelectGameMode.runMenu();
    }


}





