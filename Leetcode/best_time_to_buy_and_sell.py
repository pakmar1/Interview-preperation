class Solution:
    def maxProfit(self, prices: 'List[int]') -> 'int':
        min_ = 31767
        profit = 0
        for price in prices:
            if price < min_:
                min_ = price
            
            profit = max(price - min_,profit)
                
        return profit
