package com.main.View;

import com.main.Model.Emploi_temps_auto;
import com.main.Model.Jour;
import com.main.Model.Matiere;

public class V_Auto_Matiere_Jour extends Emploi_temps_auto{
	private Matiere matiere;
	private Jour jour;
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Jour getJour() {
		return jour;
	}
	public void setJour(Jour jour) {
		this.jour = jour;
	}
	
	
}
