import java.util.ArrayList;

public class MyString {
    private ArrayList<Character> str;

    public MyString(String a) {
        str = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            str.add(a.charAt(i));
        }
    }

    public MyString() {
        str = new ArrayList<>();
    }

    public void add(char x) {
        str.add(x);
    }

    public void set(int index, char x) {
        str.set(index,x);
    }

    public char charAt(int index) {
        return str.get(index);
    }

    public int length() {
        return str.size();
    }

    public boolean equals(MyString b) {
        return str.equals(b);
    }

    public char[] toCharArray() {
        char[] a = new char[str.size()];
        for (int i = 0; i < str.size(); i++) {
            a[i] = str.get(i);
        }
        return a;
    }

    public void print() {
        for (int i = 0; i < str.size(); i++) {
            System.out.print(str.get(i));
        }
    }

    public String reverse(){
        return null;
    }

}
