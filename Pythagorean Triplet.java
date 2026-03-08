class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
         int n = arr.length;

       HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            arr[i] = arr[i] * arr[i];
            set.add(arr[i]);
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int sum = arr[i] + arr[j];

                if(set.contains(sum)){
                    return true;
                }
            }
        }

        return false;
    }
}
