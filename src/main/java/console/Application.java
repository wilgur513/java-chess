package console;

import static chess.position.File.*;
import static chess.position.Rank.*;

import chess.ChessBoard;
import chess.piece.*;
import chess.position.*;
import console.view.InputView;
import console.view.OutputView;
import java.util.*;

public class Application {

    private static final Map<String, Rank> RANKS = Map.of(
        "1", ONE, "2", TWO, "3", THREE, "4", FOUR, "5", FIVE, "6", SIX, "7", SEVEN, "8", EIGHT
    );
    private static final Map<String, File> FILES = Map.of(
        "a", A, "b", B, "c", C, "d", D, "e", E, "f", F, "g", G, "h", H
    );

    public static void main(String[] args) {
        OutputView.printInitChessGameMessage();
        String command = inputCommand();

        ChessBoard chessBoard = new ChessBoard(createPieces(), Color.WHITE);;
        boolean isStartGame = false;

        while (true) {
            if (command.equals("start")) {
                OutputView.printChessBoard(chessBoard.getPieces());
                isStartGame = true;
            }

            if (isStartGame && command.startsWith("move")) {
                try {
                    String[] commands = command.split(" ");
                    String from = commands[1];
                    String to = commands[2];
                    File fromFile = FILES.get(from.substring(0, 1));
                    Rank fromRank = RANKS.get(from.substring(1, 2));
                    File toFile = FILES.get(to.substring(0, 1));
                    Rank toRank = RANKS.get(to.substring(1, 2));
                    chessBoard.move(new Position(fromFile, fromRank), new Position(toFile, toRank));
                    OutputView.printChessBoard(chessBoard.getPieces());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (command.equals("end")) {
                return;
            }

            command = inputCommand();
        }
    }

    private static String inputCommand() {
        try {
            return InputView.inputCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCommand();
        }
    }

    private static List<Piece> createPieces() {
        return List.of(
            new Rook(Color.BLACK, new Position(A, EIGHT)),
            new Knight(Color.BLACK, new Position(B, EIGHT)),
            new Bishop(Color.BLACK, new Position(C, EIGHT)),
            new Queen(Color.BLACK, new Position(D, EIGHT)),
            new King(Color.BLACK, new Position(E, EIGHT)),
            new Bishop(Color.BLACK, new Position(F, EIGHT)),
            new Knight(Color.BLACK, new Position(G, EIGHT)),
            new Rook(Color.BLACK, new Position(H, EIGHT)),
            new Pawn(Color.BLACK, new Position(A, SEVEN)),
            new Pawn(Color.BLACK, new Position(B, SEVEN)),
            new Pawn(Color.BLACK, new Position(C, SEVEN)),
            new Pawn(Color.BLACK, new Position(D, SEVEN)),
            new Pawn(Color.BLACK, new Position(E, SEVEN)),
            new Pawn(Color.BLACK, new Position(F, SEVEN)),
            new Pawn(Color.BLACK, new Position(G, SEVEN)),
            new Pawn(Color.BLACK, new Position(H, SEVEN)),
            new Rook(Color.WHITE, new Position(A, ONE)),
            new Knight(Color.WHITE, new Position(B, ONE)),
            new Bishop(Color.WHITE, new Position(C, ONE)),
            new Queen(Color.WHITE, new Position(D, ONE)),
            new King(Color.WHITE, new Position(E, ONE)),
            new Bishop(Color.WHITE, new Position(F, ONE)),
            new Knight(Color.WHITE, new Position(G, ONE)),
            new Rook(Color.WHITE, new Position(H, ONE)),
            new Pawn(Color.WHITE, new Position(A, TWO)),
            new Pawn(Color.WHITE, new Position(B, TWO)),
            new Pawn(Color.WHITE, new Position(C, TWO)),
            new Pawn(Color.WHITE, new Position(D, TWO)),
            new Pawn(Color.WHITE, new Position(E, TWO)),
            new Pawn(Color.WHITE, new Position(F, TWO)),
            new Pawn(Color.WHITE, new Position(G, TWO)),
            new Pawn(Color.WHITE, new Position(H, TWO)));
    }
}
