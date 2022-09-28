class PairBox{
    int row;
    int col;
    PairBox(int row,int col){
        this.row = row;
        this.col = col;
    }

    public boolean equals(PairBox o1){
        if(this == o1)
            return true;
        if(this.row == o1.row && this.col == o1.col)
            return true;
        return false;
    }
}
public class Solution {

	public void solveSudoku(ArrayList<ArrayList<Character>> toBeFilledSudoku) {

        HashMap<Integer,HashSet<Integer>> filledValuesByRow = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> filledValuesByCol = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> boxMap = new HashMap<>();
        prePopulate(toBeFilledSudoku,filledValuesByRow,filledValuesByCol,boxMap);
        fillSudoku(toBeFilledSudoku,0,9,filledValuesByRow,filledValuesByCol,boxMap);
        
	}

    public void fillSudoku(ArrayList<ArrayList<Character>> toBeFilledSudoku,int col,int size,
        HashMap<Integer,HashSet<Integer>> filledValuesByRow,HashMap<Integer,HashSet<Integer>> filledValuesByCol,
        HashMap<Integer,HashSet<Integer>> boxMap ){
        if(col == size)
        {
            return;
        }

        for(int row = 0;row<size;row++){
            if(toBeFilledSudoku.get(row).get(col).equals('.'))
            {
                
                BoxPair currentPair = new BoxPair(row/3,col/3);
                for(int value = 1;value<= 9;value++)
                {
                    if(filledValuesByRow.get(row).contains(value) || 
                    filledValuesByCol.get(col).contains(value) || 
                    boxMap.get(currentPair).contains(value)){
                        continue;
                    }
                    toBeFilledSudoku.get(row).set(col,value);
                    filledValuesByRow.put(row,filledValuesByRow.get(row)
                            .add(prePopulatedSudoku.get(row).get(col)));
                    filledValuesByCol.put(col,filledValuesByRow.get(col)
                        .add(prePopulatedSudoku.get(row).get(col)));
                    boxMap.put(currentPair,boxMap.get(currentPair)
                        .add(prePopulatedSudoku.get(row).get(col)));

                    fillSudoku(toBeFilledSudoku,col+1,size,filledValuesByRow,filledValuesByCol,boxMap);
                    
                    filledValuesByRow.put(row,filledValuesByRow.get(row)
                            .remove(prePopulatedSudoku.get(row).get(col)));
                    filledValuesByCol.put(col,filledValuesByRow.get(col)
                        .remove(prePopulatedSudoku.get(row).get(col)));
                    boxMap.put(currentPair,boxMap.get(currentPair)
                        .remove(prePopulatedSudoku.get(row).get(col)));
                    toBeFilledSudoku.get(row).set(col,'.');
                }
            }
        }

    }

    public void prePopulate(ArrayList<ArrayList<Character>> prePopulatedSudoku,HashMap<Integer> filledValuesByRow
    ,HashMap<Integer> filledValuesByCol,HashMap<Integer,HashSet<Integer>> boxMap){
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(!prePopulatedSudoku.get(i).get(j).equals('.')){
                    filledValuesByRow.put(i,filledValuesByRow.getOrDefault(i,new HashSet<>())
                        .add(prePopulatedSudoku.get(i).get(j)));
                    filledValuesByCol.put(j,filledValuesByRow.getOrDefault(j,new HashSet<>())
                        .add(prePopulatedSudoku.get(i).get(j)));
                    BoxPair boxkey = new BoxPair(i/3,j/3);

                    boxMap.put(boxKey,boxMap.getOrDefault(boxkey,new HashSet<Integer>())
                        .add(prePopulatedSudoku.get(i).get(j)));
                }
            }
        }
    }
}