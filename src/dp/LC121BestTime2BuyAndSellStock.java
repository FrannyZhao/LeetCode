package dp;

public class LC121BestTime2BuyAndSellStock {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                result = Math.max(result, prices[j] - buy);
            }
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            result = Math.max(result, price - min);
        }
        return result;
    }

    public int maxProfit3(int[] prices) {
        int result = 0;
        if (prices != null && prices.length > 0) {
            int[] delta = new int[prices.length - 1];
            for (int i = 1; i < prices.length; i++) {
                delta[i - 1] = prices[i] - prices[i - 1];
            }
            if (delta.length > 0) {
                result = delta[0];
                for (int i = 1; i < delta.length; i++) {
                    if (delta[i - 1] > 0) {
                        delta[i] += delta[i - 1];
                    }
                    result = Math.max(result, delta[i]);
                }
            }
        }
        return result < 1 ? 0 : result;
    }

    public static void main(String[] args) {
        LC121BestTime2BuyAndSellStock test = new LC121BestTime2BuyAndSellStock();
        int result;

//        result = test.maxProfit(new int[]{7,1,5,3,6,4});
//        System.out.println(result);
//        assert result == 5;
//
//        result = test.maxProfit(new int[]{7,6,4,3,1});
//        System.out.println(result);
//        assert result == 0;

//        result = test.maxProfit2(new int[]{7,1,5,3,6,4});
//        System.out.println(result);
//        assert result == 5;
//
//        result = test.maxProfit2(new int[]{7,6,4,3,1});
//        System.out.println(result);
//        assert result == 0;

        result = test.maxProfit3(new int[]{7,1,5,3,6,4});
        System.out.println(result);
        assert result == 5;

        result = test.maxProfit3(new int[]{7,6,4,3,1});
        System.out.println(result);
        assert result == 0;

        System.out.println(" ====== Success! =====");
    }
}
