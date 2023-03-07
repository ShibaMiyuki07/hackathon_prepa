/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.Model;

import com.main.Base.Connexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author RickyBic
 */
public class Etudiant {

    private String idEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private Date dateNaissance;
    private String email;
    private String mdp;
    private String idAnneeEtude;
    private String photoprofil;

    
//-------------------------------------------------------------------------------------------------------------------------------------------
    //Getters and Setters
    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getIdAnneeEtude() {
        return idAnneeEtude;
    }

    public void setIdAnneeEtude(String idAnneeEtude) {
        this.idAnneeEtude = idAnneeEtude;
    }

    public String getPhotoprofil() {
        return photoprofil;
    }

    public void setPhotoprofil(String photoprofil) {
        this.photoprofil = photoprofil;
    }
    
    //CRUD
	public void create(Etudiant et) throws SQLException
	{
		String requete = "insert into Etudiant values(default,'"+et.getNomEtudiant()+"'"
                        + ",'"+et.getPrenomEtudiant()+"','"+et.getDateNaissance()+"','"+et.getEmail()+"'"
                        + ",'"+et.getMdp()+"','"+et.getIdAnneeEtude()+"','"+et.getPhotoprofil()+"')";
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
	
	
	public ArrayList<Etudiant> read() throws SQLException
	{
		String requete = "select * from Etudiant";
		ArrayList<Etudiant> liste = new ArrayList<Etudiant>();
		Connection connect = null;
		Statement state = null;
		try
		{
			connect = new Connexion().setConnect();
			state = connect.createStatement();
			ResultSet rs = state.executeQuery(requete);
			while(rs.next())
			{
				Etudiant et = new Etudiant();
				et.setIdEtudiant(rs.getString("idetudiant"));
                                et.setNomEtudiant(rs.getString("NomEtudiant"));
                                et.setPrenomEtudiant(rs.getString("PrenomEtudiant"));
                                et.setDateNaissance(rs.getDate("DateNaissance"));
                                et.setEmail(rs.getString("Email"));
                                et.setMdp(rs.getString("Mdp"));
                                et.setIdAnneeEtude(rs.getString("IdAnneeEtude"));
                                et.setPhotoprofil(rs.getString("Photoprofil"));
				liste.add(et);
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
	
	public void delete(String id) throws SQLException
	{
		String requete = "delete from Etudiant where idEtudiant='"+id+"'";
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
