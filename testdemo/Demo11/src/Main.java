public class Main {
    public static <T> T getFirstElement(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[0];
    }

    public static void main(String[] args) {
        // 创建不同类型的数组
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"hello", "world", "!"};

        // 调用泛型方法
        Integer firstInt = getFirstElement(intArray);
        String firstString = getFirstElement(strArray);

        // 打印结果
        System.out.println("First element of intArray: " + firstInt);
        System.out.println("First element of strArray: " + firstString);
    }
}