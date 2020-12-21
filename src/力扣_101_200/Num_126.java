package 力扣_101_200;


import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/11/8 19:48
 */
public class Num_126 {

    @Test
    public void test() {
        String beginWord = "cet";
        String endWord = "ism";
        List<String> wordList = new ArrayList<>(Arrays.asList("kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"));
        List<List<String>> res = findLadders(beginWord, endWord, wordList);
        System.out.println(res.size());
        for (List<String> temp : res) {
            System.out.println(Arrays.toString(temp.toArray()));
        }
    }

    private class GraphNode {
        String val;
        Set<GraphNode> next;

        public GraphNode(String val) {
            this.val = val;
            next = new HashSet<>();
        }
    }

    GraphNode[] nodeArr;
    Map<String, Integer> map;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            if (beginWord.equals(wordList.get(i))) {
                wordList.set(i, wordList.get(wordList.size() - 1));
                wordList.remove(wordList.size() - 1);
            }
        }
        nodeArr = new GraphNode[wordList.size() + 1];
        nodeArr[0] = new GraphNode(beginWord);
        for (int i = 0; i < wordList.size(); i++)
            nodeArr[i + 1] = new GraphNode(wordList.get(i));
        map = new HashMap<>();
        for (int i = 0; i < nodeArr.length; i++)
            map.put(nodeArr[i].val, i);
        List<List<String>> res = new ArrayList<>();
        int minLenght = ladderLength(beginWord, endWord, wordList);
        for(int i=0;i<nodeArr.length;i++)
        System.out.println(i+"---"+nodeArr[i].val+"--"+nodeArr[i].next.size());
        if (minLenght == 0)
            return res;
        minLenght--;
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        Set<String> set = new HashSet<>();
        System.out.println(minLenght);
        set.add(beginWord);
        dfs(minLenght, nodeArr[0], endWord, queue, res, set);
        return res;
    }

    public void dfs(int count, GraphNode currNode, String endWord, ArrayDeque<String> queue, List<List<String>> res, Set<String> set) {
        //System.out.println(count);
        if (count == 0) {
            if (currNode.val.equals(endWord))
                res.add(new ArrayList<>(queue));
            return;
        }
        for (GraphNode node : currNode.next) {
            if (set.contains(node))
                continue;
            queue.addLast(node.val);
            set.add(node.val);
            dfs(count - 1, node, endWord, queue, res, set);
            set.remove(node.val);
            queue.removeLast();
        }

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String str : wordList)
            set.add(str);
        if (!set.contains(endWord))
            return 0;
        Set<String> visited = new HashSet<>();//访问标志
        Queue<String> queue = new ArrayDeque<>();//bfs队列
        queue.add(beginWord);
        int step = 1;
        boolean flag = false;
        while (!queue.isEmpty()) {
            if (flag)
                return step;
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String str = queue.poll();
                flag = exchangeEachCharacter(str, endWord, set, visited, queue) || flag;
            }
            step++;//美过一轮setp++
        }
        if (flag)
            return step;
        return 0;
    }

    public boolean exchangeEachCharacter(String s, String endWord, Set<String> set, Set<String> visited, Queue<String> queue) {
        GraphNode node1 = nodeArr[map.get(s)];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char originalCharacter = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalCharacter)
                    continue;
                arr[i] = c;
                String currentStr = new String(arr);
                if (set.contains(currentStr)) {
                    GraphNode node2 = nodeArr[map.get(currentStr)];
                    node1.next.add(node2);
                    node2.next.add(node1);
                }
                if (currentStr.equals(endWord)) {
                    return true;
                } else if (set.contains(currentStr) && !visited.contains(currentStr)) {
                    //建立图

                    queue.add(currentStr);
                    visited.add(currentStr);//加入访问队列
                }
            }
            arr[i] = originalCharacter;
        }
        return false;
    }

}
