package ticTacToe.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
@Builder
public class User {

    private String name;
    private String email;
    private String image;
}
