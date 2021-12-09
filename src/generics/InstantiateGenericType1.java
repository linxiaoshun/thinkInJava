package generics;

/**
 * @author lxs
 * @Description
 * @createTime 2021年12月09日 18:35:00
 */
public class InstantiateGenericType1 {


    public static void main(String[] args) {
        ClassAsFactory1<String> factory1 = new ClassAsFactory1<>(String.class);
        System.out.println(factory1.t);

        ClassAsFactory1<Integer> integerClassAsFactory1 = new ClassAsFactory1<>(Integer.class);
        System.out.println(integerClassAsFactory1.t);
    }
}


class ClassAsFactory1<T> {
    T t;

    public ClassAsFactory1(Class<T> clz) {
        try {
            t = clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}