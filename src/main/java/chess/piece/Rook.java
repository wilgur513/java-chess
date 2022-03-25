package chess.piece;

import chess.position.Position;

public class Rook extends Piece{

    public Rook(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected boolean isPossibleMovement(Position to) {
        return getPosition().isVerticalWay(to) || getPosition().isHorizontalWay(to);
    }

    @Override
    protected Piece createTransferredPiece(Position to) {
        return new Rook(getColor(), to);
    }
}
