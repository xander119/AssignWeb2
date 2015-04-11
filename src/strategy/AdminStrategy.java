package strategy;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import session.EntityBeanDAOLocal;
import sessionFactory.SessionFactory;

public class AdminStrategy implements loginStrategy{

	private EntityBeanDAOLocal bean = SessionFactory.getSessionBeanInstance();
	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		
		boolean result = false;
		try {
			 result = bean.login(name, password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
