package chess.piece;

import chess.position.Position;

public class Queen extends Piece {

    public Queen(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected boolean isPossibleMovement(Position to) {
        return getPosition().isDiagonalWay(to) || getPosition().isVerticalWay(to)
            || getPosition().isHorizontalWay(to);
    }

    @Override
    protected Piece createTransferredPiece(Position to) {
        return new Queen(getColor(), to);
    }
}
