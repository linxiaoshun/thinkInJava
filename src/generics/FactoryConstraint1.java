package generics;

/**
 * @author lxs
 * @Description
 * @createTime 2021年12月09日 18:49:00
 */
public class FactoryConstraint1 {

    public static void main(String[] args) {
        Foo22<Integer> integerFoo22 = new Foo22<>(new IntegerFactoryI1());
        System.out.println(integerFoo22.t);

        Foo22<String> stringFoo22 = new Foo22<>(new StringFactoryI2());
        System.out.println(stringFoo22.t);
    }
}

interface FactoryI1<T> {
    T create();
}

class Foo22<T> {
    T t;

    public <U extends FactoryI1<T>> Foo22(U factoryI1) {
        t = factoryI1.create();
    }
}

class IntegerFactoryI1 implements FactoryI1<Integer> {

    @Override
    public Integer create() {
        return new Integer(3);
    }
}

class StringFactoryI2 implements FactoryI1<String> {
    @Override
    public String create() {
        return "hello";
    }
}


