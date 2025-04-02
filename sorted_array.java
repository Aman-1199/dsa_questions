public class sorted_array {
    public static boolean sorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && sorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 5, 6, 8};
        System.out.println(sorted(ar, 0));
    }
}
