public class Tester {
	public static void main(String[] args) {
		BankAccount a = new BankAccount(10, "a");

		System.out.println(a.deposit(-100));
		System.out.println(a.toString());
	}
}
