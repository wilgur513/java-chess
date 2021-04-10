package chess.domain.piece;

import chess.domain.ChessBoard;
import chess.domain.pieceinformations.TeamColor;
import chess.domain.position.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {

    private Map<Position, Piece> board;

    @BeforeEach
    void setUp() {
        board = new ChessBoard().getChessBoard();
    }

    @Test
    @DisplayName("객체 생성")
    void create() {
        assertThatCode(() -> new Knight(TeamColor.BLACK)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("블랙팀 객체 이름출력")
    void ValidBlackKnightName() {
        Piece knight = new Knight(TeamColor.BLACK);
        assertThat(knight.getPieceName()).isEqualTo("N");
    }

    @Test
    @DisplayName("화이트팀 객체 이름출력")
    void ValidWhiteKnightName() {
        Piece knight = new Knight(TeamColor.WHITE);
        assertThat(knight.getPieceName()).isEqualTo("n");
    }

    @Test
    @DisplayName("이동이 가능한 경우 - 상대 말 잡기 포함")
    void movable() {
        Piece piece = new Knight(TeamColor.WHITE);

        assertTrue(piece.isMovable(Position.valueOf("d5"), Position.valueOf("e7"), board));
        assertTrue(piece.isMovable(Position.valueOf("d5"), Position.valueOf("f6"), board));
        assertTrue(piece.isMovable(Position.valueOf("d5"), Position.valueOf("f4"), board));
        assertTrue(piece.isMovable(Position.valueOf("d5"), Position.valueOf("e3"), board));
        assertTrue(piece.isMovable(Position.valueOf("d5"), Position.valueOf("c3"), board));
        assertTrue(piece.isMovable(Position.valueOf("d5"), Position.valueOf("b4"), board));
        assertTrue(piece.isMovable(Position.valueOf("d5"), Position.valueOf("b6"), board));
        assertTrue(piece.isMovable(Position.valueOf("d5"), Position.valueOf("c7"), board));
    }

    @Test
    @DisplayName("이동 불가능한 경우 - 영역범위 초과 및 target에 같은팀 포함")
    void fail_same_team() {
        Piece piece = new Knight(TeamColor.BLACK);

        assertFalse(piece.isMovable(Position.valueOf("b4"), Position.valueOf("d2"), board));
        assertFalse(piece.isMovable(Position.valueOf("b4"), Position.valueOf("c3"), board));
        assertFalse(piece.isMovable(Position.valueOf("b4"), Position.valueOf("b6"), board));
        assertFalse(piece.isMovable(Position.valueOf("b4"), Position.valueOf("f6"), board));
        assertFalse(piece.isMovable(Position.valueOf("b4"), Position.valueOf("e7"), board));
    }

}
