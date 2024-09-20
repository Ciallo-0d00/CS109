public class Test {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        //不同之处，此处要把每行的数组先进行倒序
        for (int i = 0; i < numbers.length/2; i++) {
            numbers[i] = numbers[numbers.length - 1 - i];
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]+ " ");
        }

    }

}
