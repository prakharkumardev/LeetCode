package ticTacToe.strategy;

import ticTacToe.model.Board;
import ticTacToe.model.BoardCell;

public interface PlayStrategy {

    public BoardCell move(Board board);
}
