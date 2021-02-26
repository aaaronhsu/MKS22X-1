import java.util.*;

public class Sorts {

	public static void bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			boolean again = false;

			for (int a = 0; a < data.length - i - 1; a++) {
				if (data[a] > data[a + 1]) {
					int hold = data[a];
					data[a] = data[a + 1];
					data[a + 1] = hold;

					again = true;
				}
			}

			if (!again) break;
		}
	}

	public static void selectionSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int curMin = data[i];
			int curIndex = i;

			for (int a = i; a < data.length; a++) {
				if (data[a] < curMin) {
					curMin = data[a];
					curIndex = a;
				}
			}

			int hold = data[i];
			data[i] = curMin;
			data[curIndex] = hold;
		}
	}

	public static void insertionSort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			int hold = data[i];

			for (int a = i - 1; a >= 0; a--) {

				if (a == 0 && data[a] > hold) {
					data[a + 1] = data[a];
					data[a] = hold;
					break;
				}
				
				if (data[a] < hold) {
					data[a + 1] = hold;
					break;
				}
				
				data[a + 1] = data[a];
			}
		}
	}
}