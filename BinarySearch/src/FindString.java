/**
 * 面试题 10.05. 稀疏数组搜索
 *
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 *
 * 示例2:
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 *
 * 提示:
 *     words的长度在[1, 1000000]之间
 *
 */

/**
 * @author zxx
 * @date 2022/01/23 18:46
 **/
public class FindString {
    public static int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;

        while (left <= right){
            int mid = left + (right - left)/2;
            //如果mid指向空字符串，则将右指针(right)向左移动一个位置
            if(words[mid].equals("")){
                // 移动右指针(right)之前先判断是否指向目标字符串，防止错过目标字符串
                if(words[right].equals(s)){
                    return right;
                }
                right --;
            }else if(words[mid].equals(s)){
                //如果mid等于目标值，直接输出
                return mid;
            }else if(words[mid].compareTo(s) > 0){
                //因为是排序好的，compareTo比较ASCII码顺序，如果大于0，说明对应的字符串大了，
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] nums = {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
        String target = "ball";
        System.out.println(findString(nums,target));
    }

}
