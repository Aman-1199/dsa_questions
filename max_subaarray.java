public class max_subaarray {
    public static void main(String[] args) {
        int arr[] = {4, 5, 9, 7, 6, 4, 3, 4};
        window(arr, 3);
    }

    static void window(int arr[], int k) {
        int l = 0, r = 0;
        int maxsum = Integer.MIN_VALUE;
        int cursum = 0;

        while (r < arr.length) {
            cursum += arr[r];

            if (r - l + 1 == k) {
                maxsum = Math.max(maxsum, cursum);
                cursum -= arr[l];
                l++;
            }

            r++;
        }

        System.out.println("Max sum of subarray of size " + k + " is: " + maxsum);
    }
}
