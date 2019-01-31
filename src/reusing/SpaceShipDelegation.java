package reusing;

/**
 * @Auther: Gon
 * @Date: 2019/1/31 13:30
 * @Description:
 */
public class SpaceShipDelegation {

    private SpaceShipControls controls=new SpaceShipControls();

    public void up(int i) {
        controls.up(i);
    }

    public void down(int i) {
        controls.down(i);
    }

    public void left(int i) {
        controls.left(i);
    }

    public void right(int i) {
        controls.right(i);
    }

    public void forward(int i) {
        controls.forward(i);
    }

    public void back(int i) {
        controls.back(i);
    }

}

class SpaceShipControls{
    void up(int i){}
    void down(int i){}
    void left(int i){}
    void right(int i){}
    void forward(int i){}
    void back(int i){}
}
