package slide_window;

/**
 * @Author: huhan
 * @Date 2020/5/15 3:33 下午
 * @Description 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * @Verion 1.0
 */
public class NoRepeatlengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int l = 0, maxLength = 0;
        int[] hash = new int[256];
        char[] sArr = s.toCharArray();

        for (int r = 0; r < s.length(); r++) {
            hash[sArr[r]]++;
            while (hash[sArr[r]] > 1) {
                hash[sArr[l]]--;
                l++;
            }
            maxLength = Math.max(maxLength,r-l+1);
        }
        return maxLength;
    }
}
