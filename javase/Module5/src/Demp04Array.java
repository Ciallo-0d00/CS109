public class Demp04Array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr1 = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
            System.out.println(arr1[i]);
        }
    }
}
