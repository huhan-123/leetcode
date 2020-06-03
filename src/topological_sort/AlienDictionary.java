package topological_sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: huhan
 * @Date 2020/6/3 5:10 下午
 * @Description 火星词典
 * 现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。您有一个单词列表（从词典中获得的），
 * 该单词列表内的单词已经按这门新语言的字母顺序进行了排序。需要根据这个输入的列表，还原出此语言中已知的字母顺序。
 * @Verion 1.0
 */

/**
 * 1.初始化图
 * 2.对图进行拓扑排序
 * 3.将排序结果返回
 */
public class AlienDictionary {
    public String alienDictionary(String[] strings) {
        Node[] graph = new Node[26];
        LinkedList<Character> characterOfZeroInDegree = new LinkedList<>();
        int[] inDegreeOfCharacter = new int[26];
        Set<Character> characterSet = new HashSet<>();


        //初始化graph和inDegreeOfCharacter
        for (char c : strings[0].toCharArray()) {
            characterSet.add(c);
        }
        for (int i = 1; i < strings.length; i++) {
            char[] currentArray = strings[i].toCharArray();
            char[] preArray = strings[i - 1].toCharArray();
            for (char c : currentArray) {
                characterSet.add(c);
            }
            for (int j = 0; j < currentArray.length && j < preArray.length; j++) {
                if (currentArray[j] != preArray[j]) {
                    if (graph[preArray[j] - 'a'] == null) {
                        graph[preArray[j] - 'a'] = new Node(currentArray[j]);
                        inDegreeOfCharacter[currentArray[j] - 'a']++;
                    } else {
                        Node node = graph[preArray[j] - 'a'];
                        Node pre = null;
                        while (node != null) {
                            if (node.character != currentArray[j]) {
                                pre = node;
                                node = node.next;
                            } else {
                                break;
                            }
                        }
                        if (node == null) {
                            pre.next = new Node(currentArray[j]);
                            inDegreeOfCharacter[currentArray[j] - 'a']++;
                        }
                    }
                    break;
                }
            }
        }

        //找出入度为0的字符
        for (Character character : characterSet) {
            if (inDegreeOfCharacter[character - 'a'] == 0) {
                characterOfZeroInDegree.offer(character);
            }
        }

        //遍历队列
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (!characterOfZeroInDegree.isEmpty()) {
            count++;
            Character ch = characterOfZeroInDegree.poll();
            stringBuilder.append(ch);
            //ch后面的字符的入度减1
            Node node = graph[ch - 'a'];
            while (node != null) {
                inDegreeOfCharacter[node.character - 'a'] -= 1;
                if (inDegreeOfCharacter[node.character - 'a'] == 0) {
                    characterOfZeroInDegree.offer(node.character);
                }
                node = node.next;
            }
        }

        if (count == characterSet.size()) {
            return stringBuilder.toString();
        } else {
            return "";
        }

    }

    class Node {
        char character;
        Node next;

        public Node(char character) {
            this.character = character;
        }
    }

    public static void main(String[] args) {
        String s = new AlienDictionary().alienDictionary(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        System.out.println(s);
    }
}
