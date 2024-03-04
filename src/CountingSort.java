public class CountingSort {

    public static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k + 1]; // Plus one because we're including 0 to k

        // Initialize the count array to 0
        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }

        // Count the occurrences of each number in A
        for (int j = 0; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }

        // Cumulative sum to get positions in B
        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        // Place the elements in their correct positions
        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j]; // -1 because Java arrays are 0-indexed
            C[A[j]] = C[A[j]] - 1;
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] B = new int[A.length];
        int k = 5; // Assuming the range of values in A is from 0 to 5

        countingSort(A, B, k);

        // Print sorted array
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }
}
