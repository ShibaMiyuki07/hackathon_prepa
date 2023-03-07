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
public class Cycle {

    private String idCycle;
    private String idEtudiant;
    private Integer duree;

    
//-------------------------------------------------------------------------------------------------------------------------------------------
    //Getters and Setters
    public String getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(String idCycle) {
        this.idCycle = idCycle;
    }

    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }
    
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //CRUD
    public void create(Cycle cycle) throws SQLException
	{
		String requete = "insert into cycle values(default,'"+cycle.getIdEtudiant()+"','"+cycle.getDuree()+"')";
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
    
    public ArrayList<Cycle> read() throws SQLException
	{
		String requete = "select * from cycle";
		ArrayList<Cycle> liste = new ArrayList<>();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				Cycle cycle = new Cycle();
				cycle.setIdCycle(rs.getString("idcycle"));
				cycle.setIdEtudiant(rs.getString("idetudiant"));
				cycle.setDuree(rs.getInt("duree"));
				liste.add(cycle);
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
	
	public void update(Cycle cycle,String id) throws SQLException
	{
		String requete = "update anneeEtude set duree='"+cycle.getDuree()+"' where idCycle='"+id+"'";
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
		String requete = "delete from anneeEtude where idCycle='"+id+"'";
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
