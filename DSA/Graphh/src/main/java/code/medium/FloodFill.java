package code.medium;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Position> queue = new LinkedList<>();
        int pixel  = image[sr][sc];
        image[sr][sc] = color;
        queue.add(new Position(sr, sc));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Position position = queue.poll();
                //top
                if(position.getRow() > 0 && image[position.getRow()-1][position.getCol()] == pixel){
                    queue.add(new Position(position.getRow()-1, position.getCol()));
                    image[position.getRow()-1][position.getCol()] = color;
                }
                //bottom
                if(position.getRow() < image.length-1 && image[position.getRow()+1][position.getCol()] == pixel){
                    queue.add(new Position(position.getRow()+1, position.getCol()));
                    image[position.getRow()+1][position.getCol()] = color;
                }
                //left
                if(position.getCol() > 0 && image[position.getRow()][position.getCol()-1] == pixel){
                    queue.add(new Position(position.getRow(), position.getCol()-1));
                    image[position.getRow()][position.getCol()-1] = color;
                }
                //right
                if(position.getCol() < image[0].length-1 && image[position.getRow()][position.getCol()+1] == pixel){
                    queue.add(new Position(position.getRow(), position.getCol()+1));
                    image[position.getRow()][position.getCol()+1] = color;
                }
            }
        }

        return image;
    }
}
