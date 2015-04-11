package sessionFactory;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import session.EntityBeanDAOLocal;

public class SessionFactory {
	private static Context context;
	private static EntityBeanDAOLocal sessionBean;
	private static Map<String, Object> session ;


	public static EntityBeanDAOLocal getSessionBeanInstance(){
		try{
			 context = new InitialContext();
			sessionBean = (EntityBeanDAOLocal) context.lookup("java:global/AssignmentEAR/AssignEJB/EntityBeanDAO!session.EntityBeanDAOLocal");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return sessionBean;
	}
	

	public static Map<String, Object> getStrutsSessionInstance() {
		// TODO Auto-generated method stub
		session = ActionContext.getContext().getSession();
		System.out.println("Existing Session : " + session.toString());
		return session;
	}


}
