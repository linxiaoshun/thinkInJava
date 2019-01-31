package answer.reusing.Exercise5;

/**
 * @Auther: Gon
 * @Date: 2019/1/31 13:08
 * @Description:
 */
class A {
    A() {
        System.out.println("A()");
    }
}

class B extends A {
    B() {
        System.out.println("B()");
    }
}

class C extends A {
    B b = new B(); // will then construct another A and then a B

    public static void main(String[] args) {
        C c = new C(); // will construct an A first
    }
}