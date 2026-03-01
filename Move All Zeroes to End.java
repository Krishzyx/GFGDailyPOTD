class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int pos = 0;

        // Step 1: non-zero elements ko front me rakho
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[pos] = arr[i];
                pos++;
            }
        }

        // Step 2: baaki sab zero fill karo
        while (pos < n) {
            arr[pos] = 0;
            pos++;
        }
    }
}
