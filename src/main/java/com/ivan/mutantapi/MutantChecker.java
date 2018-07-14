package com.ivan.mutantapi;

public class MutantChecker {
    private int[] dx = {-1, 0, 1, 1};
    private int[] dy = {1, 1, 1, 0};
    private final int DIR_QUANTITY = 4;
    private final int SIZE_NEEDED = 4;
    private static MutantChecker mutantChecker = null;

    public static MutantChecker getInstance() {
        if (mutantChecker == null) {
            mutantChecker = new MutantChecker();
        }
        return mutantChecker;
    }

    public boolean isMutant(String[] dna) {
        int n = dna.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int dir = 0; dir < DIR_QUANTITY; dir++) {
                    if (check(dna, n, i, j, dir)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(String[] dna, int n, int sx, int sy, int dir) {
        for (int i = 0; i < SIZE_NEEDED; i++) {
            int nx = sx + i * dx[dir];
            int ny = sy + i * dy[dir];
            if (!isInside(nx, ny, n, n) || dna[nx].charAt(ny) != dna[sx].charAt(ny)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInside(int x, int y, int rows, int cols) {
        return 0 <= x && x < rows && 0 <= y && y < cols;
    }
}

