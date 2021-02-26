import java.util.*;
import java.io.*;

public class Travel {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("cities.txt"));

		ArrayList<String> cities = new ArrayList<>();

		// adds all cities into the ArrayList so that each city has a corresponding index (using .indexOf())
		while (in.hasNextLine()) {
			Scanner lineIn = new Scanner(in.nextLine());
			String city1 = lineIn.next();
			lineIn.next();
			String city2 = lineIn.next();
			
			// adds the city to the ArrayList if it doesn't already exist
			if (!cities.contains(city1)) cities.add(city1);
			if (!cities.contains(city2)) cities.add(city2);
		}

		// creating a 2d array such that costs[i][j] will represent the cost from city i to city j
		int n = cities.size();
		int[][] costs = new int[n][n];

		// reopening the file again to add the costs to the 2d array
		in = new Scanner(new File("cities.txt"));

		while (in.hasNextLine()) {
			Scanner lineIn = new Scanner(in.nextLine());
			String city1 = lineIn.next();
			lineIn.next();
			String city2 = lineIn.next();
			lineIn.next();
			int cost = lineIn.nextInt();
			
			costs[cities.indexOf(city1)][cities.indexOf(city2)] = cost;
			costs[cities.indexOf(city2)][cities.indexOf(city1)] = cost;
		}


		// this ArrayList will hold all the permutations of numbers 0 to n
		ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

		// initializing the starting city
		for (int i = 0; i < n; i++) {
			// pay respects to the computer that's about to brute force this question
			ArrayList<Integer> sorryComputer = new ArrayList<>();
			sorryComputer.add(i);
			paths.add(sorryComputer);
		}

		// add a city to each path already generated until each path has visited every city (when there are n unique cities in the list)
		while (paths.get(0).size() < n) {
			// temporary ArrayList, each ArrayList in it will hold a path that is 1 longer than an ArrayList in paths (line 43)
			ArrayList<ArrayList<Integer>> longerPath = new ArrayList<>();

			// goes through every path and adds a city to it
			for (ArrayList<Integer> i : paths) {
				for (int a = 0; a < n; a++) {
					// if the path doesn't already contain the city, add it to the list. This is so that we don't travel to the same city twice
					if (!i.contains(a)) {
						ArrayList<Integer> copyPath = (ArrayList<Integer>) i.clone();
						copyPath.add(a);
						longerPath.add(copyPath);
					}
				}
			}

			paths = longerPath;
		}

		int ans = Integer.MAX_VALUE;
		ArrayList<Integer> optimalPath = paths.get(0);

		// goes through every path and sums the costs
		for (ArrayList<Integer> i : paths) {
			int hold = 0;
			for (int city = 0; city < n - 1; city++) {
				hold += costs[i.get(city)][i.get(city + 1)];
			}

			// if the current path length < ans, update ans to be that path length
			if (hold < ans) {
				ans = hold;
				optimalPath = i;
			}
		}

		System.out.print("The optimal path is ");
		for (Integer i : optimalPath) {
			System.out.print(cities.get(i) + " ");
		}
		System.out.println("with a length of " + ans);
	}

	// Lines 43 - 71 might be a bit confusing so here's an example if there were 3 cities:
	// 	Initialization (lines 46 - 51):
	// 		paths = {
	// 			{0},
	// 			{1},
	// 			{2}
	// 		}

	// 	Iteration 1:
	// 		paths = {
	// 			{0, 1},
	// 			{0, 2},
	// 			{1, 0},
	// 			{1, 2},
	// 			{2, 0},
	// 			{2, 1}
	// 		}

	// 	Iteration 2:
	// 		paths = {
	// 			{0, 1, 2},
	// 			{0, 2, 1},
	// 			{1, 0, 2},
	// 			{1, 2, 0},
	// 			{2, 0, 1},
	// 			{2, 1, 0}
	// 		}

	// Then go through each permutation and sum up the costs, updating when the sum is less than the current answer
}