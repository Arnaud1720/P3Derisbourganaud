package com.arnaud.Poo.modes;

import com.arnaud.Poo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Defenseur extends GestionJeu {
  
  private static final Logger logger = LogManager.getLogger(Defenseur.class);
  
  public void humainSwitchDefenseur(Player humain) {
    Player ia = new Player("CPU",5);
    String reponse = "";
    String modele = "";
    
    System.out.println("vous avez choisi le mode défenseur");
    System.out.println("vous avez cette fois le rôle de défenseur vous devez saisir une combinaison de " + GestionConfiguration.tailleCode +
      " chiffre(s) \r\nL'intelligence artificielle de l’ordinateur doit faire une proposition d’une combinaison de X chiffres (c’est le rôle attaquant).");

    // Le joueur définie une combinaison de x chiffre
    String combinaisonJoueur = this.definirCombinaison();
    humain.setVie(GestionConfiguration.nbrEssaisMAX); // TODO add Player class instead of Humain(finish)
    // affichage de la solution dans le mode developpeur

    do {
      System.out.println();

      System.out.println("L'IA a " + ia.getVie() + "vie(s)");
      System.out.println("Elle propose une combinaison de " + GestionConfiguration.tailleCode + " chiffre(s)");
      
      // génération d'une réponse par l'IA et affichage dans la console
      reponse = this.genererReponse(reponse,modele);
      
      System.out.println("Définissez un modele pour chaques chiffres avec les symbôles +, - et = :");
      System.out.println(reponse);
      
      // comparaison de la réponse avec la combinaison à trouver pour générer un modèle
      modele = this.definirModele();
      ia.setVie(ia.getVie() - 1);
      if(ia.getVie()==0){
        System.out.println("Vous avez gagner l'ia n'a pas trouver la combinaison retour au menu");
        SelectGameMode.runMenu();
      }
    } while (humain.getVie() != 0 && !combinaisonJoueur.equalsIgnoreCase(reponse));

    if(combinaisonJoueur.equalsIgnoreCase(reponse)){
      System.out.println("Bravo "+ ia.getNom() +" vous avez gagner ! "+ " la combinaison secrête de l'ia était "+combinaisonJoueur);
      SelectGameMode.runMenu();
    }
  }
  
}


