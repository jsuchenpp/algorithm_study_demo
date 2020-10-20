package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2020年9月24日
 */
public class Question5 {
    public static void main(String[] args) {
        String[] logs = new String[] {"d1/","../","../","../"};
        System.out.println(minOperations(logs));
    }
    
    public static int minOperations(String[] logs) {
        String pf = "../";
        String cf = "./";
        
        List<String> r = new ArrayList<String>();
        for (int i = 0; i < logs.length; i++) {
            if(logs[i].equals(cf)) {
                continue;
            } else if (logs[i].equals(pf)) {
                if(!r.isEmpty()) {
                    r.remove(r.size() - 1);
                }
            } else {
                r.add(logs[i]);
            }
        }
        return r.size();
    }
}
