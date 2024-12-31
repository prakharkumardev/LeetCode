package ticTacToe.controller;

import ticTacToe.model.*;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Please select the game mode:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");

        // Read the input from the user
        // Based on the input, start the game
        User user1 = User.builder().name("Prakhar").email("prakhar@mail.com").build();
        Player player1 = HumanPlayer.builder().user(user1).build();
        Player player2 = BotPlayer.builder().level(Level.EASY).build();

        Game game = new Game();
        game.startGame(3);
        game.registerPlayer(player1, GameSymbol.X);
        game.registerPlayer(player2, GameSymbol.O);
        //print board
        System.out.println(game.getBoard().toString());

        //player 1 start the game
        game.makeMove(player1, 0, 0);







    }

}
