package strategy;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Map;

import session.EntityBeanDAOLocal;
import sessionFactory.SessionFactory;
import model.Account;
import model.Customer;

public class CustomerStrategy implements loginStrategy{
	private Customer customer = new Customer();
	private List<Account> accounts ;
	private EntityBeanDAOLocal bean = SessionFactory.getSessionBeanInstance();
	private Map<String, Object> session = SessionFactory.getStrutsSessionInstance();
	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		boolean result =false;
		try {
			 result = bean.login(name,password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		customer = bean.findCustomerByName(name);
		accounts = (List<Account>) bean.getAccountByCus(customer);
		if(!accounts.isEmpty()){
			for(Account a:accounts){
				System.out.println("Account ID:" + a.getId());	
			}
			session.put("account", accounts.get(0).getId());
		}
		else{
			System.out.println("No Account");	

		}
		return result;
	}

}
