package pdd;

public class RobitRange {
    public int movingCount(int threshold, int rows, int cols){
        if (threshold<0||rows<=0||cols<0) return 0;
        boolean[][] visited  = new boolean[rows][cols];
        int count = movingCountRecur(threshold,rows,cols,0,0,visited);
        return count;
    }
    private int movingCountRecur(int threshold, int rows, int cols, int row, int col, boolean[][] isVisited){
        if (row < 0|| col < 0||row>rows||col>cols||isVisited[row][col]||cal(row)+cal(col)>threshold) return 0;
        isVisited[row][col] = true;
        return 1 + movingCountRecur(threshold,rows,cols,row-1,col,isVisited)+
                movingCountRecur(threshold,rows,cols,row+1,col,isVisited)+
                movingCountRecur(threshold,rows,cols,row,col-1,isVisited)+
                movingCountRecur(threshold,rows,cols,row,col+1,isVisited);
    }

    private int cal(int num){
        int sum = 0;
        while (num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

}



