package top_k_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: huhan
 * @Date 2020/6/2 10:34 上午
 * @Description 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * @Verion 1.0
 */
public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> bigQueue = new PriorityQueue<>((x, y)->y.getValue()-x.getValue());
        char[] sArr = s.toCharArray();

        for(int i=0;i<sArr.length;i++){
            map.put(sArr[i],map.getOrDefault(sArr[i],0)+1);
        }

        for(Map.Entry entry:map.entrySet()){
            bigQueue.offer(entry);
        }

        StringBuilder str = new StringBuilder();
        while(!bigQueue.isEmpty()){
            Map.Entry entry = bigQueue.poll();
            for(int i = (int) entry.getValue(); i>0; i--){
                str.append(entry.getKey());
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String tree = new FrequencySort().frequencySort("tree");
        System.out.println(tree);
    }
}
