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
import java.util.ArrayList;

/**
 *
 * @author RickyBic
 */
public class Emploi_temps_auto {

    private String idetudiant;
    private String idMatiere;
    private Float note;

    
//-------------------------------------------------------------------------------------------------------------------------------------------
    //Getters and Setters
    public String getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(String idetudiant) {
        this.idetudiant = idetudiant;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }
    
    //CRUD
	public void create(Emploi_temps_auto ema) throws SQLException
	{
		String requete = "insert into Emploi_temps_auto values('"+ ema.getIdetudiant() +"','"+ema.getIdMatiere()+"','"+ema.getNote()+"')";
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
	
	
	public ArrayList<Emploi_temps_auto> read() throws SQLException
	{
		String requete = "select * from Emploi_temps_auto";
		ArrayList<Emploi_temps_auto> liste = new ArrayList<Emploi_temps_auto>();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				Emploi_temps_auto ema = new Emploi_temps_auto();
				ema.setIdetudiant(rs.getString("idetudiant"));
                                ema.setIdMatiere(rs.getString("idmatiere"));
                                ema.setNote(rs.getFloat("note"));
				liste.add(ema);
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
