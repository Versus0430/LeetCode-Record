
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        // 讨论左闭右闭区间情况，当start == end时，区间[start, end]仍然有效，所以取<=
        while(start <= end) {
            // 防止start + end操作溢出
            int mid = start + (end - start) / 2;
            // 因为此时是左闭右闭区间，所以等于情况是属于上一个区间，因此这里取<
            if(target < nums[mid]) {
                end = mid - 1;
            }
            else if(target > nums[mid]) {
                start = mid + 1;
            }
            else {
                return mid;
            }
        }
        // 不符合条件时就返回-1
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {5};
        int target = 5;
        int index = s.search(nums, target);
        System.out.println(index);
    }
}
