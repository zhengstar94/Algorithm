/**
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 *     你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 *
 * 提示：
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *     nums 是一个非递减数组
 *     -109 <= target <= 109
 */
package pratice;

import java.util.Arrays;

/**
 * @author zxx
 * @date 2022/01/20 14:14
 **/
public class SearchRange {


    public static int[] searchRange(int[] nums, int target) {

        if(nums.length <=0){
            return new int[]{-1,-1};
        }

        return new int[]{leftBound2(nums,target),rightBound2(nums,target)};
    }


    public static int leftBound(int nums[],int target){
        int left = 0 ;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left +(right - left -1 ) / 2;
            if(nums[mid] == target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }

        if(left >= nums.length || nums[left] != target){
            return -1;
        }

        return left;
    }

    public static int leftBound2(int nums[],int target){
        int left = 0 ;
        int right = nums.length ;

        while(left < right){
            int mid = left +(right - left -1 ) / 2;
            if(nums[mid] == target){
                right = mid ;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid ;
            }
        }

        if(left >= nums.length || nums[left] != target){
            return -1;
        }

        return left;
    }




    public static int rightBound(int nums[],int target){
        int left = 0 ;
        int right = nums.length -1;

        while(left <= right){
            int mid = left +(right - left - 1) / 2;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        if(right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }

    public static int rightBound2(int nums[],int target){
        int left = 0 ;
        int right = nums.length;

        while(left < right){
            int mid = left +(right - left - 1) / 2;
            if(nums[mid] == target){
                left = mid + 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }
        }
        if(right-1 < 0 || nums[right-1] != target){
            return -1;
        }
        return right-1;
    }



    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;

        System.out.println(leftBound2(nums,target));
        System.out.println(rightBound2(nums,target));
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

}
