package chess.piece;

import chess.position.Position;

public class Bishop extends Piece {

    public Bishop(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected boolean isPossibleMovement(Position to) {
        return getPosition().isDiagonalWay(to);
    }

    @Override
    protected Piece createTransferredPiece(Position to) {
        return new Bishop(getColor(), to);
    }
}
