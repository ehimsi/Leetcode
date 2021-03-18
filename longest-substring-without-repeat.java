import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Scratch {
    public static void main(String[] args) {

        //abccabb
        //ccccc
        //""
        //abcbda

        String a = "ccccc";

        int i = 0;
        int j = i + 1;
        int startIdx = 0;
        int max = 0;
        char[] chars = a.toCharArray();
        Set<Character> resultSet = new HashSet<>();
        if(chars.length >0)
            resultSet.add(chars[i]);
        while (i < chars.length && j < chars.length) {
            if (resultSet.add(chars[j])) {
                if(chars[i] != chars[j]){
                    i++;
                    j++;
                    continue;
                }
            } else {
                startIdx++;
                i = startIdx;
                j = i + 1;
                max = (max < resultSet.size()) ? resultSet.size() : max;
                resultSet = new HashSet<>();
                resultSet.add(chars[i]);
                continue;
            }
        }
        System.out.println((max < resultSet.size()) ? resultSet.size() : max);
    }
}