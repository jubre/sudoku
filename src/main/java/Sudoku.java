import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
            {0, 1, 8, 0, 0, 0, 7, 0, 2},
            {0, 6, 2, 1, 5, 0, 0, 0, 8},
            {0, 3, 4, 8, 2, 0, 0, 0, 9},
            {2, 7, 3, 9, 0, 1, 0, 8, 0},
            {6, 8, 5, 0, 7, 2, 0, 0, 0},
            {1, 4, 9, 0, 8, 5, 2, 7, 0},
            {3, 9, 6, 5, 1, 8, 4, 2, 7},
            {8, 2, 1, 7, 6, 4, 0, 0, 0},
            {4, 5, 7, 2, 0, 0, 8, 6, 1}
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

        for(int itera=0;itera<20;itera++){
            initDefaultValues();
            cleanSudoku();
            showSudoku();
            reInit();
        }

        //recorreRows();

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

                    Point p = new Point(row,column);

                    HashSet<Integer> elementosSet = new HashSet<Integer>();
                    if(set1.contains(p)){
                        for(Point point:set1){
                            if(sudoku[point.getX()][point.getY()] instanceof  Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    }else if(set2.contains(p)){
                        for(Point point:set2){
                            if(sudoku[point.getX()][point.getY()] instanceof  Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    }else if(set3.contains(p)){
                        for(Point point:set3){
                            if(sudoku[point.getX()][point.getY()] instanceof  Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    }else if(set4.contains(p)){
                        for(Point point:set4){
                            if(sudoku[point.getX()][point.getY()] instanceof  Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    }else if(set5.contains(p)){
                        for(Point point:set5){
                            if(sudoku[point.getX()][point.getY()] instanceof  Integer){
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);}
                        }
                    }else if(set6.contains(p)){
                        for(Point point:set6){
                            if(sudoku[point.getX()][point.getY()] instanceof  Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    }else if(set7.contains(p)){
                        for(Point point:set7){
                            if(sudoku[point.getX()][point.getY()] instanceof  Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    }else if(set8.contains(p)){
                        for(Point point:set8){
                            if(sudoku[point.getX()][point.getY()] instanceof  Integer)
                                elementosSet.add((Integer) sudoku[point.getX()][point.getY()]);
                        }
                    }else if(set9.contains(p)){
                        for(Point point:set9){
                            if(sudoku[point.getX()][point.getY()] instanceof  Integer)
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
            for (int column = 0; column < COLUMNS; column++) {
                if (sudoku[row][column] instanceof ArrayList) {
                    ArrayList<Integer> elementosNodo = (ArrayList<Integer>) sudoku[row][column];
                    if(elementosNodo.size() == 1){
                        sudoku[row][column] = elementosNodo.get(0);
                    }else{
                        sudoku[row][column] = 0;
                    }
                }
            }
        }
    }

    private void reInit(){
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (sudoku[row][column] instanceof ArrayList) {
                    ArrayList<Integer> elementosNodo = (ArrayList<Integer>) sudoku[row][column];
                    if(elementosNodo.size() == 1){
                        sudoku[row][column] = elementosNodo.get(0);
                    }else{
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
        System.out.println("set 5:" + set5);
    }
}
