/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.main.Base.Connexion;

/**
 *
 * @author RickyBic
 */
public class Note_etudiant_matiere {

    private String idetudiant;
    private String idmatiere;
    private Float note;
    private Date dateajout;
    private int priorite;

    
//-------------------------------------------------------------------------------------------------------------------------------------------
    //Getters and Setters
    public String getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(String idetudiant) {
        this.idetudiant = idetudiant;
    }

    

    public String getIdmatiere() {
		return idmatiere;
	}

	public void setIdmatiere(String idmatiere) {
		this.idmatiere = idmatiere;
	}

	public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }
    
    public Date getDateajout() {
		return dateajout;
	}

	public void setDateajout(Date dateajout) {
		this.dateajout = dateajout;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //CRUD
    public void create(Note_etudiant_matiere note_etudiant_matiere) throws SQLException
	{
		String requete = "insert into note_etudiant_matiere values('"+note_etudiant_matiere.getIdetudiant()+"','"+note_etudiant_matiere.getIdmatiere()+"','"+note_etudiant_matiere.getNote()+"',default)";
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
    
    public ArrayList<Note_etudiant_matiere> read() throws SQLException
	{
		String requete = "select * from note_etudiant_matiere";
		ArrayList<Note_etudiant_matiere> liste = new ArrayList<>();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				Note_etudiant_matiere note_etudiant_matiere = new Note_etudiant_matiere();
				note_etudiant_matiere.setIdetudiant(rs.getString("idetudiant"));
				note_etudiant_matiere.setIdmatiere(rs.getString("idmatiere"));
				note_etudiant_matiere.setNote(rs.getFloat("note"));
				liste.add(note_etudiant_matiere);
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
	
	public void update(Note_etudiant_matiere note_etudiant_matiere,String id) throws SQLException
	{
		String requete = "update note_etudiant_matiere set note='"+note_etudiant_matiere.getNote()+"' where idEtudiant='"+id+"' and idMatiere='"+note_etudiant_matiere.getIdmatiere()+"'";
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
		String requete = "delete from note_etudiant_matiere where idNote_etudiant_matiere='"+id+"'";
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

    public Note_etudiant_matiere select(String idEtudiant,String idMatiere) throws SQLException
    {
    	Note_etudiant_matiere retour = new Note_etudiant_matiere();
    	String requete = "select * from note_etudiant_matiere  where idetudiant='"+idEtudiant+"' and idmatiere='"+idMatiere+"'";
    	Connection connect = null;
    	Statement state = null;
    	try
    	{
    		connect = new Connexion().setConnect();
    		state = connect.createStatement();
    		ResultSet rs = state.executeQuery(requete);
    		while(rs.next())
    		{
    			retour.setNote(rs.getFloat("note"));
    			retour.setIdetudiant(rs.getString("idetudiant"));
    			retour.setIdmatiere(rs.getString("idmatiere"));
    		}
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
    
    public ArrayList<Note_etudiant_matiere> selectbyEtudiant(String id) throws SQLException
	{
		String requete = " select idmatiere,idetudiant,max(note) as note,max(dateajout) from note_etudiant_matiere where idetudiant='"+id+"'  group by idmatiere,idetudiant,dateajout order by dateajout asc";
		System.out.println(requete);
		ArrayList<Note_etudiant_matiere> liste = new ArrayList<>();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				Note_etudiant_matiere note_etudiant_matiere = new Note_etudiant_matiere();
				note_etudiant_matiere.setIdetudiant(rs.getString("idetudiant"));
				note_etudiant_matiere.setIdmatiere(rs.getString("idmatiere"));
				note_etudiant_matiere.setNote(rs.getFloat("note"));
				liste.add(note_etudiant_matiere);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connect != null) connect.close();
			if(state != null) state.close();
		}
		return liste;
	}
}
