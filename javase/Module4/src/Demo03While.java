public class Demo03While {
    public static void main(String[] args) {
        int mount = 8844430; // 珠穆朗玛峰的高度，单位是毫米
        double paper = 0.1;  // 纸的厚度，单位是毫米
        int count = 0;       // 折叠次数

        // 当纸的厚度小于山的高度时，进行折叠
        while(paper < mount) {
            paper *= 2;      // 每折叠一次，纸的厚度翻倍
            count++;         // 增加折叠次数
        }

        System.out.println(count); // 输出折叠次数
    }
}