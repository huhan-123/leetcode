package subsets;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/31 8:19 上午
 * @Description 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * @Verion 1.0
 */

/**
 * 这里改变字符大小写有一个黑科技：ch = ch^32;
 * 该题没有采用常用的回溯法（回溯法超时）
 * 思路：递归遍历每一个字符，如果当前字符为数字，则跳过，直接处理下一个字符，如果当前字符为字母，则有两种情况：1.不处理当前字母 2.将当前字母切换大小写
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        char[] sArr = S.toCharArray();
        List<String> result = new LinkedList<>();
        backtrack(0, sArr, result);
        return result;
    }

    public void backtrack(int current, char[] sArr, List<String> result) {
        //如果已经处理了最后一个字符，将字符串加到结果集，返回
        if (current == sArr.length) {
            result.add(new String(sArr));
            return;
        }

        if (sArr[current] >= '0' && sArr[current] <= '9') {//如果为数字，直接跳过，处理下一个字符
            backtrack(current + 1, sArr, result);
        } else {//如果为字母，则有两种情况：1.不处理当前字母 2.将当前字母切换大小写
            //不处理当前字母
            backtrack(current + 1, sArr, result);
            //将当前字母切换大小写
            sArr[current] = (char)(sArr[current] ^ 32);
            backtrack(current + 1, sArr, result);
            //这里可以不回溯，因为无论回溯还是不回溯，都会考虑上面两种情况
//            sArr[current] = (char) (sArr[current] ^ 32);
        }
    }

    public static void main(String[] args) {
        List<String> xxulYjUwme = new LetterCasePermutation().letterCasePermutation("xxulYjUwme");
//        char ch = 'A';
        System.out.println();
    }
}
