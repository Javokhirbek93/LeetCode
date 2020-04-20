package problem33;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int leftInd = findIndex(nums, 0, nums.length / 2, target);
        int rightInd = findIndex(nums, nums.length / 2, nums.length - 1, target);

        return leftInd < rightInd ? rightInd : (leftInd == -1) ? -1 : leftInd;
    }

    private int findIndex(int[] nums, int from, int to, int target) {
        if (nums[from] == target) {
            return from;
        }
        if (nums[to] == target) {
            return to;
        }
        if(from >= to) {
            return -1;
        }

        int left = findIndex(nums, from + 1, (from + to) / 2, target);
        int right = findIndex(nums, (from + to) / 2, to - 1, target);

        return left > right ? left : (right == -1) ? -1 : right;
    }
}
