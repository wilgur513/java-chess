package chess.position;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum File {

    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    private final int value;

    File(int value) {
        this.value = value;
    }

    public int getDistance(File other) {
        return Math.abs(this.value - other.value);
    }

    public static List<File> orderedValues() {
        return Arrays.stream(values())
            .sorted(Comparator.comparingInt(row -> row.value))
            .collect(Collectors.toList());
    }

    public List<File> getPath(File to) {
        int start = Math.min(this.value, to.value);
        int end = Math.max(this.value, to.value);

        return orderedValues().stream()
            .filter(file -> start < file.value && file.value < end)
            .collect(Collectors.toList());
    }
}
