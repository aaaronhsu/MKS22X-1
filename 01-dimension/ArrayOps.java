public class ArrayOps {
	public static int sum(int[] arr) {
		int hold = 0;

		for (int i = 0; i < arr.length; i++) {
			hold += arr[i];
		}

		return hold;
	}

	public static int largest(int[] arr) {
		int highest = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > highest) highest = arr[i];
		}

		return highest;
	}

	public static int[] sumRows(int[][] matrix) {
		int[] hold = new int[matrix.length];

		for (int i = 0; i < hold.length; i++) {
			hold[i] = sum(matrix[i]);
		}

		return hold;
	}

	public static int[] largestInRows(int[][] matrix) {
		int[] hold = new int[matrix.length];

		for (int i = 0; i < hold.length; i++) {
			hold[i] = largest(matrix[i]);
		}

		return hold;
	}

	public static int sum(int[][] arr) {
		int hold = 0;

		for (int i = 0; i < arr.length; i++) {
			hold += sum(arr[i]);
		}

		return hold;
	}

	public static int sumCol(int[][] matrix, int col) {
		int hold = 0;

		for (int i = 0; i < matrix.length; i++) {
			hold += matrix[i][col];
		}
		
		return hold;
	}

	public static int[] sumCols(int[][] matrix) {
		int[] hold = new int[matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) {
			hold[i] = sumCol(matrix, i);
		}

		return hold;
	}

	public static boolean isRowMagic(int[][] matrix) {
		int sum = sum(matrix[0]);

		for (int i = 1; i < matrix.length; i++) {
			if (sum != sum(matrix[i])) return false;
		}

		return true;
	}

	public static boolean isColMagic(int[][] matrix) {
		int sum = sumCol(matrix, 0);

		for (int i = 0; i < matrix[0].length; i++) {
			if (sum != sumCol(matrix, i)) return false;
		}

		return true;
	}

	public static boolean isLocationMagic(int[][] matrix, int row, int col) {
		return sum(matrix[row]) == sumCol(matrix, col);
	}
}
