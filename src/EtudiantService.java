import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EtudiantService {


		private IEtudiant StudRep;
		private IUniversite UnivRep;
		private IJournal j;

		public void setEtudRep(IEtudiant StudRep) {
			this.StudRep = StudRep;
		}
		public void setUnivRep(IUniversite UnivRep) {
			this.UnivRep = UnivRep;
		}
		public void setJournal(IJournal j) {
			this.j = j;
		}
		public IJournal getJournal() {
			return this.j;
		}

	boolean inscription (int matricule, String nom, String pr�nom, String email,String pwd, int id_universite) throws SQLException	
	{
		

	    Etudiant stud = new Etudiant(matricule, nom, pr�nom, email,pwd,id_universite);
	    Universite univ= UnivRep.GetById(id_universite,j);

	    j.outPut_Msg("Log: d�but de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);

	    if(email == null || email.length() == 0)
	    {
	    	return false;
	    }



	    if (StudRep.Exists(matricule,j))
	    {
	        return false;
	    }

		if (StudRep.Exists(email, j))
	    {
	        return false;
	    }
		
		
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
	          stud.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 stud.setNbLivreMensuel_Autorise(10*2);
	     }                           

	
		 StudRep.add(stud, j);
		 j.outPut_Msg("Log: Fin de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
		 return true;


	}
	
	
	
public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}
public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}
	
}