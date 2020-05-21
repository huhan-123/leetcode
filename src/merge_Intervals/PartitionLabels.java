package merge_Intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/20 7:43 下午
 * @Description 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * @Verion 1.0
 */
//1.找到字符串中每个字母出现的最后位置   2.从最小的区间开始慢慢扩大
// https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode/
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] sArr = s.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < sArr.length; i++) {
            hash[sArr[i] - 'a'] = i;
        }

        int left = 0, right;
        while (left < sArr.length) {
            right = hash[sArr[left] - 'a'];
            while (left < right) {
                left++;
                right = Math.max(right, hash[sArr[left] - 'a']);
            }
            result.add(++left);
        }

        if (result.size() > 1) {
            for (int i = result.size() - 1; i > 0; i--) {
                result.set(i, result.get(i) - result.get(i - 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
        List<int[]> result = new ArrayList<>();
        result.toArray();
    }
}
