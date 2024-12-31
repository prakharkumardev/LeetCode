package ticTacToe.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class BoardCell {

    private int row;
    private int column;
    private GameSymbol symbol;


}
