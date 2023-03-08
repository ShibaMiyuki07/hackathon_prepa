/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.Model;

import com.main.Base.Connexion;
import com.main.View.V_Auto_Matiere_Jour;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author RickyBic
 */
public class Emploi_temps_auto{

    private String idetudiant;
    private String idJour;
    private LocalTime heureDebut;
    private LocalTime heureFin;
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

    public LocalTime getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public LocalTime getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(LocalTime heureFin) {
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
	public void create(Emploi_temps_auto ema) throws SQLException
	{
		String requete = "insert into Emploi_temps_auto values('"+ ema.getIdetudiant() +"',"
                        + "'"+ema.getIdJour()+"','"+ema.getHeureDebut()+"','"+ema.getHeureFin()+"'"
                        + ",'"+ema.getIdMatiere()+"',,'"+ema.getEtat()+"')";
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
                ema.setIdJour(rs.getString("idjour"));
                ema.setHeureDebut(rs.getTime("heuredebut").toLocalTime());
                ema.setHeureFin(rs.getTime("heurefin").toLocalTime());
                ema.setIdMatiere(rs.getString("idmatiere"));
                ema.setEtat(rs.getInt("etat"));
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
	
	public ArrayList<V_Auto_Matiere_Jour> creation_Auto(String idEtudiant) throws SQLException
	{
		@SuppressWarnings("deprecation")
		LocalTime heureDebut = new Time(6,0,0).toLocalTime();
		ArrayList<Jour> liste_jour = new Jour().read();
		@SuppressWarnings("deprecation")
		LocalTime heureFin = new Time(23, 0, 0).toLocalTime();
		
		Cycle cycle = new Cycle().selectByEtudiant(idEtudiant);
		ArrayList<Matiere> liste_matiere_total = new Matiere().read();
		ArrayList<V_Auto_Matiere_Jour> retour = new ArrayList<>();
		ArrayList<Note_etudiant_matiere> liste_matiere = new Note_etudiant_matiere().selectbyEtudiant(idEtudiant);
		int priorite = 0;
		int index_jour = 0;
		int nbr_cycle = 10800/(cycle.getDuree()+20);
		for(int i=0;i<liste_matiere.size();i++)
		{
			liste_matiere.get(i).setPriorite(priorite);
			priorite++;
		}
		
		while(index_jour<liste_jour.size())
		{
			while(nbr_cycle>0)
			{
				for(int i=0;i<liste_matiere.size();i++)
				{
					LocalTime heureFinMatiere = heureDebut.plusMinutes(cycle.getDuree());
					
					
					V_Auto_Matiere_Jour emploi_temps_auto = new V_Auto_Matiere_Jour();
					
					String idmatiere = liste_matiere.get(i).getIdmatiere().replace("M00", "");
					idmatiere = idmatiere.replace(" ", "");
					System.out.println(idmatiere);
					int index_matiere = Integer.parseInt(idmatiere);
					
					/*System.out.println("Heure debut : "+emploi_temps_auto.getHeureDebut());
					System.out.println("Heure fin : "+emploi_temps_auto.getHeureFin());
					System.out.println("Matiere : "+liste_matiere_total.get(index_matiere-1).getNomMatiere());
					System.out.println("Jour : "+liste_jour.get(index_jour).getNomJour());
					System.out.println("Comparaison : "+heureFinMatiere.compareTo(heureFin));
					System.out.println();*/
					
					
					emploi_temps_auto.setIdJour(liste_jour.get(index_jour).getIdJour());
					emploi_temps_auto.setHeureDebut(heureDebut);
					emploi_temps_auto.setHeureFin(heureFinMatiere);
					emploi_temps_auto.setIdMatiere(liste_matiere.get(i).getIdmatiere());
					emploi_temps_auto.setIdetudiant(idEtudiant);
					emploi_temps_auto.setEtat(0);
					emploi_temps_auto.setMatiere(liste_matiere_total.get(index_matiere-1));
					emploi_temps_auto.setJour(liste_jour.get(index_jour));
					
					heureDebut = heureFinMatiere;
					retour.add(emploi_temps_auto);
					if(heureFinMatiere.compareTo(heureFin) >=0)
					{
						break;
					}
					if(nbr_cycle<0)
					{
						break;
					}
					nbr_cycle--;
				}
				if(heureDebut.compareTo(heureFin) >=0)
				{
					break;
				}
			}
			heureDebut = new Time(5,0,0).toLocalTime();
			nbr_cycle = 10800/(cycle.getDuree()+20);
			index_jour++;		
			
		}
		return retour;
	}

}
