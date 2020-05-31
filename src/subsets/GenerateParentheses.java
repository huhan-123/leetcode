package subsets;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/31 4:07 下午
 * @Description 生成括号
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 * @Verion 1.0
 */

/**
 * 思路：总共需要生成2*n个字符的数组（左括号n个，右括号n个），每个位置有两种情况：1.左括号 2.右括号。递归列举
 * 所有的情况，合法的组合为左括号的数量>=右括号数量（剪枝函数），直到生成2*n个字符，如果左括号数量等于右括号数量，
 * 则是一个合法的结果，将其加入结果集
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(0, 0, new char[2 * n], result);
        return result;
    }

    //track为当前选择的组合，left为组合中左括号数量，right为组合中右括号数量
    public void backtrack(int left, int right, char[] track, List<String> result) {
        if (left + right == track.length) {
            if (left == right) {
                result.add(new String(track));
            }
            return;
        }

        //如果左括号数量小于右括号数量，不合法
        if (left < right) {
            return;
        }

        //选择左括号作为当前元素
        track[left + right] = '(';
        backtrack(left + 1, right, track, result);
        //选择右括号作为当前元素
        track[left + right] = ')';
        backtrack(left, right + 1, track, result);
    }
}
