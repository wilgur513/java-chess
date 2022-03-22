package chess;

import static chess.Col.*;
import static chess.Piece.*;
import static chess.Row.*;

import java.util.List;

public class ChessBoard {

    public List<Piece> getPieces() {
        return List.of(
            rook(Color.BLACK, new Position(A, EIGHT)),
            knight(Color.BLACK, new Position(B, EIGHT)),
            bishop(Color.BLACK, new Position(C, EIGHT)),
            queen(Color.BLACK, new Position(D, EIGHT)),
            king(Color.BLACK, new Position(E, EIGHT)),
            bishop(Color.BLACK, new Position(F, EIGHT)),
            knight(Color.BLACK, new Position(G, EIGHT)),
            rook(Color.BLACK, new Position(H, EIGHT)),
            pawn(Color.BLACK, new Position(A, SEVEN)),
            pawn(Color.BLACK, new Position(B, SEVEN)),
            pawn(Color.BLACK, new Position(C, SEVEN)),
            pawn(Color.BLACK, new Position(D, SEVEN)),
            pawn(Color.BLACK, new Position(E, SEVEN)),
            pawn(Color.BLACK, new Position(F, SEVEN)),
            pawn(Color.BLACK, new Position(G, SEVEN)),
            pawn(Color.BLACK, new Position(H, SEVEN)),
            rook(Color.WHITE, new Position(A, ONE)),
            knight(Color.WHITE, new Position(B, ONE)),
            bishop(Color.WHITE, new Position(C, ONE)),
            queen(Color.WHITE, new Position(D, ONE)),
            king(Color.WHITE, new Position(E, ONE)),
            bishop(Color.WHITE, new Position(F, ONE)),
            knight(Color.WHITE, new Position(G, ONE)),
            rook(Color.WHITE, new Position(H, ONE)),
            pawn(Color.WHITE, new Position(A, TWO)),
            pawn(Color.WHITE, new Position(B, TWO)),
            pawn(Color.WHITE, new Position(C, TWO)),
            pawn(Color.WHITE, new Position(D, TWO)),
            pawn(Color.WHITE, new Position(E, TWO)),
            pawn(Color.WHITE, new Position(F, TWO)),
            pawn(Color.WHITE, new Position(G, TWO)),
            pawn(Color.WHITE, new Position(H, TWO)));
    }
}
