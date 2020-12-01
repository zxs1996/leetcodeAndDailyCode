package duotai;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/1 20:43
 */
public abstract class Person {

    public abstract  void eat();
}

class Student extends Person{

    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }
}

class Teacher extends Person{

    @Override
    public void eat() {
        System.out.println("老师吃饭");
    }
}

