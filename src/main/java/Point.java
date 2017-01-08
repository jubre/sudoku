/**
 * Created by junior on 7/01/17.
 */
public class Point {
    //coordenadas
    private int x = 0;
    private int y = 0;

    /**
     * Constructor de la clase
     * @param x Define las coordenadas horizontales del area de trabajo.
     * @param y Define las coordenadas verticales del area de trabajo.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }//Fin del Constructor

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Point pp = (Point) obj;
        if(pp.getX() == this.x && pp.getY() == this.y)
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        return (1000*x + y);
    }
}
