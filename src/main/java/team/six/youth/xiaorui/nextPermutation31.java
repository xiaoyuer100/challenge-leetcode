package team.six.youth.xiaorui;

public class nextPermutation31 {

    public static void main(String args[]) {

        new nextPermutation31().new Solution().nextPermutation(new int[]{1, 3, 2});


    }
    class Solution {

        public void nextPermutation(int[] nums) {
            if (isDESC(nums)) {
                revise(nums);
                return;
            }

            int i = nums.length - 1;
            int gap = 1;
            for (; gap <= i; gap++) {
                for (int j = i; j > i - gap; j--) {
                    for (int k = j - 1; k > i - gap - 1; k--) {
                        if (nums[j] > nums[k]) {
                            int tmp = nums[j];
                            nums[j] = nums[k];
                            nums[k] = tmp;
                            sortASC(k, nums);
                            return;
                        }
                    }
                }
            }

        }

        private final void sortASC(int start, int[] nums) {
            if (start + 1 >= nums.length - 1) {
                return;
            }

            for (int i = start + 1; i < nums.length; i++) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] < nums[i]) {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                    }
                }
            }
        }


        private final void revise(int[] nums) {
            int n = nums.length / 2;
            for (int i = 0; i < n; i++) {
                int j = nums[i];
                int k = nums[nums.length - i - 1];
                nums[i] = k;
                nums[nums.length - i - 1] = j;
            }
        }

        private final boolean isDESC(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
            return true;
        }

    }
}