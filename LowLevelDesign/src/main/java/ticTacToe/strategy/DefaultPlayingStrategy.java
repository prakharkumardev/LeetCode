package ticTacToe.strategy;

import ticTacToe.model.Board;
import ticTacToe.model.BoardCell;

import java.util.List;

public class DefaultPlayingStrategy implements PlayStrategy{
    @Override
    public BoardCell move(Board board) {
        for(List<BoardCell> row : board.getBoardCells()){
            for(BoardCell cell : row){
                if(cell.getSymbol() == null){
                    return cell;
                }
            }
        }
        return null;
    }
}
