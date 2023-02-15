import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 5};

        ArrayList<Integer> arr1 = new Main().checkAvailableAccounts(2, 100, arr);
        System.out.println("final result " + arr1);
    }

    public ArrayList<Integer> checkAvailableAccounts(int a, int b, int[] c) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> availableAccounts = new ArrayList<>();

        for (int j : c) {

            while (!queue.isEmpty() && queue.peek() <= j) {
                queue.poll();
            }

            int accountBusy = j + b;
            queue.add(accountBusy);
            availableAccounts.add(Math.max(0, a - queue.size()));

        }
        return availableAccounts;
    }
}