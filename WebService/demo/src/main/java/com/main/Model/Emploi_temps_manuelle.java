/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.Model;

import com.main.Base.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

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
    
    //CRUD
	public void create(Emploi_temps_manuelle emm) throws SQLException
	{
		String requete = "insert into Emploi_temps_manuelle values('"+ emm.getIdetudiant() +"',"
                        + "'"+emm.getIdJour()+"','"+emm.getHeureDebut()+"','"+emm.getHeureFin()+"'"
                        + ",'"+emm.getIdMatiere()+"',,'"+emm.getEtat()+"')";
		Connection connect = null;
		Statement state = null;
		
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			state.execute(requete);
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if(connect != null) connect.close();
			if(state != null) state.close();
		}
	}
	
	
	public ArrayList<Emploi_temps_manuelle> read() throws SQLException
	{
		String requete = "select * from Emploi_temps_manuelle";
		ArrayList<Emploi_temps_manuelle> liste = new ArrayList<Emploi_temps_manuelle>();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				Emploi_temps_manuelle emm = new Emploi_temps_manuelle();
				emm.setIdetudiant(rs.getString("idetudiant"));
                                emm.setIdJour(rs.getString("idjour"));
                                emm.setHeureDebut(rs.getTime("heuredebut"));
                                emm.setHeureFin(rs.getTime("heurefin"));
                                emm.setIdMatiere(rs.getString("idmatiere"));
                                emm.setEtat(rs.getInt("etat"));
				liste.add(emm);
			}
			rs.close();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if(connect != null) connect.close();
			if(state != null) state.close();
		}
		return liste;
	}

}
