package chess.piece;

import chess.position.Position;
import java.util.Objects;

public abstract class Piece {

    private final Color color;
    private final Position position;

    public Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    public Piece transfer(Position to) {
        if (getPosition().equals(to)) {
            throw new IllegalArgumentException("동일한 위치로 기물을 이동시킬 수 없습니다.");
        }

        if (!isPossibleMovement(to)) {
            throw new IllegalArgumentException(String.format(
                "%s 기물을 %s에서 %s로 이동할 수 없습니다.", getClass().getSimpleName(), position, to));
        }

        return createTransferredPiece(to);
    }

    public boolean isCapturablePosition(Position to) {
        return isPossibleMovement(to);
    }

    public boolean isSameColor(Color color) {
        return this.color == color;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Piece piece = (Piece) o;
        return color == piece.color && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, position);
    }

    protected abstract Piece createTransferredPiece(Position to);

    protected abstract boolean isPossibleMovement(Position to);
}
