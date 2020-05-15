package slide_window;

/**
 * @Author: huhan
 * @Date 2020/5/15 11:40 上午
 * @Description 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * @Verion 1.0
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        String result = "";
        int l = 0, count = t.length(), minLength = s.length() + 1;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] hash = new int[256];

        for (int i = 0; i < tArr.length; i++) {
            hash[tArr[i]]++;
        }

        for (int r = 0; r < s.length(); r++) {
            hash[sArr[r]]--;
            if (hash[sArr[r]] >= 0) {//程序只可能进入该分支t.length次，当窗口包含了所有t中的字符后就会一直包含
                count--;
            }
            //当左指针对应的字符不需要时，左指针右移
            while (l < r && hash[sArr[l]] < 0) {
                hash[sArr[l]]++;
                l++;
            }

            if (count == 0 && minLength > r - l + 1) {
                minLength = r-l+1;
                result = s.substring(l,r+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
    }
}
