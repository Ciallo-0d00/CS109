import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MyString a = new MyString("abc");
        MyString b = new MyString();
        b.add('a');
        b.add('c');
        b.add('c');
        if (a.equals(b)) System.out.println("They are same.");
        else System.out.println("They are different.");
        b.set(1, 'b');
        if (a.equals(b)) System.out.println("They are same.");
        else System.out.println("They are different.");
        char[] arr = a.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            System.out.print(arr[i]);
        }
        a.print();

        String filePath = "Testln.txt";
        String firstLine = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            firstLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MyString c = new MyString(firstLine);




    }
}





