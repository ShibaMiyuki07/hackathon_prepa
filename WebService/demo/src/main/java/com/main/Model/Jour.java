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
public class Jour {

    private String idJour;
    private String nomJour;

    
//-------------------------------------------------------------------------------------------------------------------------------------------
    //Getters and Setters
    public String getIdJour() {
        return idJour;
    }

    public void setIdJour(String idJour) {
        this.idJour = idJour;
    }

    public String getNomJour() {
        return nomJour;
    }

    public void setNomJour(String nomJour) {
        this.nomJour = nomJour;
    }
    
    
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //CRUD
    public void create(Jour jour) throws SQLException
	{
		String requete = "insert into jour values(default,'"+jour.getNomJour()+"')";
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
    
    public ArrayList<Jour> read() throws SQLException
	{
		String requete = "select * from jour";
		ArrayList<Jour> liste = new ArrayList<>();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				Jour jour = new Jour();
				jour.setIdJour(rs.getString("idjour"));
				jour.setNomJour(rs.getString("nomjour"));
				liste.add(jour);
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
	
	public void update(Jour jour,String id) throws SQLException
	{
		String requete = "update anneeEtude set nomJour='"+jour.getNomJour()+"' where idJour='"+id+"'";
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
		String requete = "delete from jour where idjour='"+id+"'";
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

}
