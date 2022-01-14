/**
 *
 * 有序区间，力扣1062题；Longest Repeating Substring
 *
 * 给定字符串 S，找出**最长重复子串**的`长度`。如果不存在重复子串就返回 0。
 *
 * 示例 1：
 * 输入："abcd"
 * 输出：0
 * 解释：没有重复子串。
 *
 * 示例 2：
 * 输入："abbaba"
 * 输出：2
 * 解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
 *
 * 示例 3：
 * 输入："aabcaabdaab"
 * 输出：3
 * 解释：最长的重复子串为 "aab"，出现 3 次。
 *
 * 示例 4：
 * 输入："aaaaa"
 * 输出：4
 * 解释：最长的重复子串为 "aaaa"，出现 2 次。
 *
 * 提示：
 * 字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。
 * 1 <= S.length <= 1500
 */


import java.util.HashSet;
import java.util.Set;

/**
 * @author zxx
 * @date 2022/01/13 17:16
 **/
public class LongestRepeatingSubstring {


    /**
     * 1.比如aabcaabdaab，长度为11，mid为5的长度
     * 2.调用f函数，依次遍历aabcaabdaab，每次取5个字符，第一次aabca，如果不存在则放入set中，之后遍历是abcaa，依次类推
     * 3.发现没有符合的数据，f函数返回false，说明长度为5不存在重复字符串，
     * 4.即right=mid-1，right = 4， 循环，二分法找到mid=2，长度为2，
     * 5.调用f函数，返回true，说明长度为2的数据存在重复，即left = mid ，循环，二分法 在2与4之间找到mid= 3，长度为3
     * 6.调用f函数，返回true，说明长度为3的数据存在重复，即left = mid，循环，二分法 在3与4之间找到mid= 4，长度为4
     * 7.调用f函数，返回true，说明长度为4的数据不存在重复，即right = mid -1 为3 ，循环发现left(3)<right(3)不成立
     * 8.跳出循环返回left为3
     * @param s
     * @return
     */
    public static int longestRepeatingsubstring(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if (f(s, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;

    }

    /**
     * @param s
     * @param length
     * @return
     */
    public static boolean f(String s, int length) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - length; i++) {
            //通过length依次往后截取字符串
            int j = i + length - 1;
            String sub = s.substring(i, j + 1);
            if (seen.contains(sub)) {
                return true;
            }
            seen.add(sub);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(longestRepeatingsubstring("aabcaabdaab"));
    }


}
