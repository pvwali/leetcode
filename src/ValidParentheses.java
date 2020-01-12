import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s ==null || s.length()==0) {
            return true;
        }
        int n = s.length();
        if (n %2 != 0) {
            return false;
        }

        Map<Character, Character> matcher = new HashMap<>();
        matcher.put('(',')');
        matcher.put('{','}');
        matcher.put('[',']');
        matcher.put('#','#');

        Stack<Character> stk = new Stack<>();
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (matcher.containsKey(c)) {
                stk.push(c);
            } else {
                char top = stk.isEmpty()? '#':stk.pop();
                if (matcher.get(top) != c) {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("{{]}"));
        System.out.println(vp.isValid("(()())"));
    }
}
