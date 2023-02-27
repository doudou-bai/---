package cn.doudou;

import java.util.Map;

/**
 * Create By 王嘉浩
 * Time 2023-02-27 16:25
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4 - 1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length);
    }

    static int maxSubArray(int[] nums, int begin, int end) {
        /**
         * 假设数据规模为9;
         * 1.计算出mid中间Index索引
         *     1.1其就是begin+end >> 1 = 4
         * 2.计算left的开始位置的索引
         *      2.1 leftBegin = mid-1
         *      2.2 leftMax  = nums[leftBegin]
         *      2.3 创建一个变量进行存储0,leftBegin位置的和
         *      2.4 循环遍历进行比较大小 如果值比leftMax大就修改leftMax 的值 反之无需处理
         * 3. 右边和左边的步骤相同
         * 4. 递归的调用 begin,mid和mid,end 的值 最后选最大的进行然后即可
         */
        if (end - begin < 2) return nums[begin];
        int mid = (begin + end) >> 1;

        //处理左边的区间
        int leftBegin = mid - 1;
        int leftMax = nums[leftBegin];
        int leftSum = 0;
        for (int i = leftBegin; i >= 0; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        //处理右边的区间
        int rightBegin = mid;
        int rightMax = nums[rightBegin];
        int rightSum = 0;
        for (int i = rightBegin; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(leftMax + rightMax, Math.max(maxSubArray(nums, begin, mid), maxSubArray(nums, mid, end)));
    }

    static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length; end++) {
                int sum = 0;
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        //暴力递归
        /**
         * begin 开始的位置
         * end 结束的位置
         * i begin->end 索引的元素
         *
         */
        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length; end++) {
                int sum = 0;
                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

