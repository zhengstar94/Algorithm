package Array;
/**
 * 283. 移动零/力扣283
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *     必须在原数组上操作，不能拷贝额外的数组。
 *     尽量减少操作次数。
 */

import java.util.Arrays;

/**
 * @author zxx
 * @date 2022/01/25 15:25
 **/
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        if(nums.length == 0 || nums.length == 1){
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0 ){
                nums[index] = nums[i];
                index++;
            }
        }

        //补0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
