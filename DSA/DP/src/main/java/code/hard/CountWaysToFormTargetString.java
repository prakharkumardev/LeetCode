package code.hard;

import java.util.HashMap;
import java.util.Map;

public class CountWaysToFormTargetString {
    public int numWays(String[] words, String target) {

        int mod = 1_000_000_007;
        int m = target.length();
        int n = words[0].length();
        //for and index to array mapping
        Map<Integer, int[]> map = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int[] freq = map.getOrDefault(i, new int[26]);
                freq[word.charAt(i) - 'a']++;
                map.put(i, freq);
            }
        }
        long[][] dp = new long[m + 1][n + 1];
        dp[0][0] = 1;


        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                // Carry forward previous value
                dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % mod;

                // Update current value if we can match the target character
                if (i < m) {
                    char targetChar = target.charAt(i);
                    int freq = map.get(j)[targetChar - 'a'];
                    dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j] * freq) % mod;
                }
            }
        }

        return (int) dp[m][n];
    }

}
