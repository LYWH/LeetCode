package Palindrome;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String palindrome = "";
        for(int i = 0; i < s.length();i++){
            for(int j = i; j < s.length();j++){
                if(isPalindrome(s,i,j) && palindrome.length()<j-i+1){
                    palindrome = s.substring(i,j+1);
                }
            }
        }
        return palindrome;
    }
    public boolean isPalindrome(String s,int start,int end){

        for(int i = start;i < (end + start)/2+1;i++){
            if(s.charAt(i) != s.charAt(end + start -i)){
                return false;
            }
        }
        System.out.println(s.substring(start,end+1));
        return true;
    }
}
