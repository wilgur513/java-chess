package chess.piece;

import chess.position.Position;
import java.math.BigDecimal;

public class Queen extends Piece {

    public Queen(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected Piece createNewPiece(Position to) {
        return new Queen(getColor(), to);
    }

    @Override
    protected boolean isPossibleMovement(Position to) {
        return getPosition().isDiagonalWay(to) || getPosition().isVerticalWay(to)
                || getPosition().isHorizontalWay(to);
    }

    @Override
    public BigDecimal getPoint() {
        return new BigDecimal("9");
    }
}
