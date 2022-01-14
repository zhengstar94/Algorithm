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

    public static boolean f(String s, int length) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - length; i++) {
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
        System.out.println(longestRepeatingsubstring("abbaba"));
    }


}
