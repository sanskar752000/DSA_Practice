class Solution {
    // Returns maximum profit
    // with two transactions on a
    // given list of stock prices,
    // price[0..n-1]
    static int maxProfit(int price[], int n)
    {
        int result = 0;
        int[] profit = new int[n];
        for(int i=0; i<n; i++) {
            profit[i] = 0;
        }

        int maxProfit = price[n-1];
        for(int i=n-2; i>=0; i--) {

            if(maxProfit < price[i]) {
                maxProfit = price[i];
            }

            profit[i] = Math.max(profit[i+1], maxProfit-price[i]);
        }

        int minProfit = price[0];
        for(int i=1; i<n; i++) {

            if(minProfit > price[i]) {
                minProfit = price[i];
            }

            profit[i] = Math.max(profit[i-1], profit[i]+(price[i]-minProfit));
        }
        result = profit[n-1];
        return result;
    }
 
    // Driver Code
    public static void main(String args[])
    {
        int price[] = { 10, 22, 5, 75, 65, 80 };
        int n = price.length;
        System.out.println("Maximum Profit = "
                           + maxProfit(price, n));
    }
 
}