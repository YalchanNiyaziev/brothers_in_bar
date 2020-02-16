import java.util.Arrays;

public class Main {

    public static int brotherInTheBar(int[] array) {
        int roundCount = 0;
        int i = 0;
        do {
            i++;
            if ((array[i] == array[i + 1]) && (array[i] == array[i - 1])) {
                ++roundCount;
                int[] bufArray = new int[array.length - 3];
                array[i] = array[i + 1] = array[i - 1] = 0;
                for (int j = 0, k = 0; j < array.length; j++) {
                    if (array[j] == 0)
                        continue;
                    bufArray[k++] = array[j];
                }
                array = bufArray;
                i = 0;
            }
        } while (i < array.length - 2);
        return roundCount;
    }

    public static boolean hasLargeLength(int[] array) {
        boolean isLarge = true;
        RuntimeException runtimeException = new RuntimeException("Incorrect Array Size");
        try {
            if (array.length > 100_000||array.length<1)
                throw runtimeException;
            else
                isLarge = false;
        } catch (RuntimeException e) {
            System.out.println("The array size is bigger than 100 000 or smaller than 1 ");
            e.printStackTrace();
        }
        return isLarge;
    }

    public static boolean hasLargeElement(int[] array) {
        boolean isElementLarge = false;
        RuntimeException runtimeException = new RuntimeException("Incorrect element value");
        try {
            for (int element : array) {
                if (element > 1_000_000||element<1) {
                    isElementLarge = true;
                    break;
                }
            }
            if(isElementLarge)
                throw runtimeException;

        } catch (RuntimeException e) {
            System.out.println("Your array has a element with value bigger than 1 000 000 or smaller than 1");
            e.printStackTrace();
        }

        return isElementLarge;
    }

    public static void main(String[] args) {
        int[] glasses = {1, 1, 2, 3, 3, 3, 2, 2, 1, 1};
        int[] glasses2 = {1, 1, 2, 1, 2, 2, 1, 1};

        if((!hasLargeElement(glasses))&&(!hasLargeLength(glasses)))
        System.out.println(Arrays.toString(glasses) + " raund is: " + brotherInTheBar(glasses));

        if((!hasLargeElement(glasses2))&&(!hasLargeLength(glasses2)))
        System.out.println(Arrays.toString(glasses2) + " raund is: " + brotherInTheBar(glasses2));
    }
}
