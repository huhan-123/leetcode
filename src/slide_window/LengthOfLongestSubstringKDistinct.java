package slide_window;

/**
 * @Author: huhan
 * @Date 2020/5/15 3:02 下午
 * @Description 给定一个字符串，找到最多有k个不同字符的最长子字符串。
 * @Verion 1.0
 */
public class LengthOfLongestSubstringKDistinct {
    public String lengthOfLongestSubstringKDistinct(String s, int k) {
        String result = "";
        if (s == null || s.length() == 0 || k == 0) {
            return result;
        }
        int l = 0, maxLength = 0, count = 0;
        int[] hash = new int[256];
        char[] sArr = s.toCharArray();

        for (int r = 0; r < s.length(); r++) {
            hash[sArr[r]]++;
            if (hash[sArr[r]] == 1) {
                count++;
            }

            while (count > k) {
                hash[sArr[l]]--;
                if (hash[sArr[l]] == 0) {
                    count--;
                }
                l++;
            }

            if (maxLength < r - l + 1) {
                maxLength = r - l + 1;
                result = s.substring(l, r + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstringKDistinct().lengthOfLongestSubstringKDistinct("eceba", 3));
    }
}
