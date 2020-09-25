//TODO 1: Egg Drop problem

         //TODO  min (1+ max( attemps if eggs breaks, attempts if egg does not  break) )

         for(int e = 2; e <= eggs; e++){
            for(int f = 1; f <=floors; f++){
                //TODO T[e][f] is assigned a value
                T[e][f] = Integer.MAX_VALUE;
                // TODO k another variable
                for(int k = 1; k <=f ; k++){
                    //TODO 1+ max(T[e][k], T[e][f-k])).
                    //TODO remember 1+........
                    c = 1 + Math.max(T[e-1][k-1], T[e][f-k]);
                    //TODO 1+ min (max(T[e][k], T[e][f-k])).
                    if(c < T[e][f]){
                        T[e][f] = c;
                    }
                }
            }
        }

// TODO 2: How to print maximum number of A�s using given four keys

        //TODO for i <7 T[i] =i
        for (int i = 7; i <= n; i++) {
			for (int j = i - 3; j > 0; j--) {
				//TODO For n =7,  F(4)*2 = 8, F(3)*3 =9, F(2)*4 =8, F(1)*5 = 5 max is 9
				T[i] = Math.max(T[i], T[j] * (i - j - 1));
			}
		}
		return T[n];

// TODO 3: Word break problem

         for(int i=0; i < T.length; i++){
                    for(int j=0; j < T[i].length ; j++){
                        T[i][j] = -1; //-1 indicates string between i to j cannot be split
                    }
                }


        for(int l = 1; l <= word.length(); l++){
                   for(int row=0; row < word.length() -l + 1 ; row++){
                       int col = row + l-1;
                       //TODO str substring from row to col
                       String str = word.substring(row,col+1);
                       //TODO if string between row to col is in dictionary T[row][col] is true
                       if(dict.contains(str)){
                           //TODO here row goes
                           T[row][col] = row;
                           continue;
                       }
                       //TODO find a k between row+1 to col such that T[row][k-1] && T[k][col] are both true
                       for(int k=row+1; k <= col; k++){
                           if(T[row][k-1] != -1 && T[k][col] != -1){
                               //TODO Here k goes
                               T[row][col] = k;
                               break;
                           }
                       }
                   }
               }

 // TODO 4: Text Justification

               for(int i=0; i < words.length; i++){
                   for(int j=i; j < words.length; j++){
                       if(cost[i][j] < 0){
                           cost[i][j] = Integer.MAX_VALUE;
                       }else{
                           cost[i][j] = (int)Math.pow(cost[i][j], 2);
                       }
                   }
               }

              //TODO minCost from i to len is found by trying
                   //j between i to len and checking which
                  //one has min value

               int minCost[] = new int[words.length];
               int result[] = new int[words.length];
                  for(int i = words.length-1; i >= 0 ; i--){
                      //weight from ith position to the end of the lineor matrix column
                      minCost[i] = cost[i][words.length-1];
                      result[i] = words.length;
                      for(int j=words.length-1; j > i; j--){

                          if(cost[i][j-1] == Integer.MAX_VALUE){
                              continue;
                          }
                          //TODO Check the logic here
                          if(minCost[i] > minCost[j] + cost[i][j-1]){
                              minCost[i] = minCost[j] + cost[i][j-1];
                              result[i] = j;
                          }
                      }
                  }

 //TODO 5: Wild Card

        for (int i = 1; i < T.length; i++) {
        			for (int j = 1; j < T[0].length; j++) {
        				if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
        					T[i][j] = T[i - 1][j - 1];
        				} else if (pattern[j - 1] == '*') {
        					T[i][j] = T[i - 1][j] || T[i][j - 1];
        				}
        			}
        		}



 //TODO 6: Regex

   boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

         T[0][0] = true;
         //TODO Deals with patterns like a* or a*b* or a*b*c*
         for (int i = 1; i < T[0].length; i++) {
             if (pattern[i-1] == '*') {
                 T[0][i] = T[0][i - 2];
             }
         }
         //TODO i-> text and j->pattern
         for (int i = 1; i < T.length; i++) {
             for (int j = 1; j < T[0].length; j++) {
                 if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                     //Same wild expression
                     T[i][j] = T[i-1][j-1];
                     //
                 } else if (pattern[j - 1] == '*')  {
                     T[i][j] = T[i][j - 2];
                     if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                         T[i][j] = T[i][j] | T[i - 1][j];
                     }
                 } else {
                     T[i][j] = false;
                 }
             }
         }
         return T[text.length][pattern.length];
     }