package Stack;
/**
 * 20. 有效的括号/力扣20
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 *
 * 提示：
 *     1 <= s.length <= 104
 *     s 仅由括号 '()[]{}' 组成
 *
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zxx
 * @date 2022/01/27 11:01
 **/
public class IsValid {
    public static  boolean isValid(String s) {
        int n = s.length();
        // 奇数则无需判断
        if(n%2 == 1){
             return false;
        }

        //默认只有这几种类型
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n ; i++) {
            char ch = s.charAt(i);
            //如果有数据符合
            if(pairs.containsKey(ch)){
                //如果栈是空的或者栈顶不对等
                if(stack.isEmpty() || !stack.peek().equals(pairs.get(ch)) ){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        //判断stack是否是空的，如果是空的说明符合，不为空数据不符合
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

}
