public class Demo05ArrayGet {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j]%3==0 && arr[j]%5==0 && arr[j]%7!=0){
                count++;
                System.out.println(j);
            }
        }
        System.out.println(count);
    }
}
