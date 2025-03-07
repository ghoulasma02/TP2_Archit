import Controller.ControleurInscription;
import InscriptionView.IViewInscription;
import InscriptionView.ViewInscription;
import Journal.ScreenJourn;
import Repository.EtudiantRepository;
import Repository.UniversiteRepository;
import Services.EtudiantService;

public class MainAppMvc {

	public static void main(String[] args) {
	
		EtudiantService serv = new EtudiantService();
		serv.setEtudRep(new EtudiantRepository());
		serv.setUnivRep(new UniversiteRepository());
		serv.setJournal(new ScreenJourn());

		IViewInscription view = new ViewInscription();
		view.Show_InscriptionForm();

		ControleurInscription ctrl = new ControleurInscription(view, serv);



	}

}