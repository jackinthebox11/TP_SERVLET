package fr.istic.tpservlet.servlet;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpservlet.domain.Home;
import fr.istic.tpservlet.domain.Person;

public class ServletTest {

	private EntityManager manager;

	public ServletTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		ServletTest test = new ServletTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		try {
			test.createHomes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		// TODO run request
		test.listHomes();
		
		manager.close();
		System.out.println(".. done");
	}
	
	private void createHomes() {
		int numOfHomes = manager.createQuery("Select a From Home a", Home.class).getResultList().size();
		if(numOfHomes == 0) {
			Person person = new Person("LeRoux", "Thibault", "F", "gigolo35@caramail.ru", new java.util.Date(), "gigolo35@facebook.ru");
			manager.persist(person);
			
			manager.persist(new Home("4 rue des pigeons", 80, "192.160.0.102", person));
			manager.persist(new Home("18 bd des acacias", 105, "192.160.0.103", person));
			manager.persist(new Home("62 avenue du general leclerc", 185, "192.160.0.102", person));
		}
	}
	
	private void listHomes() {
		List<Home> resultList = manager.createQuery("Select a From Home a", Home.class).getResultList();
		System.out.println("num of homes : " + resultList.size());
		for (Home next : resultList) {
			System.out.println("next home : " + next);
		}
	}

}
