/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.Model;

import java.sql.Time;

/**
 *
 * @author RickyBic
 */
public class Emploi_temps_manuelle {

    private String idetudiant;
    private String idJour;
    private Time heureDebut;
    private Time heureFin;
    private String idMatiere;
    private Integer etat;

    
//-------------------------------------------------------------------------------------------------------------------------------------------
    //Getters and Setters
    public String getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(String idetudiant) {
        this.idetudiant = idetudiant;
    }

    public String getIdJour() {
        return idJour;
    }

    public void setIdJour(String idJour) {
        this.idJour = idJour;
    }

    public Time getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Time getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

}
