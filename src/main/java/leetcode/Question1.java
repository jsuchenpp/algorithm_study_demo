package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Author chenpp【chenpingping1@xiao100.com】
 * @Date  2020年9月24日
 */
public class Question1 { 
    public String reorderSpaces(String text) {
        char[] textCharArray = text.toCharArray();
        List<String> wordList = new ArrayList<String>();
        int blankCount = 0;
        List<Character> wordCharList = new ArrayList<Character>();
        for (int i = 0; i < textCharArray.length; i++) {
            if(textCharArray[i] == ' ') {
                blankCount++;
                if(!wordCharList.isEmpty()) {
                    char[] wordCharArray = new char[wordCharList.size()];
                    for (int j = 0; j < wordCharList.size(); j++) {
                        wordCharArray[j] = wordCharList.get(j);
                    }
                    wordList.add(String.copyValueOf(wordCharArray));
                    wordCharList.clear();
                }
                continue;
            }else {
                wordCharList.add(textCharArray[i]);
            }
        }
        
        if(!wordCharList.isEmpty()) {
            char[] wordCharArray = new char[wordCharList.size()];
            for (int j = 0; j < wordCharList.size(); j++) {
                wordCharArray[j] = wordCharList.get(j);
            }
            wordList.add(String.copyValueOf(wordCharArray));
            wordCharList.clear();
        }
        
        if(blankCount == 0 && !wordList.isEmpty()) {
            return wordList.get(0);
        } else if(wordList.size() == 1) {
            StringBuilder sb = new StringBuilder();
            StringBuilder blankString = new StringBuilder();
            for (int i = 0; i < blankCount; i++) {
                blankString.append(" ");
            }
            
            sb.append(wordList.get(0)).append(blankString.toString());
            return sb.toString();
        } else {
            int y = blankCount % (wordList.size() - 1);
            if(y == 0) {
                int avg = blankCount / (wordList.size() - 1);
                StringBuilder sb = new StringBuilder();
                StringBuilder blankString = new StringBuilder();
                for (int i = 0; i < avg; i++) {
                    blankString.append(" ");
                }
                
                for (int i = 0; i < wordList.size(); i++) {
                    if(i < wordList.size() - 1) {
                        sb.append(wordList.get(i)).append(blankString.toString());
                    } else {
                        sb.append(wordList.get(i));
                    }
                }
                return sb.toString();
            } else {
                int avg = (blankCount - y) / (wordList.size() - 1);
                StringBuilder sb = new StringBuilder();
                StringBuilder blankString = new StringBuilder();
                for (int i = 0; i < avg; i++) {
                    blankString.append(" ");
                }
                
                for (int i = 0; i < wordList.size(); i++) {
                    if(i < wordList.size() - 1) {
                        sb.append(wordList.get(i)).append(blankString.toString());
                    } else {
                        sb.append(wordList.get(i));
                    }
                }
                
                for (int i = 0; i < y; i++) {
                    sb.append(" ");
                }
                return sb.toString();
            }
        }
        
    }
}
