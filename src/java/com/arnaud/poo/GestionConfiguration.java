package com.arnaud.poo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;


public abstract class GestionConfiguration {
    private static final Logger logger = LogManager.getLogger(GestionConfiguration.class);
    static ResourceBundle configuration = ResourceBundle.getBundle("config");
    
    public static int tailleCode = Integer.parseInt(configuration.getString("tailleCode"));
    public static int nbrEssaisMAX = Integer.parseInt(configuration.getString("nbrEssaisMAX"));
    public static boolean devMode = Boolean.parseBoolean(configuration.getString("devMode"));

    public static void afficheConfiguration(){
        logger.info("configuration acctuel :"+"taille code "+tailleCode + " nombre d'essai "+nbrEssaisMAX+
                " Mode devellopeur "+devMode);
    }
}


