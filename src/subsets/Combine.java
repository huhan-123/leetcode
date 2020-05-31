package subsets;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: huhan
 * @Date 2020/5/31 7:16 上午
 * @Description 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @Verion 1.0
 */
public class Combine {
    int n;
    int k;
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return result;
    }

    public void backtrack(int start, LinkedList<Integer> track) {
        if (track.size() == k) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(i + 1, track);
            track.removeLast();
        }
    }
}
