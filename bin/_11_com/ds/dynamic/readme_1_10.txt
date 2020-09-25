
//TODO 1: _02a_DistinctSubsequence_3

                int[][] T = new int[t.length() + 1][s.length() + 1];
                //TODO fills entire row 0 with 1 and all col0 with 0
                for (int i = 0; i < T[0].length; i++) {
                    T[0][i] = 1;
                }

                for (int i = 1; i < T.length; i++) {
                    for (int j = 1; j < T[0].length; j++) {
                        if (s.charAt(j - 1) == t.charAt(i - 1)) {
                            T[i] [j] = T[i-1][j-1] + T[i][j-1];
                        } else {
                            T[i][j] = T[i][j-1];
                        }
                    }
                }
                return T[t.length()][s.length()];

//TODO 2: Longest Palindrome Subsequense

            for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                //TODO if char are equal then it must be 2
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    //TODO remember t[i][j] is always +2
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }