import java.util.Scanner;

public class WellFormedFormla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        boolean a = judge(string);
        System.out.println(a ? "true" : "false");
    }

    public static boolean judge(String formula) {
        formula = formula.replaceAll("\\s", "");
        if(formula.replaceAll("[()]", "").equals("")){
            return false;
        }

        String atoms = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String connectives = "∧∨→↔";
        int ParenthesesCount = 0;
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (atoms.indexOf(c) >= 0) {
                if (i + 1 < formula.length()  && atoms.indexOf(formula.charAt(i + 1))>=0){
                    return false;
                }else {
                    continue;
                }
            }
            if (connectives.indexOf(c) >= 0) {
                if (i == 0 || (formula.charAt(i - 1) != ')' && atoms.indexOf(formula.charAt(i - 1)) < 0)) {
                    return false;
                }
                if (i == formula.length() - 1 || (formula.charAt(i + 1) != '(' && atoms.indexOf(formula.charAt(i + 1)) < 0)) {
                    return false;
                }
            } else if (c == '¬') {
                if (i+1==formula.length() || formula.charAt(i+1) != ')' && atoms.indexOf(formula.charAt(i+1))<=0){
                    return false;
                }
            } else if (c == '(') {
                ParenthesesCount++;
            } else if (c == ')') {
                ParenthesesCount--;
                if (i < formula.length() - 1 && connectives.indexOf(formula.charAt(i + 1)) < 0 && formula.charAt(i + 1) != ')') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return ParenthesesCount == 0;
    }
}