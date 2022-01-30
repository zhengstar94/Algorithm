package Hash;
/**
 * 389. 找不同/力扣389
 *
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 *
 *
 * 提示：
 *     0 <= s.length <= 1000
 *     t.length == s.length + 1
 *     s 和 t 只包含小写字母
 *
 */

/**
 * @author zxx
 * @date 2022/01/30 15:24
 **/
public class FindTheDifference {

    public static char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd","abcde"));
    }
}
