import java.util.*;

/**
 * Created by junior on 7/01/17.
 */
public class Sudoku {

    final int ROWS = 9, COLUMNS = 9;
    HashSet<Point> set1 = new HashSet<Point>();
    HashSet<Point> set2 = new HashSet<Point>();
    HashSet<Point> set3 = new HashSet<Point>();
    HashSet<Point> set4 = new HashSet<Point>();
    HashSet<Point> set5 = new HashSet<Point>();
    HashSet<Point> set6 = new HashSet<Point>();
    HashSet<Point> set7 = new HashSet<Point>();
    HashSet<Point> set8 = new HashSet<Point>();
    HashSet<Point> set9 = new HashSet<Point>();

    private Object[][] sudoku = {
            {8, 4, 1, 0, 0, 0, 0, 0, 0},
            {7, 0, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 5, 0, 0, 0, 0, 0, 0},
            {0, 0, 8, 6, 0, 2, 3, 7, 0},
            {0, 5, 0, 9, 0, 0, 0, 1, 0},
            {2, 0, 7, 0, 0, 3, 9, 0, 8},
            {5, 8, 9, 0, 0, 7, 1, 0, 0},
            {0, 2, 0, 1, 5, 0, 6, 8, 7},
            {1, 7, 6, 3, 8, 4, 2, 5, 9}
    };

    private Object[][] sudoku7 = {
            {6, 3, 2, 1, 0, 0, 9, 7, 0},
            {8, 0, 0, 0, 0, 3, 4, 1, 0},
            {4, 0, 1, 2, 0, 0, 3, 6, 0},
            {0, 0, 0, 0, 7, 9, 0, 5, 6},
            {0, 0, 0, 0, 0, 0, 0, 4, 3},
            {0, 0, 0, 5, 2, 0, 1, 8, 9},
            {0, 0, 0, 0, 1, 6, 0, 3, 4},
            {0, 0, 0, 0, 0, 0, 0, 9, 1},
            {0, 0, 0, 9, 5, 0, 6, 2, 7}
    };

    private Object[][] sudoku6 = {
            {6, 5, 0, 0, 0, 8, 6, 0, 0},
            {8, 9, 0, 0, 5, 0, 7, 8, 3},
            {4, 0, 7, 3, 6, 0, 0, 0, 5},
            {7, 0, 6, 0, 2, 0, 0, 0, 0},
            {0, 0, 9, 0, 0, 0, 1, 0, 6},
            {0, 0, 0, 0, 8, 0, 4, 0, 7},
            {9, 0, 0, 0, 3, 6, 5, 0, 0},
            {4, 0, 0, 0, 9, 0, 0, 6, 0},
            {0, 6, 8, 2, 1, 0, 9, 7, 0}
    };

    private Object[][] sudoku5 = {
            {3, 5, 6, 2, 9, 4, 7, 8, 1},
            {0, 2, 0, 6, 8, 1, 3, 9, 5},
            {9, 0, 0, 5, 7, 3, 6, 4, 2},
            {0, 0, 2, 0, 0, 0, 0, 3, 0},
            {7, 0, 0, 3, 2, 0, 0, 0, 9},
            {0, 3, 0, 0, 0, 0, 2, 7, 0},
            {0, 6, 0, 7, 4, 9, 0, 0, 3},
            {0, 0, 3, 1, 6, 5, 9, 2, 0},
            {5, 9, 0, 8, 3, 2, 0, 0, 7}
    };

    private Object[][] sudoku4 = {
            {9, 0, 0, 1, 4, 8, 0, 0, 7},
            {7, 0, 4, 0, 6, 2, 1, 9, 8},
            {1, 0, 8, 0, 7, 9, 4, 6, 0},
            {5, 8, 7, 4, 2, 6, 9, 0, 1},
            {4, 0, 0, 9, 3, 1, 8, 7, 0},
            {3, 1, 9, 7, 8, 5, 2, 4, 6},
            {6, 4, 0, 0, 1, 7, 0, 8, 9},
            {2, 7, 1, 8, 9, 3, 0, 0, 4},
            {8, 9, 0, 0, 5, 4, 7, 1, 0}
    };

    private Object[][] sudokuAux = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    private Object[][] sudoku2 = {
            {0, 0, 0, 0, 4, 7, 0, 0, 0},
            {0, 0, 0, 5, 0, 0, 7, 0, 4},
            {8, 0, 0, 0, 9, 0, 0, 0, 2},
            {0, 8, 0, 4, 0, 0, 6, 5, 0},
            {7, 0, 0, 8, 0, 2, 0, 0, 9},
            {0, 4, 5, 0, 0, 1, 0, 3, 0},
            {3, 0, 0, 0, 1, 0, 0, 0, 6},
            {2, 0, 1, 0, 0, 4, 0, 0, 0},
            {0, 0, 0, 6, 8, 0, 0, 0, 0}
    };

    private Object[][] sudoku3 = {
            {5, 0, 0, 0, 4, 7, 0, 0, 0},
            {0, 0, 0, 5, 2, 8, 7, 0, 4},
            {8, 0, 4, 0, 9, 0, 0, 0, 2},
            {0, 8, 2, 4, 0, 0, 6, 5, 0},
            {7, 0, 0, 8, 5, 2, 0, 0, 9},
            {0, 4, 5, 0, 6, 1, 0, 3, 0},
            {3, 0, 8, 2, 1, 0, 0, 0, 6},
            {2, 0, 1, 0, 0, 4, 0, 0, 0},
            {4, 0, 0, 6, 8, 0, 0, 0, 0}
    };



    public void run() {
        createSets();

        showSudoku();
        initDefaultValues();
        //showSudoku();

        cleanSudoku();

        showSudoku();

        reInit();

        //showSudoku();

        // Segunda iteracion

        initDefaultValues();
        //showSudoku();

        cleanSudoku();

        showSudoku();

        reInit();

        //showSudoku();

        for (int itera = 0; itera < 20; itera++) {
            initDefaultValues();
            cleanSudoku();
            showSudoku();
            reInit();
        }

        //recorreRows();
        //showSudoku();
    }


    private void showSudoku() {
        System.out.println("Star showSudoku ");
        System.out.println("*************************************************************************************" +
                "************************************************************************************************");

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                //System.out.print(sudoku[row][column] + "\t\t\t\t\t");
                System.out.format("%20s", sudoku[row][column]);
            }
            System.out.println("\n");
        }

        System.out.println("*************************************************************************************" +
                "************************************************************************************************");
        System.out.println("Finish showSudoku ");
    }

    private void initDefaultValues() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (sudoku[row][column].equals(0)) {
                    List<Integer> listaDefault = new ArrayList<Integer>();

                    for (int i = 1; i <= ROWS; i++)
                        listaDefault.add(i);

                    sudoku[row][column] = listaDefault;
                }
            }
        }
    }

    private void cleanSudoku() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (sudoku[row][column] instanceof ArrayList) {
                    ArrayList<Integer> elementosNodo = (ArrayList<Integer>) sudoku[row][column];

                    HashSet<Integer> elementosHV = new HashSet<Integer>();

                    for (int c = 0; c < COLUMNS; c++)
                        if (sudoku[row][c] instanceof Integer)
                            elementosHV.add((Integer) sudoku[row][c]);

                    for (int r = 0; r < ROWS; r++)
                        if (sudoku[r][column] instanceof Integer)
                            elementosHV.add((Integer) sudoku[r][column]);

                    //System.out.println("elementosHV: " + elementosHV + "\t\t\t");

                    elementosNodo.removeAll(elementosHV);

                    //System.out.println("elementosNodo: " + elementosNodo + "\t\t\t");

                    sudoku[row][column] = elementosNodo;

                    //remover de los sets

                    Point p = new Point(row, column);

                    HashSet<Integer> elementosSet = new HashSet<Integer>();
                    if (set1.contains(p)) {
                        for (Point point : set1) {
                            if (sudoku[point.getX()][point.getY()] instanceof Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    } else if (set2.contains(p)) {
                        for (Point point : set2) {
                            if (sudoku[point.getX()][point.getY()] instanceof Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    } else if (set3.contains(p)) {
                        for (Point point : set3) {
                            if (sudoku[point.getX()][point.getY()] instanceof Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    } else if (set4.contains(p)) {
                        for (Point point : set4) {
                            if (sudoku[point.getX()][point.getY()] instanceof Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    } else if (set5.contains(p)) {
                        for (Point point : set5) {
                            if (sudoku[point.getX()][point.getY()] instanceof Integer) {
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                            }
                        }
                    } else if (set6.contains(p)) {
                        for (Point point : set6) {
                            if (sudoku[point.getX()][point.getY()] instanceof Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    } else if (set7.contains(p)) {
                        for (Point point : set7) {
                            if (sudoku[point.getX()][point.getY()] instanceof Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    } else if (set8.contains(p)) {
                        for (Point point : set8) {
                            if (sudoku[point.getX()][point.getY()] instanceof Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    } else if (set9.contains(p)) {
                        for (Point point : set9) {
                            if (sudoku[point.getX()][point.getY()] instanceof Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    }

                    elementosNodo.removeAll(elementosSet);

                    //System.out.println("elementosNodo luego del Set: " + elementosNodo + "\t\t\t");

                    sudoku[row][column] = elementosNodo;

                }
            }
        }
    }

    private void recorreRows() {
        for (int row = 0; row < ROWS; row++) {

            Map<Integer, Point> candidatos = new HashMap<Integer, Point>();

            for (int column = 0; column < COLUMNS; column++) {
                if (sudoku[row][column] instanceof ArrayList) {
                    ArrayList<Integer> elementosNodo = (ArrayList<Integer>) sudoku[row][column];

                    for (Integer e: elementosNodo) {
                        if (candidatos.containsKey(e)) {
                            candidatos.put(e, new Point(candidatos.get(e).getX()+1, column));
                        } else {
                            candidatos.put(e, new Point(1, column));
                        }
                    }
                }
            }

            for (Map.Entry<Integer, Point> entry : candidatos.entrySet()) {
                if (entry.getValue().getX() > 1){
                    candidatos.remove(entry.getKey());
                }
            }

            if(!candidatos.isEmpty()){
                for (Map.Entry<Integer, Point> entry : candidatos.entrySet()) {
                    sudoku[row][entry.getValue().getY()] = entry.getValue().getX();
                }
            }
        }
    }

    private void reInit() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (sudoku[row][column] instanceof ArrayList) {
                    ArrayList<Integer> elementosNodo = (ArrayList<Integer>) sudoku[row][column];
                    if (elementosNodo.size() == 1) {
                        sudoku[row][column] = elementosNodo.get(0);
                    } else {
                        sudoku[row][column] = 0;
                    }
                }
            }
        }
    }

    private void createSets() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                set1.add(new Point(i, j));

            for (int j = 3; j < 6; j++)
                set2.add(new Point(i, j));

            for (int j = 6; j < 9; j++)
                set3.add(new Point(i, j));
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++)
                set4.add(new Point(i, j));

            for (int j = 3; j < 6; j++)
                set5.add(new Point(i, j));

            for (int j = 6; j < 9; j++)
                set6.add(new Point(i, j));
        }

        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++)
                set7.add(new Point(i, j));

            for (int j = 3; j < 6; j++)
                set8.add(new Point(i, j));

            for (int j = 6; j < 9; j++)
                set9.add(new Point(i, j));
        }
    }
}
