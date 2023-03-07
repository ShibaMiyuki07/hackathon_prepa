/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.main.Base.Connexion;

/**
 *
 * @author RickyBic
 */
public class Matiere {

    private String idMatiere;
    private String nomMatiere;

    
//-------------------------------------------------------------------------------------------------------------------------------------------
    //Getters and Setters
    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }
    
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //CRUD
    public void create(Matiere matiere) throws SQLException
	{
		String requete = "insert into cycle values(default,'"+matiere.getNomMatiere()+"')";
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
    
    public ArrayList<Matiere> read() throws SQLException
	{
		String requete = "select * from matiere";
		ArrayList<Matiere> liste = new ArrayList<>();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				Matiere matiere = new Matiere();
				matiere.setIdMatiere(rs.getString("idmatiere"));
				matiere.setNomMatiere(rs.getString("nommatiere"));
				liste.add(matiere);
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
	
	public void update(Matiere matiere,String id) throws SQLException
	{
		String requete = "update matiere set nommatiere='"+matiere.getNomMatiere()+"' where idmatiere='"+id+"'";
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
	
	
	public void delete(String id) throws SQLException
	{
		String requete = "delete from matiere where idmatiere='"+id+"'";
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
	
	public Matiere select(String idMatiere) throws SQLException
	{
		String requete = "select * from matiere where idmatiere='"+idMatiere+"'";
		Matiere retour = new Matiere();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				retour.setIdMatiere(rs.getString("idmatiere"));
				retour.setNomMatiere(rs.getString("nommatiere"));
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
		return retour;
	}

}
