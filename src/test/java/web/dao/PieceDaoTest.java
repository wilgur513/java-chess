package web.dao;

import static chess.position.File.*;
import static chess.position.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

import chess.piece.Color;
import chess.position.Position;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import web.dto.PieceDTO;
import web.dto.PieceType;

class PieceDaoTest {

    private PieceDao dao;

    @BeforeEach
    void setUp() {
        dao = new PieceDao(new JdbcTemplate());
        dao.deleteAll();
        dao.savePieces(List.of(
                new PieceDTO(new Position(A, EIGHT), PieceType.KING, Color.WHITE),
                new PieceDTO(new Position(A, SEVEN), PieceType.QUEEN, Color.WHITE),
                new PieceDTO(new Position(B, EIGHT), PieceType.PAWN, Color.WHITE),
                new PieceDTO(new Position(C, EIGHT), PieceType.BISHOP, Color.WHITE),
                new PieceDTO(new Position(D, EIGHT), PieceType.KING, Color.BLACK),
                new PieceDTO(new Position(D, SEVEN), PieceType.KNIGHT, Color.BLACK),
                new PieceDTO(new Position(D, SIX), PieceType.PAWN, Color.BLACK)
        ));
    }

    @AfterEach
    void tearDown() {
        dao.deleteAll();
    }

    @Test
    void findPieces() {
        assertThat(dao.findPieces()).containsExactlyInAnyOrder(
                new PieceDTO(new Position(A, EIGHT), PieceType.KING, Color.WHITE),
                new PieceDTO(new Position(A, SEVEN), PieceType.QUEEN, Color.WHITE),
                new PieceDTO(new Position(B, EIGHT), PieceType.PAWN, Color.WHITE),
                new PieceDTO(new Position(C, EIGHT), PieceType.BISHOP, Color.WHITE),
                new PieceDTO(new Position(D, EIGHT), PieceType.KING, Color.BLACK),
                new PieceDTO(new Position(D, SEVEN), PieceType.KNIGHT, Color.BLACK),
                new PieceDTO(new Position(D, SIX), PieceType.PAWN, Color.BLACK)
        );
    }

    @Test
    void deletePieceByPosition() {
        dao.deletePieceByPosition(new Position(A, SEVEN));
        dao.deletePieceByPosition(new Position(D, SIX));
        assertThat(dao.findPieces()).containsExactlyInAnyOrder(
                new PieceDTO(new Position(A, EIGHT), PieceType.KING, Color.WHITE),
                new PieceDTO(new Position(B, EIGHT), PieceType.PAWN, Color.WHITE),
                new PieceDTO(new Position(C, EIGHT), PieceType.BISHOP, Color.WHITE),
                new PieceDTO(new Position(D, EIGHT), PieceType.KING, Color.BLACK),
                new PieceDTO(new Position(D, SEVEN), PieceType.KNIGHT, Color.BLACK)
        );
    }
}