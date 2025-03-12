package code.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col  = grid[0].length;
        Queue<Position> queue = new LinkedList<>();
        boolean isGoodOrange = false;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2) queue.add(new Position(i,j));
                if(grid[i][j] == 1) isGoodOrange = true;
            }
        }
        if(!isGoodOrange) return 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i = 0;i<size;i++){
                Position rottenOrange = queue.poll();
                //check top
                if(rottenOrange.getRow() > 0 && grid[rottenOrange.getRow()-1][rottenOrange.getCol()] == 1){
                    grid[rottenOrange.getRow()-1][rottenOrange.getCol()] = 2;
                    queue.add(new Position (rottenOrange.getRow()-1, rottenOrange.getCol()));
                }
                //check left
                if(rottenOrange.getCol() > 0 && grid[rottenOrange.getRow()][rottenOrange.getCol()-1] == 1){
                    grid[rottenOrange.getRow()][rottenOrange.getCol()-1] = 2;
                    queue.add(new Position (rottenOrange.getRow(), rottenOrange.getCol()-1));
                }
                //check right
                if(rottenOrange.getCol() < col-1 && grid[rottenOrange.getRow()][rottenOrange.getCol()+1] == 1){
                    grid[rottenOrange.getRow()][rottenOrange.getCol()+1] = 2;
                    queue.add(new Position (rottenOrange.getRow(), rottenOrange.getCol()+1));
                }
                //check down
                if(rottenOrange.getRow() < row-1 && grid[rottenOrange.getRow()+1][rottenOrange.getCol()] == 1){
                    grid[rottenOrange.getRow()+1][rottenOrange.getCol()] = 2;
                    queue.add(new Position (rottenOrange.getRow()+1, rottenOrange.getCol()));
                }
            }
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return count;

    }


}
