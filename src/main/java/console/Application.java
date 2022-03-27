package console;

import static chess.position.File.*;
import static chess.position.File.H;
import static chess.position.Rank.*;
import static chess.position.Rank.TWO;

import chess.ChessBoard;
import chess.piece.*;
import chess.position.Position;
import console.command.Command;
import console.command.EndCommand;
import console.view.*;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printInitChessGameMessage();
        boolean isStartGame = inputIsStartGame();

        if (isStartGame) {
            ChessBoard chessBoard = createChessBoard();
            OutputView.printChessBoard(chessBoard.getPieces());
            executeChessGame(chessBoard);
        }
    }

    private static boolean inputIsStartGame() {
        try {
            return InputView.inputIsStartGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputIsStartGame();
        }
    }

    private static ChessBoard createChessBoard() {
        return new ChessBoard(createPieces(), Color.WHITE);
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

    private static void executeChessGame(ChessBoard chessBoard) {
        Command command = inputCommand();

        while (command.isRunning()) {
            chessBoard = executeCommand(chessBoard, command);
            command = inputNextCommand(chessBoard, command);
        }

        if (chessBoard.isFinished()) {
            OutputView.printWinner(chessBoard.getWinner());
        }
    }

    private static Command inputCommand() {
        try {
            return InputView.inputCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCommand();
        }
    }

    private static ChessBoard executeCommand(ChessBoard chessBoard, Command command) {
        try {
            return command.execute(chessBoard);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return chessBoard;
        }
    }

    private static Command inputNextCommand(ChessBoard chessBoard, Command command) {
        if (!chessBoard.isFinished()) {
            return inputCommand();
        }
        return new EndCommand();
    }
}
