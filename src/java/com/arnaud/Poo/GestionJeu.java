package com.arnaud.Poo;


import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionJeu {

  public String genererConbinaison (){

    int[] combinaisonRandom = new int[GestionConfiguration.tailleCode];
    int min = 0, max = 9;
    StringBuilder combinaison = new StringBuilder();

    for (int i = 0 ; i < GestionConfiguration.tailleCode ; i++) {
      combinaisonRandom[i] = min + (int) (Math.random() * ((max - min) + 1));
      combinaison.append(combinaisonRandom[i]);
    }

    return combinaison.toString();
  }

  public String comparerCombinaison(String combinaisonAttaquant, String combinaisonDefenseur) {

    StringBuilder modele = new StringBuilder();
    char[] chiffreCombinaison = combinaisonAttaquant.toCharArray();
    char[] chiffreReponse = combinaisonDefenseur.toCharArray();

    for (int i = 0; i<combinaisonAttaquant.length(); i++) {
      if (chiffreCombinaison[i] < chiffreReponse[i])
        modele.append("-");
      else if (chiffreCombinaison[i] > chiffreReponse[i])
        modele.append("+");
      else if (chiffreCombinaison[i] == chiffreReponse[i])
        modele.append("=");
    }

    return modele.toString();

  }

  public String definirCombinaison() {
    String reponse = "";

    Scanner sc = new Scanner(System.in);
    boolean saisieOk;
    do {
      try {
        reponse = sc.nextLine();
        saisieOk = verifierSaisie(reponse) && reponse.length() == GestionConfiguration.tailleCode;
      } catch (InputMismatchException e) {
        sc.next();
        saisieOk = false;
      }
    } while (!saisieOk);
    //TODO Gérer le cas ou l'utilisateur fait une saisi supérieur a tailleCode
    

    return reponse;
  }

  public String genererReponse(String reponse, String modele) {
    StringBuilder nouvelleReponse = new StringBuilder();

    String temp;
    char[] caractereModele = modele.toCharArray();
    char[] caractereReponse = reponse.toCharArray();
    int i, min, max;

    // Si l'historique est vide
    if (modele.equalsIgnoreCase("")){
      for (i = 0 ; i < GestionConfiguration.tailleCode ; i++) {
        // Première réponse : x fois "5" , le plus logique pour réduire les possibilités
        nouvelleReponse.append(5);
      }
    // Sinon en fonction du signe du modèle
    } else {
      for (i = 0 ; i < GestionConfiguration.tailleCode ; i++){

        int nouvelleBorne= Integer.parseInt(String.valueOf(caractereReponse[i]));
        switch (caractereModele[i]){

          case '+' :
            min = nouvelleBorne +1;
            max = 9;
            temp = String.valueOf(min + (int) (Math.random() * ((max - min) + 1)));
            nouvelleReponse.append(temp);
            break;

          case '-' :
            min = 0;
            max = nouvelleBorne -1;
            temp = String.valueOf(min + (int) (Math.random() * ((max - min) + 1)));
            nouvelleReponse.append(temp);
            break;

          default:
            nouvelleReponse.append(caractereReponse[i]);

        }
      }
    }


    return nouvelleReponse.toString();
  }

  public String definirModele() {
    String reponse = "";

    Scanner sc = new Scanner(System.in);
    boolean saisieOk;
    do {
      try {
        reponse = sc.nextLine();
        saisieOk = verifierModele(reponse) && reponse.length() == GestionConfiguration.tailleCode;
      } catch (InputMismatchException e) {
        sc.next();
        saisieOk = false;
      }
    } while (!saisieOk);
    // TODO écrire tailleCode NOK


    return reponse;
  }

  public boolean verifierSaisie(String reponse) {

    return reponse.matches("[+-]?\\d*(\\.\\d+)?" ); // return false if response has not only digits

  }

  private boolean verifierModele(String reponse) {

    return reponse.matches( "^[-+=]*$"); // return false if response has not only + , - or =

  }

}
