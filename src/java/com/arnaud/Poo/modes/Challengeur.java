package com.arnaud.Poo.modes;

import com.arnaud.Poo.GestionConfiguration;
import com.arnaud.Poo.GestionJeu;
import com.arnaud.Poo.Player;
import com.arnaud.Poo.SelectGameMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class Challengeur extends GestionJeu {
  private static final Logger logger = LogManager.getLogger(Challengeur.class);
  public static Scanner sc = new Scanner(System.in);

  public void humainSwitchChallengeur(Player player) {

    Player humain = new Player("Arnaud",5);
    String reponse = "";
    String modele = "";

    logger.info("Vous avez choisi le mode Challenger ");
    logger.info(
      "Dans ce mode de jeu, L'intelligence artificielle de l’ordinateur joue le rôle de défenseur. \r\n"
        +
        "Elle définit une combinaison de " + GestionConfiguration.tailleCode
        + " chiffres aléatoirement." + "\r\n" +
        "Vous avez le rôle d'attaquant vous devez faire une proposition de 4 chiffre");

    // L'IA genere une combinaison de x chiffre
    String combinaisonIa = this.genererConbinaison();
    humain.setVie(GestionConfiguration.nbrEssaisMAX);
    // affichage de la solution dans le mode developpeur
    if (GestionConfiguration.devMode==true) {
      System.out.println("mode développeur activé ! Combinaison secrete l'IA : " + combinaisonIa);
    }

    do {


      System.out.println("Vous avez " + humain.getVie() + "vie(s)");
      System.out.println("Proposez une combinaison de " + GestionConfiguration.tailleCode + " chiffre(s)");
      // affichage du modele pour aider le joueur (pas la première fois)
      if (!modele.equalsIgnoreCase("")) {
        System.out.println(modele);
      }

      // saisie d'une réponse par le joueur
      reponse = this.definirCombinaison();

      // comparaison de la réponse avec la combinaison à trouver pour générer un modèle
      modele = this.comparerCombinaison(combinaisonIa, reponse);
      humain.setVie(humain.getVie() - 1);
      if(humain.getVie()==0){
        System.out.println("vous avez perdu ");
        SelectGameMode.runMenu();
      }

    } while (humain.getVie() != 0 && !combinaisonIa.equalsIgnoreCase(reponse));

    // TODO display victory text or defeat text and give the good answer
    if(combinaisonIa.equalsIgnoreCase(reponse)){
      System.out.println("Bravo "+humain.getNom() +" vous avez gagner ! "+ " la combinaison secrête de l'ia était "+combinaisonIa);
      SelectGameMode.runMenu();
    }
  }
  
}


