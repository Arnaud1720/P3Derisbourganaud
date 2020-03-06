package com.arnaud.Poo.modes;

import com.arnaud.Poo.*;

public class Duel {

    public Duel() {

    }

    GestionJeu gestionJeu = new GestionJeu();
    ;

    public void HumainVsIa() {
        String modeleIa = "";
        String modeleHumain = "";
        String reponseIa = "";
        String reponseJoueur;
        String combinaisonIa;
        String combinaisonJoueur;
        int tour = 0;

        Player humain = new Player("Arnaud", 0) {
            @Override
            public int getVie() {
                return super.getVie();
            }

            @Override
            public String getNom() {
                return super.getNom();
            }
        };
        Player cpu = new Player("Cpu", 0) {
            @Override
            public int getVie() {
                return super.getVie();
            }

            @Override
            public String getNom() {
                return super.getNom();
            }
        };
        System.out.println("Proposez une combinaison de " + GestionConfiguration.tailleCode + " que l'IA va devoir trouver");
        combinaisonJoueur = gestionJeu.definirCombinaison();
        // l'ia génére une combinaison
        combinaisonIa = gestionJeu.genererConbinaison();


        do {
            System.out.println("Tour: " + (tour + 1));
            // tour Joueur

            if (!modeleIa.equalsIgnoreCase("")) {
                System.out.println(modeleIa);
            }
            System.out.println("Proposez une combinaison de " + GestionConfiguration.tailleCode + " chiffre(s)");

            reponseJoueur = gestionJeu.definirCombinaison();
            modeleIa = gestionJeu.comparerCombinaison(combinaisonIa, reponseJoueur);
            System.out.println("Fin du toujour de " +humain.getNom());
            // tour IA
            System.out.println("début du tour de "+cpu.getNom());
            reponseIa = gestionJeu.genererReponse(reponseIa, modeleHumain);

            System.out.println("Définissez un modele pour chaques chiffres avec les symbôles +, - et = :");
            System.out.println(reponseIa);

            // comparaison de la réponse avec la combinaison à trouver pour générer un modèle
            modeleHumain = gestionJeu.definirModele();
            System.out.println("=========================");
            tour++;
        } while (!combinaisonJoueur.equals(reponseIa) && !combinaisonIa.equals(reponseJoueur));

        if (combinaisonJoueur.equals(reponseIa)&&  !combinaisonIa.equals(reponseJoueur)) {
            System.out.println("bravo" + cpu.getNom() + " vous avez trouver la combinaison du Joueur : " + combinaisonJoueur);
        } else if (combinaisonIa.equals(reponseJoueur)&& !combinaisonJoueur.equals(reponseIa)) {

            System.out.println("bravo" + humain.getNom() + " vous avez trouver la combinaison de l'ia : " + combinaisonIa);
        } else
            System.out.println("Match nul " + combinaisonIa + combinaisonJoueur);

    }


}





