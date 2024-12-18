package code.easy;

import java.util.Stack;

public class FinalPricesWithaSpecialDiscountShop1475 {
    class pair{
        int index;
        int value;
        public pair(int index, int value){
            this.index = index;
            this.value = value;
        }
        int getIndex(){
            return index;
        }
        void setValue(int value){
            this.value = value;
        }
    }
    public int[] finalPrices(int[] prices) {
        Stack<pair> stk = new Stack<>();
        for(int i = 0;i<prices.length;i++){
            while(!stk.isEmpty() && prices[i] <= stk.peek().value){
                pair p = stk.pop();
                prices[p.getIndex()] -= prices[i];
            }
            stk.push(new pair(i, prices[i]));
        }
        return prices;
    }
}
