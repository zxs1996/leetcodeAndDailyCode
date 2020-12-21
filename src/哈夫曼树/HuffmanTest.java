package 哈夫曼树;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zxs666
 * @date 2020/12/15 17:19
 */
public class HuffmanTest {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\admin\\Desktop\\算法实验\\实验五 哈夫曼\\data.txt";
        String outputPath = "C:\\Users\\admin\\Desktop\\算法实验\\实验五 哈夫曼\\encode.txt";


        //1、从输入文件获取数据
        String data = getData(inputPath);

        //2、采用固定长度编码的长度
        double fixedLength = fixedLength(data);

        //3、根据输入字符串创建huffman树
        Huffman huffman = new Huffman();
        huffman.createHuffmanTree(data);
        Map<Character ,String> map=huffman.map;
        for(char c:map.keySet())
            System.out.println(c+"- "+map.get(c));
        //4、获取哈夫曼编码
        String encodeStr = huffman.encodeStr(data);

        //5、写入到输出文件
        writeData(outputPath, encodeStr);

        //6、输出压缩率
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("压缩率为：" + df.format(encodeStr.length() / fixedLength * 100) + "%");

    }

    /**
     * 计算定长编码的的长度
     * @param str
     * @return
     */
    public static double fixedLength(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray())
            set.add(c);
        int typeCount = set.size();
        //每个字符的编码长度
        int perSize = (int) Math.ceil(Math.log(typeCount) / Math.log(2));
        return str.length() * (double) perSize;
    }

    /**
     * 从文件读取字符串
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String getData(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));//构造一个BufferedReader类来读取文件
        return br.readLine();

    }

    /**
     * 将编码后的字符串写入指定文件
     * @param filePath
     * @param data
     * @throws IOException
     */
    public static void writeData(String filePath, String data) throws IOException {
        File file = new File(filePath);
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "GBK"));//构造一个BufferedReader类来读取文件
        br.write(data);
        br.flush();
        br.close();
    }
}
