import java.util.Random;

/**
 * @author greatqian
 * @description
 * @date 2020/12/21
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("hello world");
        createRandomTemperture();
    }


    public static void createRandomTemperture() {
        Random random = new Random();
        for (int i = 0; i < 14; i++) {
            System.out.println(36 + random.nextInt(12)*0.1);
        }
//        System.out.println(36 + 0.1);
    }

}
