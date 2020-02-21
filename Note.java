/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

import javafx.scene.control.ChoiceBox;

/**
 *
 * @author Hamza
 */
public class Note {
 
    private int id_note;
    private Matiere m;
    private int note_orale;
    private int note_ecrit;
    private double moyenne;
    private Apprenant a;

    public Note(int id_note, int note_orale, int note_ecrit, double moyenne) {
        this.id_note = id_note;
        this.note_orale = note_orale;
        this.note_ecrit = note_ecrit;
        this.moyenne = moyenne;
    }

    
    
    
    public Note(int note_orale, int note_ecrit, double moyenne) {
        this.note_orale = note_orale;
        this.note_ecrit = note_ecrit;
        this.moyenne = moyenne;
    }
     

    
    private Note(){}

    public Note(int id_note, Matiere m, int note_orale, int note_ecrit, double moyenne, Apprenant a) {
        this.id_note = id_note;
        this.m = m;
        this.note_orale = note_orale;
        this.note_ecrit = note_ecrit;
        this.moyenne = moyenne;
        this.a = a;
    }

    public Note(Matiere m, int note_orale, int note_ecrit, double moyenne, Apprenant a) {
        this.m = m;
        this.note_orale = note_orale;
        this.note_ecrit = note_ecrit;
        this.moyenne = moyenne;
        this.a = a;
    }




    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public Matiere getM() {
        return m;
    }

    public void setM(Matiere m) {
        this.m = m;
    }

    public int getNote_orale() {
        return note_orale;
    }

    public void setNote_orale(int note_orale) {
        this.note_orale = note_orale;
    }

    public int getNote_ecrit() {
        return note_ecrit;
    }

    public void setNote_ecrit(int note_ecrit) {
        this.note_ecrit = note_ecrit;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public Apprenant getA() {
        return a;
    }

    public void setA(Apprenant a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Note{" + "id_note=" + id_note + ", m=" + m + ", note_orale=" + note_orale + ", note_ecrit=" + note_ecrit + ", moyenne=" + moyenne + ", a=" + a + '}';
    }
    

   

   

   

 
    


   
}



    


    
    

