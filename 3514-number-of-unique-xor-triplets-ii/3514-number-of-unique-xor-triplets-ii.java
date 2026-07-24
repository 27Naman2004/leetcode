import java.util.ArrayList;
import java.util.List;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        // Use a fast boolean array instead of the first HashSet
        // 2048 covers all possible XOR outcomes up to 1500
        boolean[] seenPairs = new boolean[2048]; 
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int xor = nums[i] ^ nums[j];
                seenPairs[xor] = true; // Mark as seen
            }
        }
        
        // Reconstruct your 'arr' list using only the unique values found
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 2048; i++) {
            if (seenPairs[i]) {
                arr.add(i);
            }
        }
        
        // Use a second boolean array instead of the 'ans' HashSet
        boolean[] seenTriplets = new boolean[2048];
        
        for(int i = 0; i < arr.size(); i++) {
            for(int j = 0; j < n; j++) {
                int xor = arr.get(i) ^ nums[j];
                seenTriplets[xor] = true; // Mark as seen
            }
        }
        
        // Count the unique elements marked true in your answer array
        int uniqueCount = 0;
        for (int i = 0; i < 2048; i++) {
            if (seenTriplets[i]) {
                uniqueCount++;
            }
        }
        
        return uniqueCount;
    }
}
