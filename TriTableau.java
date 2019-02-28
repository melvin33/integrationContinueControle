package test;

import java.io.IOException;

public class TriTableau 
{    
    
    public static void trier(int tab[]) throws IOException 
    {
  
        triCroissant(tab);
 
        for(int i=0; i<tab.length; i++)
        {
            System.out.println(tab[i]);
        }
 
        triDecroissant(tab);
 
        System.out.println("\n");
 
        for(int i=0; i<tab.length; i++)
        {
            System.out.println(tab[i]);
        }
 
    }
 
    public static void triCroissant(int tableau[]) {
        int longueur = tableau.length;
        int tampon = 0;
        boolean permut;
 
        do {
            permut = false;
            for (int i = 0; i < longueur - 1; i++) {
                if (tableau[i] > tableau[i + 1]) {
                    tampon = tableau[i];
                    tableau[i] = tableau[i + 1];
                    tableau[i + 1] = tampon;
                    permut = true;
                }
            }
        } while (permut);
    }
 
    public static void triDecroissant(int tableau[]) {
        int longueur = tableau.length;
        int tampon = 0;
        boolean permut;
 
        do {
            permut = false;
            for (int i = 0; i < longueur - 1; i++) { //i < longueur initialement
                if (tableau[i] < tableau[i + 1]) {
                    tampon = tableau[i];
                    tableau[i] = tableau[i + 1];
                    tableau[i + 1] = tampon;
                    permut = true;
                }
            }
        } while (permut);
    }
    
}