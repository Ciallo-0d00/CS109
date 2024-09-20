import java.util.Arrays;
import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
//        int[] array1 = {1,2,3,4,5};
//        int[] array2 = new int[5];
//        array2[0] = 6;
//        array2[1] = 7;
//        array2[2] = 8;
//
//        for (int i = 0; i < array1.length; i++) {
//            System.out.print(array1[i]+" ");
//            System.out.println();
//
//
//        }
//        for (int e:array2){
//            e++;
//            System.out.println(e);
//        }
        // 声明并初始化一个数组
//        int[] numbers = {1, 2, 3, 4, 5};
//
//        // 使用传统的for循环来修改数组元素
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = numbers[i] * 2; // 将每个元素的值翻倍
//        }
//
//        // 再次使用foreach循环来打印修改后的数组元素
//        for (int number : numbers) {
//            System.out.println(number);
//        }
//        System.out.println(Arrays.toString(numbers));

//
//        char[] array3 = {'a','b','c'};
//        System.out.println(array3);
//        System.out.println(Arrays.toString(array3));
//
//        char[] charArray = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
//
//        // 直接打印char数组
//        System.out.println(charArray);

        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
//        int[] arr2 = arr1;//此时指向为同一个地址值
        int[] arr2 = Arrays.copyOf(arr1,arr1.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
//
//        for (int i = 0; i < arr2.length; i++) {
//            arr2[i] = 2*i;
//
//        }
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
//
//
//        int[][] arr0 = new int[2][4];
//        int[][] arr1 = {{1,2,3,4},{5,8,9,0}};
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr1[i].length; j++) {
//                System.out.println(arr1[i][j]);
//
//            }
//
//        }
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] arr = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//
//        } System.out.println(arr[n-1][m-1]);
//
    }
}
