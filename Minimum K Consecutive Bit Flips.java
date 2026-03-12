class Solution {
    public int kBitFlips(int[] arr, int k) {
       
       int n = arr.length;
        // Difference array to track flip effects
        // differenceArray[i] represents the change in flip count at position i
        int[] differenceArray = new int[n + 1];
        int flipCount = 0;  // Total number of k-bit flips performed
        int currentFlipEffect = 0;  // Accumulated flip effect at current position
      
        for (int i = 0; i < n; i++) {
            // Update current flip effect by adding the difference at position i
            currentFlipEffect += differenceArray[i];
          
            // Check if current bit needs to be flipped
            // If currentFlipEffect is even and nums[i] is 0, or
            // if currentFlipEffect is odd and nums[i] is 1, we need to flip
            if (currentFlipEffect % 2 == arr[i]) {
                // Check if we can perform a k-bit flip starting at position i
                if (i + k > n) {
                    // Cannot flip k bits starting from i (would go out of bounds)
                    return -1;
                }
              
                // Perform a k-bit flip starting at position i
                // Mark the start of flip effect
                differenceArray[i]++;
                // Mark the end of flip effect (after k positions)
                differenceArray[i + k]--;
                // Update current flip effect immediately
                currentFlipEffect++;
                // Increment the total flip count
                flipCount++;
            }
        }
      
        return flipCount;
    }
