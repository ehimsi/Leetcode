class Scratch {
    static int idx = 0;
    public static void main(String[] args) {

        String str = "{([]}";
        char[] stack = new char[str.length()];
        for (char c : str.toCharArray()) {
            switch (c) {
                case '[': {
                    if(idx>0 && peek(stack)==']') {
                        pop(stack);
                    } else {
                        push(stack,c);
                    }
                    break;
                }
                case ']': {
                    if(idx>0 && peek(stack)=='[') {
                        pop(stack);
                    } else {
                        push(stack,c);
                    }
                    break;
                }
                case '(': {
                    if(idx>0 && peek(stack)==')') {
                        pop(stack);
                    } else {
                        push(stack,c);
                    }
                    break;
                }
                case ')': {
                    if(idx>0 && peek(stack)=='(') {
                        pop(stack);
                    } else {
                        push(stack,c);
                    }
                    break;
                }
                case '{': {
                    if(idx>0 && peek(stack)=='}') {
                        pop(stack);
                    } else {
                        push(stack,c);
                    }
                    break;
                }
                case '}': {
                    if(idx>0 && peek(stack)=='{') {
                        pop(stack);
                    } else {
                        push(stack,c);
                    }
                    break;
                }
            }
        }
        if (idx == 0) {
            System.out.println("balanced!");
        } else {
            System.out.println("unBalanced!");
        }
    }

    public static void push(char[] stack, char ele) {
        stack[idx++] = ele;
    }

    public static char peek(char[] stack) {
        return stack[idx - 1];
    }

    public static char pop(char[] stack) {
        return stack[idx--];
    }
}
