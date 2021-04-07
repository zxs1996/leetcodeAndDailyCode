package LRU;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zxs666
 * @date 2021/4/4 23:51
 */
public class LRU3<K, V> {

    int size = 0;
    int capacity;

    private class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }


    List<Node<K, V>> list;
    Map<K, Node> map;


    public LRU3() {
    }

    public LRU3(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }


    public V get(K key) {
        //如果不包含，那么直接返回null
        if (!map.containsKey(key))
            return null;
        //否则将这个点拿出来放到头部去
        Node node = map.get(key);
        //拿出来放到链头去
        list.remove(node);
        list.add(0, node);

        return (V) node.value;
    }

    public void put(K key, V value) {

        //如果包含这个元素,那么更新他的值，然后调用一次get方法，会把他放到前面去。
        if (map.containsKey(key)) {
            //更新值，然后放入
            map.get(key).value = value;
            get(key);//调用一次get方法，把他放到前面去
            return;
        }
        //否则创建节
        Node newNode;
        //如果满了，修改最后一个node的key和val
        if (size == capacity) {
            newNode = list.get(size - 1);
            //从map移除
            map.remove(newNode.key);
            //修改这个node的key和value
            newNode.key = key;
            newNode.value = value;
            list.remove(newNode);

        } else {
            size++;
            newNode = new Node(key, value);
        }

        map.put(key, newNode);
        list.add(0, newNode);
    }


    public static void main(String[] args) {
        LRU3<Integer, Integer> lru2 = new LRU3<>(3);
        for (int i = 0; i < 5; i++)
            lru2.put(i + 1, i + 2);
        lru2.put(3, 303);
        for (int i = 2; i < 5; i++)
            System.out.println(lru2.get(i + 1));
    }




}
