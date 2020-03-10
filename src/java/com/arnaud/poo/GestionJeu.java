package com.arnaud.poo;


import java.util.InputMismatchException;
import java.util.Scanner;

public  class GestionJeu {


    //TODO faire en sorte que tailleCode soit pris en compte dans le tableau ou crée une arraylist qui initialise le nombre de saisie
    public static int[] rangeMin = new int[GestionConfiguration.tailleCode];
    public static int[] rangeMax = new int[GestionConfiguration.tailleCode];

    public GestionJeu() {
        init();
    }

    public void init(){
            initRangeMax();
            initRangeMin();

    }

    public void initRangeMin() {

        for (int i = 0; i < GestionConfiguration.tailleCode; i++) {
            rangeMin[i] = 0;
        }
    }

    public void initRangeMax() {

        for (int i = 0; i < GestionConfiguration.tailleCode; i++) {
            rangeMax[i] = 9;
        }
    }

    public String genererConbinaison() {

        int[] combinaisonRandom = new int[GestionConfiguration.tailleCode];
        int min = 0, max = 9;
        StringBuilder combinaison = new StringBuilder();

        for (int i = 0; i < GestionConfiguration.tailleCode; i++) {
            combinaisonRandom[i] = min + (int) (Math.random() * ((max - min) + 1));
            combinaison.append(combinaisonRandom[i]);
        }


        return combinaison.toString();
    }

    public String comparerCombinaison(String combinaisonAttaquant, String combinaisonDefenseur) {

        StringBuilder modele = new StringBuilder();
        char[] chiffreCombinaison = combinaisonAttaquant.toCharArray();
        char[] chiffreReponse = combinaisonDefenseur.toCharArray();

        for (int i = 0; i < combinaisonAttaquant.length(); i++) {
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
        boolean saisieOk = false;
        do {
            try {
                reponse = sc.nextLine();
                saisieOk = verifierSaisie(reponse);
                if (!saisieOk) {
                    System.out.println("erreur de saisie saisir uniquement " + GestionConfiguration.tailleCode + " Chiffre ");
                }

            } catch (InputMismatchException e) {
                sc.next();
                saisieOk = false;

            }
        } while (!saisieOk);


        return reponse;
    }

    public String genererReponse(String reponse, String modele) {


        StringBuilder nouvelleReponse = new StringBuilder();
        char[] caractereModele = modele.toCharArray();
        char[] caractereReponse = reponse.toCharArray();

        int i;
        int randomInt;

        // Si l'historique est vide
        if (modele.equalsIgnoreCase("")) {
            for (i = 0; i < GestionConfiguration.tailleCode; i++) {
                // Première réponse : x fois "5" , le plus logique pour réduire les possibilités
                nouvelleReponse.append(5);
            }
            // Sinon en fonction du signe du modèle
        } else {
            for (i = 0; i < GestionConfiguration.tailleCode; i++) {

                int nouvelleBorne = Integer.parseInt(String.valueOf(caractereReponse[i]));
                switch (caractereModele[i]) {

                    case '+':
                        if (rangeMin[i] < nouvelleBorne)
                            rangeMin[i] = nouvelleBorne;
                        // je génére un random dans le rage min et max, et le range s'affine a chaque nouvelle  répose de l ia
//                        temp = String.valueOf(rangeMin[i] + (int) (Math.random() * ((rangeMax[i] - rangeMin[i]) + 1)));
                        randomInt = (rangeMin[i] + rangeMax[i]) / 2;
                        nouvelleReponse.append(randomInt);
                        break;

                    case '-':
                        if (rangeMax[i] > nouvelleBorne)
                            rangeMax[i] = nouvelleBorne;
                        // retourne un chiffre médiant par rapport a la réponse précédente
                        randomInt = (rangeMin[i] + rangeMax[i]) / 2;
                        nouvelleReponse.append(randomInt);
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


        return reponse;
    }

    public boolean verifierSaisie(String reponse) {

        return reponse.matches("[+-]?\\d*(\\.\\d+\"[abc]\")?") && (reponse.length() == GestionConfiguration.tailleCode); // return false if response has not only digits

    }


    private boolean verifierModele(String reponse) {

        return reponse.matches("^[-+=]*$"); // return false if response has not only + , - or =

    }


}
