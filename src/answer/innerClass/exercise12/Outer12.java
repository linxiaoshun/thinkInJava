package answer.innerClass.exercise12;

/**
 * @Auther: Gon
 * @Date: 2019/1/23 09:32
 * @Description:
 */
interface Inner12 {
    void modifyOuter();
}

public class Outer12 {
    private int oi = 1;

    private void hi() {
        System.out.println("Outer hi");
    }

    public Inner12 inner() {
        return new Inner12() {
            public void modifyOuter() {
                oi *= 2;
                hi();
            }
        };
    }

    public void showOi() {
        System.out.println(oi);
    }

    public static void main(String[] args) {
        Outer12 out = new Outer12();
        out.showOi();
        out.inner().modifyOuter();
        out.showOi();
    }
}
