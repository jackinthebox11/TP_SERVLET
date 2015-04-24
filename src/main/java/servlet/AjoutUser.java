package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.istic.tpservlet.domain.Person;

@WebServlet(name="ajoutuser", urlPatterns={"/userajoute"})
public class AjoutUser extends HttpServlet{

	//private EntityManager manager;
        
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		EntityManagerFactory factory = Persistence
    				.createEntityManagerFactory("example");
    		EntityManager manager = factory.createEntityManager();
    		//JpaTest test = new JpaTest(manager);

    		EntityTransaction tx = manager.getTransaction();
    		tx.begin();
    		System.out.println(req.getParameter("firstname"));
    		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
    		String dateAsString = req.getParameter("dateNaissance");
			try {
				Date dateNais = sourceFormat.parse(dateAsString);
				Person p = new Person(req.getParameter("nom"), req.getParameter("prenom"), req.getParameter("genre"), req.getParameter("email"), dateNais, req.getParameter("facebook"));
				manager.persist(p);
				PrintWriter pr = new PrintWriter(resp.getOutputStream());
				pr.print(req.getParameter("prenom") + " ajouté(e) avec succès !");
				pr.flush();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    
    		tx.commit();
    	}
}
