package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2020年9月24日
 */
public class Question2 {
    public static void main(String[] args) {
//        System.out.println(maxUniqueSplit("ababccc"));
//        System.out.println(maxUniqueSplit("aba"));
//        System.out.println(maxUniqueSplit("aa"));
        System.out.println(maxUniqueSplit("wwwzfvedwfvhsww"));
//        System.out.println(maxUniqueSplit("wzfvedwwwfvhsww"));
//        System.out.println(maxUniqueSplit("wzfvedwwfvhswww"));
    }
    
    public static int maxUniqueSplit(String s) {
        List<String> resultList = new ArrayList<String>();
        
        int length = s.length();
        String rightString = s;
        
        int len = 1;
        for (int i = 0; i < length; i++) {
            String leftString = rightString.substring(0, len);
            String tempRightString = rightString.substring(len, rightString.length());
            System.out.println("leftString=" + leftString + ",tempRightString=" + tempRightString);
            if(!"".equals(leftString) && !"".equals(tempRightString) && leftString.equals(tempRightString)) {
                if(len < rightString.length()) {
                    len++;
                    continue; 
                } else {
                    break;
                }
            }
            
            if(!"".equals(leftString) && !"".equals(tempRightString) &&(resultList.contains(leftString) || resultList.contains(tempRightString))) {
                if(len < rightString.length()) {
                    len++;
                    continue; 
                } else {
                    break;
                } 
            }
            
            if("".equals(tempRightString)) {
                resultList.add(leftString);
                break;
            }
            
            resultList.add(leftString);
            rightString = tempRightString;
            len = 1;
        }
        
        System.out.println("resultList=" + resultList);
        return resultList.size();
    }
}
