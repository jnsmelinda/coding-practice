package leetcode.p006_zigzag;

import java.util.HashMap;

public class ZigZag {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows==1) return s;
        String ret = "";
        int index = 0;
        int len = s.length();
        boolean reverse = false;
        HashMap<Integer,String> hm = new HashMap<>();
        while (index<len){
            if (!reverse) {
                for (int i = 0; i < numRows-1 && index<len; i++) {
                    String val = hm.getOrDefault(i, "");
                    hm.put(i,  val+ s.charAt(index));
                    index++;
                }
                reverse=true;
            }else {
                for (int i=numRows-1;i>=1 && index<len;i--){
                    String val = hm.getOrDefault(i, "");
                    hm.put(i,  val+ s.charAt(index));
                    index++;
                }
                reverse=false;
            }

        }
        for (int key : hm.keySet()){
            ret = ret + hm.get(key);
        }
        return ret;
    }
}
