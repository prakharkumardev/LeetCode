package ticTacToe.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@RequiredArgsConstructor
public abstract class Player {
    private GameSymbol gameSymbol;
    public abstract BoardCell play(Board board);

}
