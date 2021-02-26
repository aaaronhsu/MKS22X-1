public class BankAccount {
	private double balance;
	private int accountID;
	private String password;

	BankAccount(int accountID, String password) {
		this.accountID = accountID;
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public double getAccountID() {
		return accountID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean deposit(double amount) {
		if (amount < 0) return false;
		balance += amount;
		return true;
	}

	public boolean withdraw(double amount) {
		if (amount > balance || amount < 0) return false;
		balance -= amount;
		return true;
	}

	public String toString() {
		return "#" + accountID + "\t$" + balance;
	}

	private boolean authenticate(String password) {
		return password.equals(this.password);
	}

	public boolean transferTo(BankAccount other, double amount, String password) {
		return authenticate(password) && withdraw(amount) && other.deposit(amount);
	}
}