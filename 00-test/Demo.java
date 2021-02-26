public class Demo {
	public static void main(String[] args) {
		int n = 5;
		if (args.length != 0) n = Integer.parseInt(args[0]); 

		printLoop(n);

	}

	public static void printLoop(int n) {
		for (int i = 1; i <= n; i++) {
			for (int a = i; a <= n; a++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public static String arrToString(int[] arr){
		if (arr.length == 0) return "{}";
		StringBuilder ans = new StringBuilder().append("{");
			
		for (int i = 0; i < arr.length - 1; i++) {
			ans.append(arr[i] + ", ");
		}
			
		ans.append(arr[arr.length - 1] + "}");
		return ans.toString();
	}

	public static String arrayDeepToString(int[][] arr) {
		StringBuilder ans = new StringBuilder().append("{");
		for (int i = 0; i < arr.length - 1; i++) {
			ans.append(arrToString(arr[i]) + ", ");
		}
		ans.append(arrToString(arr[arr.length - 1]) + "}");

		return ans.toString();
	}

	public static int[][] create2DArray(int rows, int cols, int maxValue) {
		int[][] hold = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int a = 0; a < cols; a++) {
				hold[i][a] = (int) (Math.random() * (maxValue + 1));
			}
		}

		return hold;
	}

	public static int[][] create2DArrayRandomized(int rows, int cols, int maxValue) {
		int[][] hold = new int[rows][];

		for (int i = 0; i < rows; i++) {
			hold[i] = new int[(int) (Math.random() * (cols + 1))];

			for (int a = 0; a < hold[i].length; a++) {
				hold[i][a] = (int) (Math.random() * (maxValue + 1));
			}
		}

		return hold;
	}

	
}
