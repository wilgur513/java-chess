package chess.piece;

import chess.position.Position;

public class King extends Piece{

    public King(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected boolean isPossibleMovement(Position to) {
        return getPosition().isAdjacent(to);
    }

    @Override
    protected Piece createTransferredPiece(Position to) {
        return new King(getColor(), to);
    }
}
