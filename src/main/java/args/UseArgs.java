package args;

/**
 * Var args int is not the same as var arg Object!!!
 * int[] becomes the first arg to Object...
 */
public class UseArgs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int result1 = firstNumber(1, 2, 3);
        System.out.printf("result1 %s%n", result1);

        int result2 = UseArgs.firstNumber(nums);
        System.out.printf("result2 %s%n", result2);

        Object result3 = UseArgs.firstObject(1, 2, 3);
        System.out.printf("result3 %s%n", result3);

        Object result4 = UseArgs.firstObject(nums);
        System.out.printf("result4 %s%n", result4);
    }

    public static int firstNumber(int... nums) {
        return nums[0];
    }

    public static Object firstObject(Object... objects) {
        return objects[0];
    }
}
