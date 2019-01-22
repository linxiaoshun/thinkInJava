package answer.io.Exercise1_3;

import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 * @Auther: Gon
 * @Date: 2019/1/16 11:37
 * @Description:过滤文件中存在相应字符的文件名，第一个命令行参数过滤文件，之后的参数是文件中存在的字符过滤条件
 */
public class DirList1a {
    public static void main(final String[] args) {
        File path = new File(".");
        final String[] list;
        if(args.length < 2) {
            list = path.list();
            System.out.println("Usage: enter filtering regex");
            System.out.println(
                    "followed by words, one or more of which each file must contain.");
        }
        else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches() &&
                            !(Collections.disjoint(
                                    Arrays.asList(args).subList(1, args.length),
                                    new TextFile(name, "\\W+")// \w：用于匹配字母，数字或下划线字符； \W：用于匹配所有与\w不匹配的字符；
                            ));
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}
