package il.cshaifasweng.OCSFMediatorExample.server;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.Student;
import il.cshaifasweng.OCSFMediatorExample.entities.User;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.List;

public class SimpleServer extends AbstractServer {

	private static final SessionFactory sessionFactory = getSessionFactory();
	private static Session session;

	public SimpleServer(int port) {
		super(port);
	}

	@Override
	public void handleMessageFromClient(Object msg, ConnectionToClient client) throws IOException {

		System.out.println("gggggg");
		Message message = (Message) msg;
		if ("Get all Students".equals(message.getOperation())) {
			try {
				session = sessionFactory.openSession();
				session.beginTransaction();

// Fetch the student data from your data source or database
				List<Student> students = getAllStudentsFromDatabase();

// Create a new Message with the student data and send it back to the client
				int msgId = 0;
				Message responseMessage = new Message("Get all Students", students);
				client.sendToClient(responseMessage);
				session.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("get grades".equals(message.getOperation())) {
			try {
				session = sessionFactory.openSession();
				session.beginTransaction();
				Student studentsel = (Student) message.getMessage();
				int studentId = studentsel.getId();
				Student student = getStudentFromDatabase(studentId);
				Message responseMessage = new Message("get grades", student);
				client.sendToClient(responseMessage);
				session.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("update".equals(message.getOperation())){
			try {

				session = sessionFactory.openSession();
				session.beginTransaction();
				Student studentsel =(Student) message.getMessage();
				int studentId = studentsel.getId();
				Student student = updateStudentGradeInDatabase(studentId,message.getSubject(), message.getNewScore());
				Message responseMessage = new Message("update",student);
				client.sendToClient(responseMessage);

				session.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if ("Login".equals(message.getOperation())) {
			String username = message.getUsername();
			String password = message.getPassword();

			User user = loginUser(username, password);

			if (user != null) {
				// Username and password are correct
				// Send a success response to the client
				Message responseMessage = new Message("LoginSuccess", null);
				client.sendToClient(responseMessage);
			} else {
				// Username and password are incorrect
				// Send an error response to the client
				Message responseMessage = new Message("LoginError", null);
				client.sendToClient(responseMessage);
			}
		}
		}


	public static SessionFactory getSessionFactory()
	{
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Student.class);
		StandardServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		return configuration.buildSessionFactory(serviceRegistry);
	}
	public User loginUser(String username, String password) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yourPersistenceUnitName");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :userame AND u.password = :password", User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);

			List<User> users = query.getResultList();
			if (!users.isEmpty()) {
				return users.get(0);
			} else {
				return null;
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}
	public static List<Student> getAllStudentsFromDatabase() {
		Session session = sessionFactory.openSession();
//open hibernate session
		session.beginTransaction();
//create criteria builder and criteria query objects to build query
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		query.select(root);
//execute query and retrieve all students
		List<Student> students = session.createQuery(query).getResultList();
//close transaction and session
		session.getTransaction().commit();
		session.close();

		return students;
	}
	public  static Student getStudentFromDatabase(int studentId){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		query.select(root).where(builder.equal(root.get("id"),studentId));
		Student student = session.createQuery(query).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return student;
	}
	public static Student updateStudentGradeInDatabase(int studentId, String subject , int newGrade) {
			Session session = sessionFactory.openSession();
			 session.beginTransaction();

			 Student student = session.get(Student.class, studentId);
			 if (student != null)
			 {
			 	if(subject.equals("English"))
				 {

				 }
				 else if(subject.equals("Math"))
				 {
						//student.setMathScore(newGrade);
				 }
				 session.update(student);
				 session.getTransaction().commit();

			 }
			 session.close();
		return student;
	}
}