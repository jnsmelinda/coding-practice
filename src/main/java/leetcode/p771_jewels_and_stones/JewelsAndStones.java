package leetcode.p771_jewels_and_stones;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing
 *  the stones you have.  Each character in S is a type of stone you have.  You want to know how
 *  many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        int counter = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) > -1) {
                counter++;
            }
        }
        return counter;
    }
}
