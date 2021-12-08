package generics.coffee;

import net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @author lxs
 * @Description
 * @createTime 2021年12月08日 16:18:00
 */
public class CoffeeGenerator1 implements Generator<Coffee>, Iterable<Coffee> {

    public static final Class<Coffee>[] types = new Class[]{Americano.class, Breve.class, Cappuccino.class};
    Random random = new Random(47);

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try {
            return types[random.nextInt(types.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    int count;

    public CoffeeGenerator1(int count) {
        this.count = count;
    }

    class CoffeeIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Object next() {
            count--;
            return CoffeeGenerator1.this.next();
        }

    }

    public static void main(String[] args) {


        CoffeeGenerator1 gen = new CoffeeGenerator1(10);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        for (Coffee coffee : gen) {
            System.out.println(coffee);
        }
    }
}
