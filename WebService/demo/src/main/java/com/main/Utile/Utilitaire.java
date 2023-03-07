package com.main.Utile;

import java.sql.SQLException;
import java.util.ArrayList;

import com.main.Model.Matiere;
import com.main.Model.Note_etudiant_matiere;

public class Utilitaire {
	public String suggestion(String idEtudiant,String idmatiere) throws SQLException
	{
		Note_etudiant_matiere retour = new Note_etudiant_matiere().select(idEtudiant, idmatiere);
		Matiere matiere = new Matiere().select(idmatiere);
		String suggestion = "";
		if(retour.getNote() > 10)
		{
			suggestion = "exercice "+matiere.getNomMatiere();
		}
		else
		{
			suggestion = "tuto "+matiere.getNomMatiere();
		}
		return GoogleSearch.search(suggestion);
	}
}
