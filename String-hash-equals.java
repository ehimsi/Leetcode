import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {
        String one = "abc#d";
        String two = "abzz##d";

        List<Character> ones = new ArrayList<>();
        List<Character> twos = new ArrayList<>();

        /*String new1 = one.chars()
                .filter(Character::isAlphabetic)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        String new2 = two.chars()            // or codePoints()
                .filter(Character::isAlphabetic)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();*/

        //sub-optimal
        updateArr(one, ones);
        updateArr(two, twos);
        System.out.println(ones.containsAll(twos));//Space - O(2a+b) or O (a+2b) - non optimal solution.
    }

    private static void updateArr(String str, List<Character> list) {
        for (char i : str.toCharArray()) {
            if (i == '#' && list.size() > 0) {
                list.remove(list.size() - 1);
            } else {
                list.add(i);
            }
        }
    }
}