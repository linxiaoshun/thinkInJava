package answer.io.Exercise1_3;

import net.mindview.util.TextFile;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Auther: Gon
 * @Date: 2019/1/16 11:37
 * @Description:过滤文件中存在相应字符的文件名，命令行参数是文件中存在的字符过滤条件
 */
public class DirList1b {
    public static void main(final String[] args) {
        File path = new File(".");
        final String[] list;
        if (args.length == 0) {
            list = path.list();
            System.out.println(
                    "Usage: enter words, one or more of which each file must contain");
        } else {
            list = path.list((dir, name) -> !(Collections.disjoint(
                    Arrays.asList(args),
                    new TextFile(name, "\\W+")
            )
            ));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}
