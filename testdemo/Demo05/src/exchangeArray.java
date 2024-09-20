public class exchangeArray {
    public static void main(String[] args) {
        int[] a = {1,2};
        exchange(a);
        System.out.println(a[0]);
    }
    public static void exchange(int[] a){
        a[0] = a[1];
        a[1] = a[0];
    }
}

