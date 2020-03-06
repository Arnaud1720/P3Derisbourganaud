package com.arnaud.Poo.modes;

import com.arnaud.Poo.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Defenseur extends SelectGameMode {
  
  private static final Logger logger = LogManager.getLogger(Defenseur.class);
  
  public void humainSwitchDefenseur(Player humain) {
    GestionJeu gestionJeu = new GestionJeu();
    Player ia = new Player("CPU",5) {
      @Override
      public String getNom() {
        return super.getNom();
      }

      @Override
      public int getVie() {
        return super.getVie();
      }
    };

    String reponse = "";
    String modele = "";
    
    System.out.println("vous avez choisi le mode défenseur");
    System.out.println("vous avez cette fois le rôle de défenseur vous devez saisir une combinaison de " + GestionConfiguration.tailleCode +
      " chiffre(s) \r\nL'intelligence artificielle de l’ordinateur doit faire une proposition d’une combinaison de X chiffres (c’est le rôle attaquant).");
    
    // Le joueur définie une combinaison de x chiffre
    String combinaisonJoueur = gestionJeu.definirCombinaison();
    humain.setVie(GestionConfiguration.nbrEssaisMAX); // TODO add Player class instead of Humain(finish)
    
    
    do {
      System.out.println();
      
      // affichage de la solution dans le mode developpeur
      if (GestionConfiguration.devMode) {
        System.out.println("mode développeur activé ! Combinaison secrete que l'IA doit trouver : "
          + combinaisonJoueur);
      }
      
      System.out.println("L'IA a " + ia.getVie() + "vie(s)");
      System.out.println("Elle propose une combinaison de " + GestionConfiguration.tailleCode + " chiffre(s)");
      
      // génération d'une réponse par l'IA et affichage dans la console
      reponse = gestionJeu.genererReponse(reponse,modele);
      
      System.out.println("Définissez un modele pour chaques chiffres avec les symbôles +, - et = :");
      System.out.println(reponse);
      
      // comparaison de la réponse avec la combinaison à trouver pour générer un modèle
      modele = gestionJeu.definirModele();
      humain.setVie(humain.getVie() - 1);
      
    } while (humain.getVie() != 0 && !combinaisonJoueur.equalsIgnoreCase(reponse));

    if(combinaisonJoueur.equalsIgnoreCase(reponse)){
      System.out.println("Bravo "+ ia.getNom() +" vous avez gagner ! "+ " la combinaison secrête de l'ia était "+combinaisonJoueur);
    }
  }
  
}


