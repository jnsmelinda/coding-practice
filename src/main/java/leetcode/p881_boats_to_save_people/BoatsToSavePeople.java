package leetcode.p881_boats_to_save_people;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {3,1,7,4,5};
        System.out.println(numRescueBoats(people, 4));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int numBoats = 0;
        int i = 0;
        int j = people.length -1;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            }
            else {
                j--;
            }
            numBoats++;
        }

        return numBoats;
    }
}
