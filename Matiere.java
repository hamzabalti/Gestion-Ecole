/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

/**
 *
 * @author Hamza
 */
public class Matiere {
   private int id_matiere;
   private String nom_matiere;
   private int coefficient;

    public Matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

   
   
    public Matiere(int id_matiere, String nom_matiere, int coefficient) {
        this.id_matiere = id_matiere;
        this.nom_matiere = nom_matiere;
        this.coefficient = coefficient;
    }

   
   
   
    public Matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }
  
    public Matiere(String nom_matiere, int coefficient) {
        this.nom_matiere = nom_matiere;
        this.coefficient = coefficient;
    }

    public Matiere() {
    }

    public int getCoefficient() {
        return coefficient;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    @Override
    public String toString() {
        return "Matiere{" + "id_matiere=" + id_matiere + ", nom_matiere=" + nom_matiere + ", coefficient=" + coefficient + '}';
    }
}
