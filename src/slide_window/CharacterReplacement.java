package slide_window;

/**
 * @Author: huhan
 * @Date 2020/5/15 4:58 下午
 * @Description 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上
 * 的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含
 * 重复字母的最长子串的长度。
 * @Verion 1.0
 */

//本题关键：1.找到左指针移动的条件：k+出现最多的字符的次数 < 窗口长度
//        2.当出现次数最多的字符有多个时，左指针右移不需要使count减1
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        //count表示窗口中出现次数最多的字符的个数
        int maxLength = 0, l = 0, count = 0;
        int[] hash = new int[26];
        char[] sArr = s.toCharArray();
        //当出现次数最多的字符有多个时，需要记住有多少个这样的字符
        int maxcount = 0;

        for (int r = 0; r < s.length(); r++) {
            hash[sArr[r] - 'A']++;
            if (hash[sArr[r] - 'A'] > count) {
                count = hash[sArr[r] - 'A'];
            } else if (hash[sArr[r] - 'A'] == count) {
                maxcount++;
            }

            while (l < r && (k + count < r - l + 1)) {
                hash[sArr[l] - 'A']--;
                if (hash[sArr[l] - 'A'] == count && maxcount == 1) {
                    count--;
                } else if (hash[sArr[l] - 'A'] == count && maxcount != 1) {
                    maxcount--;
                }
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new CharacterReplacement().characterReplacement("EQQEJDOBDPDPFPEIAQLQGDNIRDDGEHJIORMJPKGPLCPDFMIGHJNIIRSDSBRNJNROBALNSHCRFBASTLRMENCCIBJLGAITBFCSMPRO", 2));
    }
}
