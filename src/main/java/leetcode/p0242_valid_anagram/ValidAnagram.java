package leetcode.p0242_valid_anagram;

import java.util.ArrayList;
import java.util.List;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "cat"));
    }

    public static boolean isAnagram(String s, String t) {
        List<Character> lstLetters = new ArrayList<Character>();
        for(int x=0; x<s.length(); x++){
            lstLetters.add(s.charAt(x));
        }

        for(int i=0; i<t.length(); i++){
            int index = lstLetters.indexOf(t.charAt(i));
            if(index == -1){
                return false;
            }else{
                lstLetters.remove(index);
            }
        }
        return lstLetters.size() == 0;
    }
}
