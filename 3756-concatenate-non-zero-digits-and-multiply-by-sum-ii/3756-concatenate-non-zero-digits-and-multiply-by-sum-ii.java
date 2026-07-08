import java.util.Arrays;

class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        int n = queries.length;
        long MOD = 1000000007L;

        // prefixSum[i] stores the sum of digits from s[0...i-1]
        int[] prefixSum = new int[m + 1];
        // nonZeroCount[i] stores the count of non-zero digits from s[0...i-1]
        int[] nonZeroCount = new int[m + 1];
        // prefixX[i] stores the numerical value of non-zero digits from s[0...i-1] modulo MOD
        long[] prefixX = new long[m + 1];

        // Precompute powers of 10 modulo 10^9 + 7
        long[] power10 = new long[m + 1];
        power10[0] = 1;
        for (int i = 1; i <= m; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }

        // Single pass prefix computation
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            int digit = ch - '0';

            prefixSum[i + 1] = prefixSum[i] + digit;
            
            if (digit != 0) {
                nonZeroCount[i + 1] = nonZeroCount[i] + 1;
                prefixX[i + 1] = (prefixX[i] * 10 + digit) % MOD;
            } else {
                nonZeroCount[i + 1] = nonZeroCount[i];
                prefixX[i + 1] = prefixX[i];
            }
        }

        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            // 1. Calculate sum of digits in the range O(1)
            long currentSum = prefixSum[r + 1] - prefixSum[l];

            // 2. Extract the non-zero concatenated value 'x' in the range O(1)
            int nonZerosBefore = nonZeroCount[l];
            int nonZerosTotal = nonZeroCount[r + 1];
            int nonZerosInWindow = nonZerosTotal - nonZerosBefore;

            if (nonZerosInWindow == 0) {
                arr[i] = 0;
                continue;
            }

            // Formula to extract mid-string concatenated value modulo 10^9 + 7:
            // x = (prefixX[r+1] - prefixX[l] * 10^(non-zeros in window)) % MOD
            long x = prefixX[r + 1] - (prefixX[l] * power10[nonZerosInWindow]) % MOD;
            if (x < 0) x += MOD; // Handle negative modulo in Java

            // 3. Final answer computation
            long ans = (x * currentSum) % MOD;
            arr[i] = (int) ans;
        }

        return arr;
    }
}
