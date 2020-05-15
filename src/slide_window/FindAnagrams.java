package slide_window;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/15 8:09 上午
 * @Description 找到字符串中所有字母异位词
 * @Verion 1.0
 */

/**
 * 思路：维持一个固定长度的窗口，若窗口中的元素全部在所给字符串中，则返回该窗口索引，窗口向前滑动
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return result;
        }

        int l = 0, count = 0,pLength = p.length();  //窗口的左指针    这里很有必要将p.length()存储起来，能提升程序执行速度
        int[] hash = new int[26];
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        for (int i = 0; i < pArr.length; i++) {
            hash[pArr[i] - 'a']++;
        }
        for (int r = 0; r < s.length(); r++) {
            //当窗口右移时，hash中对应的字符数减1，如果减1后小于0，则该字符不在p中，反之在p中
            hash[sArr[r]-'a']--;
            if (hash[sArr[r]-'a']>=0){
                count++;
            }
            //当窗口长度和p的长度相等时，左指针开始向右移动
            if (r >= pLength) {
                //当左指针右移时，需要将右指针减掉的字符重新加到hash中
                hash[sArr[l]-'a']++;
                //如果左指针对应字符在p中，则count减1
                if (hash[sArr[l] - 'a'] > 0) {
                    count--;
                }
                l++;
            }
            if (count == pLength) {
                result.add(l);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("abab", "ab"));
    }
}
