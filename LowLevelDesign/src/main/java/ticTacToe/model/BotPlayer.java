package ticTacToe.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ticTacToe.strategy.PlayStrategy;

@Getter@Setter
@RequiredArgsConstructor
@SuperBuilder(toBuilder = true)
public class BotPlayer extends Player {

    private Level level;
    private final PlayStrategy playStrategy;
    @Override
    public BoardCell play(Board board) {
        return null;
    }
}
