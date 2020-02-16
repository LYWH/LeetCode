package StringPackage;

import java.util.HashSet;
import java.util.Set;

public class MaxSubString {
    //获取一个字符串的最大子串的长度
    public int subStringLength(String str){
        int maxLength = str.length()>0?1:0;
        Set<Character> characterSet = new HashSet<>();
        int i = 0, j = 0;
        while (i < str.length()&&j<str.length()){
            if(!characterSet.contains(str.charAt(j))){
                characterSet.add(str.charAt(j++));
                maxLength = Math.max(maxLength,j-i);
            }
            else {
                characterSet.remove(str.charAt(i++));
            }
        }
        return maxLength;
    }
}
