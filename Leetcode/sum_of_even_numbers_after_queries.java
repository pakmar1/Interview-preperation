class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] op =new int[A.length];
        for(int i=0;i<queries.length;i++)
        {
            int sum=0;
            A[queries[i][1]] += queries[i][0];
            for(int j=0;j<A.length;j++)
            {
                if(A[j]%2==0)
                    sum += A[j];
            }
            op[i] = sum;
        }
        return op;
        
    }
}
