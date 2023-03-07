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
public class AnneeEtude {

    private String idAnneeEtude;
    private String annee;

    
//-------------------------------------------------------------------------------------------------------------------------------------------
	//Getters and Setters
	public String getIdAnneeEtude() {
	    return idAnneeEtude;
	}
	
	public void setIdAnneeEtude(String idAnneeEtude) {
	    this.idAnneeEtude = idAnneeEtude;
	}
	
	public String getAnnee() {
	    return annee;
	}
	
	public void setAnnee(String annee) {
	    this.annee = annee;
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//CRUD
	public void create(AnneeEtude annee) throws SQLException
	{
		String requete = "insert into anneeetude values(default,'"+annee.getAnnee()+"')";
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
	
	
	public ArrayList<AnneeEtude> read() throws SQLException
	{
		String requete = "select * from anneeEtude";
		ArrayList<AnneeEtude> liste = new ArrayList<AnneeEtude>();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				AnneeEtude annee = new AnneeEtude();
				annee.setAnnee(rs.getString("annee"));
				annee.setIdAnneeEtude(rs.getString("idAnneeEtude"));
				liste.add(annee);
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
	
	public void update(AnneeEtude annee,String id) throws SQLException
	{
		String requete = "update anneeEtude set annee='"+annee.getAnnee()+"' where idAnneeEtude='"+id+"'";
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
		String requete = "delete from anneeEtude where idAnneeEtude='"+id+"'";
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
