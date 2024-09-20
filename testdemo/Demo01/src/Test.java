public class Test {
    private int num = 100;

    public Test() {
        this.num = num * 10;
    }

    public void calc(int num) {
        System.out.println(num);
    }

    public void printNum() {
        System.out.println(this.num);
    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.calc(2);
        obj.printNum();
    }
}