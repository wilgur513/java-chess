package chess.piece;

import static chess.piece.Color.WHITE;

import chess.position.Position;
import chess.position.Rank;

public class Pawn extends Piece {

    private static final Rank BLACK_PAWN_START_RANK = Rank.SEVEN;
    private static final Rank WHITE_PAWN_START_RANK = Rank.TWO;

    public Pawn(Color color, Position position) {
        super(color, position);
    }

    @Override
    protected boolean isPossibleMovement(Position to) {
        return isCapturablePosition(to) || isMovablePosition(to);
    }

    @Override
    public boolean isCapturablePosition(Position to) {
        return isForward(to) && getPosition().isDiagonalWay(to) && getPosition().getVerticalDistance(to) == 1;
    }

    private boolean isForward(Position to) {
        return getColor().isForward(getPosition(), to);
    }

    private boolean isMovablePosition(Position to) {
        return isForward(to) && getPosition().isVerticalWay(to) && isValidDistance(to);
    }

    private boolean isValidDistance(Position to) {
        return getPosition().getVerticalDistance(to) <= movableDistance();
    }

    private int movableDistance() {
        if (isStartPawnPosition()) {
            return 2;
        }
        return 1;
    }

    private boolean isStartPawnPosition() {
        if (getColor() == WHITE) {
            return getPosition().isSameRank(WHITE_PAWN_START_RANK);
        }
        return getPosition().isSameRank(BLACK_PAWN_START_RANK);
    }

    @Override
    protected Piece createTransferredPiece(Position to) {
        return new Pawn(getColor(), to);
    }
}
