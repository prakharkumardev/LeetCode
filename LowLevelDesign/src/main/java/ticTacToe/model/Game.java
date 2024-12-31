package ticTacToe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Game {

    private Board board;
    private List<Player> players;;

    public void startGame(int boardSize) {
        board = new Board(boardSize);
        players = new ArrayList<>();
    }
    public void makeMove(Player player, int row, int column) {
        BoardCell boardCell = board.getBoardCells().get(row).get(column);
        boardCell.setSymbol(player.getGameSymbol());
    }
    public void registerPlayer(Player player, GameSymbol gameSymbol){
        player.setGameSymbol(gameSymbol);
        players.add(player);
        System.out.println("Player registered with symbol " + gameSymbol);

    }


}
