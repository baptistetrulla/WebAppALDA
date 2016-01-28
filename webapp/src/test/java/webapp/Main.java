package webapp;

import java.util.ArrayList;
import java.util.List;

import beans.Announce;
import beans.FavoriteAnnounce;
import beans.Person;
import controls.AnnounceCtrl;
import controls.FavoriteAnnounceCtrl;
import controls.PersonCtrl;
import dao.AnnounceDAO;
import dao.FavoriteAnnounceDAO;
import dao.PersonDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonDAO pDao = new PersonDAO();
		PersonCtrl pCtrl = new PersonCtrl();
		AnnounceDAO aDao = new AnnounceDAO();
		AnnounceCtrl aCtrl = new AnnounceCtrl();
		FavoriteAnnounceDAO faDao = new FavoriteAnnounceDAO();
		FavoriteAnnounceCtrl faCtrl = new FavoriteAnnounceCtrl();
		// ----------- ADD A PERSON ----------
		Person p = new Person("baptiste", "tru", "bap.tru@gmail.com", "password", "baptistetru", "9 rue du perche",
				"saint léo", "0255555555", false);
		Person p2 = new Person("baptiste", "tru", "bap.tru@gmail2.com", "password", "baptistetru2", "654 rue du perche",
				"saint ", "0255454545", true);
		pCtrl.setPerson(p2);
//		 pCtrl.savePerson();
//		pCtrl.setPerson(p2);
//		pCtrl.updatePerson();
		// -----------------------------------

		// ----------- ADD AN ANNOUNCE----------
		Announce a = new Announce(64252, "T2", 52, "15 rue du petit cheval", "Bordeaux", "une petite description",
				false);
		Announce a2 = new Announce(64252, "T2", 52, "15 rue du petit cheval", "Bordeaux", "une petite description",
				true);
				// aCtrl.setAnnounce(a);
				// aCtrl.saveAnnounce();
				// aCtrl.setAnnounce(a2);

		// aCtrl.updateAnnounce();
		// -----------------------------------
		
		
		// ----------- ADD A FAVORITE_ANNOUNCE----------
		FavoriteAnnounce fa = new FavoriteAnnounce(1, 5);
		FavoriteAnnounce fa2 = new FavoriteAnnounce(5, 5);
				 faCtrl.setFavoriteAnnounce(fa);
				 faCtrl.saveFavoriteAnnounce();
				 faCtrl.setFavoriteAnnounce(fa2);
				 faCtrl.saveFavoriteAnnounce();

		// aCtrl.updateAnnounce();
		// -----------------------------------
//		List<Person> allPersons = new ArrayList<Person>();
//		allPersons = pDao.getAllPersons();
//		for (Person pp : allPersons) {
//
//			System.out.println(pp.getFirstname());
//
//		}
//
//		List<Announce> allAnnounces = new ArrayList<Announce>();
//		allAnnounces = aDao.getAllAnnounces();
//		for (Announce aa : allAnnounces) {
//
//			System.out.println(aa.getDescription());
//
//		}

		List<FavoriteAnnounce> favorite_announces = new ArrayList<FavoriteAnnounce>();
		favorite_announces = faDao.getAllFavoriteAnnounces();
		for (FavoriteAnnounce ffa : favorite_announces) {

			System.out.println(ffa.getAnnounceID());

		}
		// -----------------------------------

	}

}
