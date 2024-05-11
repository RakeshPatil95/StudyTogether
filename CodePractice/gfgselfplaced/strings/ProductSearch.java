package gfgselfplaced.strings;

import java.util.*;

public class ProductSearch {
    public static int[] graphProblemSolution(int input1, int[][] input2) {
        // input1: number of nodes (unused)
        // input2: array of nodes, each with an array of integers

        // Map to store node id and its parent id
        Map<Integer, Integer> parentMap = new HashMap<>();

        // Loop through each node
        for (int i = 0; i < input2.length; i++) {
            int[] currentData = input2[i];
            int currentId = i;

            // Find potential parents (nodes with superset data)
            List<Integer> potentialParents = new ArrayList<>();
            for (int j = 0; j < input2.length; j++) {
                if (i == j) continue; // Skip comparing with itself
                if (isSuperset(currentData, input2[j])) {
                    potentialParents.add(j);
                }
            }

            // Filter out potential parents that are children of others (avoiding cycles)
            potentialParents.removeIf(parentId -> parentMap.containsKey(parentId));

            // Choose the parent with the most data (most numbers)
            int bestParentId = -1;
            int maxDataLength = 0;
            for (int parentId : potentialParents) {
                if (input2[parentId].length > maxDataLength) {
                    maxDataLength = input2[parentId].length;
                    bestParentId = parentId;
                }
            }

            // Update parent map if a valid parent is found
            if (bestParentId != -1) {
                parentMap.put(currentId, bestParentId);
            }
        }

        // Convert parent map to single int array (parent for each node)
        int[] parents = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            parents[i] = parentMap.getOrDefault(i, -1); // -1 indicates no parent
        }

        return parents;
    }
    // Helper function to check if one array is a superset of another
    private static boolean isSuperset(int[] subset, int[] superset) {
        if (subset.length > superset.length) {
            return false;
        }
        for (int num : subset) {
            if (Arrays.stream(superset).noneMatch(i -> i == num)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Sample input data (modify as needed)
        int[][] inputData = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {2, 4, 6, 8, 10, 12, 14},
                {1, 2, 3, 4, 5, 7},
                {1, 2, 3},
                {4, 5, 6},
                {2, 4, 6},
                {2}
        };

        // Call the graphProblemSolution function
        int[] parentChild = graphProblemSolution(inputData.length, inputData);
        for (int i = 0; i <parentChild.length ; i++) {
            System.out.print(parentChild[i]+ "  ");
        }
    }
}

