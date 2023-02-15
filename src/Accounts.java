/*
We want to stimulate a simple order dispatch module. We have A different accounts/ connections with the exchange. At any point in time, we can send an order via an account if it is in “available” mode. The account goes in “busy” mode for B microseconds after sending an order successfully.

We are given a list C of timestamps of the orders where C[i] denotes that an order was placed at C[i] microseconds. The timestamps are given in increasing order of time. For each timestamp entry, we need to find the number of accounts available after sending this particular order. If no account is available before sending the order, the answer is 0

 A = 4
  B = 5
  C = [0, 1, 6, 11]


  Output 1:
  [3, 2, 3, 3]

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Accounts {

    public Accounts() {
        int[] arr = {0, 1, 5};
        ArrayList<Integer> arr1 = this.checkAvailableAccounts(2, 100, arr);
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
