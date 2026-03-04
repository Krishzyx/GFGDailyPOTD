class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n = arr.length;
        int windowXor = 0;
        
        for(int i=0; i<k; i++){
            windowXor ^= arr[i];
        }
        int maxXor = windowXor;
        
        for(int i=k; i<n; i++){
            windowXor ^= arr[i-k];
            windowXor ^= arr[i];
            
            maxXor = Math.max(maxXor, windowXor);
            
        }
        return maxXor;
    }
}
