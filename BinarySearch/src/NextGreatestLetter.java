/**
 *
 * 力扣744
 *
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 *     如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *
 *
 * 示例
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 *
 * 提示：
 *
 *     letters长度范围在[2, 10000]区间内。
 *     letters 仅由小写字母组成，最少包含两个不同的字母。
 *     目标字母target 是一个小写字母。
 *
 *
**/


/**
 * @author zxx
 * @date 2021/12/14 14:58
 **/
public class NextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length-1;

        int intTarget = (int)target;

        //如果target大于数组里面的，默认就取最小的
        if(intTarget >= letters[right] )
        {
            return letters[0];
        }


        while(left <= right)
        {
            int mid = left + (right - left)/2;
            int intMid = (int)letters[mid];

            //如果中间的数小于等于目标值，则左移一位，找下一个数
            if(intMid <= intTarget)
            {
                left = mid + 1;
            }else
            {
                //如果大于的话，则mid赋值给right
                right = mid -1 ;
            }

        }

        return letters[left];
    }

    public static void main(String[] args) {
        char target = 'e';
        char[] letters = {'e','e','n'};

        System.out.println(nextGreatestLetter(letters,target));
    }
}
