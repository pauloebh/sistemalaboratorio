package carga.microrganismo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddUser {

	public static void main(String[] args) {
		
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	/*	ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		*/
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
	 /*   DBOperationsDao dao = context.getBean("dao", DBOperationsDaoImpl.class);
	    dao.addUser(userAdd);
		
		
		Perfil perfil = (Perfil) appContext.getBean(Perfil.class);
		perfil.setTipo("testePerfil");
		
		Usuario user = (Usuario) appContext.getBean(Usuario.class);
		user.setAtivo(true);
		user.setCpf("111111111-29");
		user.setEmail("email@teste.com");
		user.setNome("teste");
		user.setSenha("12345");
		
		List<Perfil> listPerfil  = new ArrayList<Perfil>();  
		listPerfil.add(perfil);	
		user.setPerfis(listPerfil);
				  
		UserDAO userDao = (UserDAO) appContext.getBean("UserDAO",UserDAO.class);
		userDao.addUser(user); // <<===== ERROR
		*/
		
		
	}
	
}
