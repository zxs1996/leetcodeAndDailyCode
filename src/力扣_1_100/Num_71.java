package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/14.
 */
public class Num_71 {

    public static void main(String[] args) {
        String res = new Num_71().simplifyPath("/a//b////c/d//././/..");
        System.out.println(res);
    }


    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return path;
        char ans[] = new char[path.length()];
        char arr[] = path.toCharArray();

        ans[0] = arr[0];
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '/') {
                if (index > 0 && ans[index - 1] == '/')
                    continue;
                ans[index++] = '/';
            }
            //遇到点
            else if (c == '.') {
                //
                if (i < arr.length - 2 && arr[i + 1] == '.' && arr[i + 2] == '.') {
                    ans[index++] = '.';
                    ans[index++] = '.';
                    ans[index++] = '.';
                    i += 2;
                }
                //返回上一级目录
                else if (i < arr.length - 1 && arr[i + 1] == '.') {
                    for (index = index - 2; index >= 0; index--) {
                        if (ans[index] == '/')
                            break;
                    }
                    if (index < 0)
                        index = 0;
                    i++;//跳过下一个点
                }
                //当前目录
                else {
                    index--;
                    continue;
                }
            } else
                ans[index++] = c;
        }
        //System.out.println(String.valueOf(ans)+","+index);
        if (index > 1 && ans[index - 1] == '/')
            index--;
        if (index == 0)
            return "/";
        return String.valueOf(ans).substring(0, index);
    }
}
