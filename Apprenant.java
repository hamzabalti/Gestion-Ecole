/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

import java.sql.Date;

/**
 *
 * @author Hamza
 */
public class Apprenant {
   private int id_apprenant;
   private int niveau_class;
   private String loisir;
   private String nom;
   private String prenom;
   private int cin_parent;
   private String sexe;
   private Date date_naissance;
   private int tel;

    public Apprenant() {
        
    }

    @Override
    public String toString() {
        return "Apprenant{" + "id_apprenant=" + id_apprenant + ", niveau_class=" + niveau_class + ", loisir=" + loisir + ", nom=" + nom + ", prenom=" + prenom + ", cin_parent=" + cin_parent + ", sexe=" + sexe + ", date_naissance=" + date_naissance + ", tel=" + tel + '}';
    }

    public Apprenant(int id_apprenant) {
        this.id_apprenant = id_apprenant;
    }

    public Apprenant(String nom) {
        this.nom = nom;
    }

    public Apprenant(int id_apprenant, String nom) {
        this.id_apprenant = id_apprenant;
        this.nom = nom;
    }

    public int getId_apprenant() {
        return id_apprenant;
    }

    public void setId_apprenant(int id_apprenant) {
        this.id_apprenant = id_apprenant;
    }

    public int getNiveau_class() {
        return niveau_class;
    }

    public void setNiveau_class(int niveau_class) {
        this.niveau_class = niveau_class;
    }

    public String getLoisir() {
        return loisir;
    }

    public void setLoisir(String loisir) {
        this.loisir = loisir;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCin_parent() {
        return cin_parent;
    }

    public void setCin_parent(int cin_parent) {
        this.cin_parent = cin_parent;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }
   

    
   
   
   
   
}
