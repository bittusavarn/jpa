package foo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
    

	@PersistenceContext(name="entityManager") EntityManager entityManager;
	
	
    
	
	
	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Transactional
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute("controllerMessage",
				"This is the message from the controller!");
	    TestRole role=new TestRole();
	    role.setDes("Nilamber");
	    Test test=new Test();
	    test.setName("Nilamber");
	    test.setTestRole(role);
	    test.setRole("Nilamber");
	    try {
			
	    	//Transaction ts=tm.getTransaction();
	       	//EntityManager entiryManager=entityManagerFActory.createEntityManager();
			entityManager.persist(test);
			//entiryManager.close();
			//ts.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return "home";
	}

}
