
public int isMatch(final String A, final String B) {
        char[] inputString = A.toCharArray();
        char[] regularExpr = B.toCharArray();
        //Both Empty
        if(inputString.length == 0 && regularExpr.length == 0)
            return 1;
        // Empty String with * Expression.
        if(inputString.length == 0 && regularExpr.length == 1 && regularExpr[0] == '*')
            return 1;

        int N = inputString.length;
        int M = regularExpr.length;
        boolean[] previousStringMatch = new boolean[M];
        boolean[] currentStringMatch = new boolean[M];

        for(int i = 0;i<N;i++){
            currentStringMatch = new boolean[M];
            for(int j = 0;j<M;j++){
                if(i == 0 && j == 0 && (inputString[i] == regularExpr[j] || regularExpr[j] == '*'))
                {
                    currentStringMatch[j] = true;
                }else if(inputString[i] == regularExpr[j] || regularExpr[j] == '?' )
                {
                    currentStringMatch[j] = true;
                }else if(regularExpr[j] == '*'){
                    if(j == 0)
                        currentStringMatch[j] = previousStringMatch[j];
                    if(i == 0)
                        currentStringMatch[j] = currentStringMatch[j-1];
                    if(i>0 && j > 0)
                        currentStringMatch[j] = previousStringMatch[j] || currentStringMatch[j-1];
                }else {
                    currentStringMatch[j] = false;
                }
            }
        }

}