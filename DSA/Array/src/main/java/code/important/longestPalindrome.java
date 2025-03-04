package code.important;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class longestPalindrome {
    public String longestPali(String s) {
        int[] position = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            position = getMaxPosition(position, getPali(i, i, s));
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1))
                position = getMaxPosition(position, getPali(i, i + 1, s));
        }
        return s.substring(position[0], position[1] + 1);
    }

    public int[] getPali(int left, int right, String s) {
        while (left - 1 >= 0 && right + 1 < s.length()) {
            if (s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }

    public int[] getMaxPosition(int[] current, int[] result) {
        if (result[1] - result[0] > current[1] - current[0]) return result;
        return current;
    }

    public int rob(int[] nums) {
        int pick = 0;
        int notPick = 0;

        for (int i = 0; i < nums.length; i++) {
            int newPick = nums[i] + notPick;
            int newNotPick = Math.max(pick, notPick);
            pick = newPick;
            notPick = newNotPick;
        }
        return Math.max(pick, notPick);
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] minRow = new int[matrix.length];
        int[] maxCol = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }
        Set<Integer> minRowSet = Arrays.stream(minRow).boxed().collect(Collectors.toSet());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < maxCol.length; i++) {
            if (minRowSet.contains(maxCol[i])) result.add(maxCol[i]);
        }
        return result;
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 15 == 0) ans.add("FizzBuzz");
            else if (i % 3 == 0) ans.add("Fizz");
            else if (i % 5 == 0) ans.add("Buzz");
            else ans.add(String.valueOf(i));
        }
        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // Add all list heads to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }
        return dummy.next;
    }


    public int trap(int[] height) {
        int len = height.length;
        int[] lm = new int[len];
        int[] rm = new int[len];
        lm[0] = height[0];
        rm[len-1] = height[len-1];
        for(int i=1;i<len-1;i++){
            int j = len-1-i;
            lm[i] = Math.max(height[i], lm[i-1]);
            rm[j] = Math.max(height[j], rm[j+1]);
        }
        int water = 0;
        for(int i = 0;i<len;i++){
            if(rm[i] > height[i] && lm[i] > height[i]){
                water+= Math.min(rm[i],lm[i]) - height[i];
            }
        }
        return water;
    }
}



