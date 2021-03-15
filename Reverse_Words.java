class Scratch {
    public static void main(String[] args) {
        /*reverse a word - START*/
        String s = "  hello   world  today ";
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        int i, j;
        i = j = 0;
        int off = 0;
        while (i < chars.length) {
            if (chars[i] != ' ')
                i++;
            if ((chars[i] == ' ' || i == chars.length - 1) && i < chars.length) {
                if (builder.length() == 0) {
                    builder.insert(0, s.substring(j, i));
                } else {
                    builder.insert(0, ' ');
                    if(i==chars.length-1)
                        builder.insert(0, s.substring(j, chars.length));
                    else
                        builder.insert(0, s.substring(j, i));
                }
                i++;
                j = i;
            }
        }
        System.out.println(builder.toString());
        /*reverse a word - END*/
    }
}