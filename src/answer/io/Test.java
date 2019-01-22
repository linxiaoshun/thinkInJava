package answer.io;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: Gon
 * @Date: 2019/1/16 14:11
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("a.java").getAbsoluteFile();
        System.out.println(file);
        System.out.println(file.exists());
    }
}
