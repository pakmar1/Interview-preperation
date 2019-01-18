class Solution:
    def kClosest(self, points, K):
        """
        :type points: List[List[int]]
        :type K: int
        :rtype: List[List[int]]
        """        
        dist = []
        for i in range(len(points)):
            dist.append([points[i],math.sqrt( points[i][0]**2+points[i][1]**2)])
            
        
        dist.sort(key = lambda s:s[1])
        ans=[]
        for x in range(K):
            ans.append(dist[x][0])
        return ans
    
        
