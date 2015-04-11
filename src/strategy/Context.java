package strategy;

public class Context {
	private loginStrategy strategy;

	public Context(loginStrategy strategy) {
		this.strategy = strategy;
	}

	public boolean login(String name, String password) {
		return strategy.login(name, password);
	}

}
