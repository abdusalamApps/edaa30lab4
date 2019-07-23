package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {

    private Point p1;
    private Point p2;
    private Point p3;

    public Mountain(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public String getTitle() {
        return "Mountain Fractal";
    }

    @Override
    public void draw(TurtleGraphics turtle) {
        fractalTriangle(turtle, p1, p2, p3, order);
    }

    private void fractalTriangle(TurtleGraphics turtle, Point p1, Point p2, Point p3, int order) {
        if (order == 0) {
            turtle.moveTo(p1.getX(), p1.getY());
            turtle.penDown();
            turtle.forwardTo(p2.getX(), p2.getY());
            turtle.forwardTo(p3.getX(), p3.getY());
            turtle.forwardTo(p1.getX(), p1.getY());
            turtle.penUp();
        } else {
            fractalTriangle(turtle,
                    p1,
                    new Point((p1.getX() + p2.getX())/2, (p1.getY() + p2.getY())/2),
                    new Point((p1.getX() + p3.getX())/2, (p1.getY() + p3.getY())/2),
                    order - 1);
            fractalTriangle(turtle,
                    p2,
                    new Point((p1.getX() + p2.getX())/2, (p1.getY() + p2.getY())/2),
                    new Point((p2.getX() + p3.getX())/2, (p2.getY() + p3.getY())/2),
                    order - 1);
            fractalTriangle(turtle,
                    p3,
                    new Point((p1.getX() + p3.getX())/2, (p1.getY() + p3.getY())/2),
                    new Point((p2.getX() + p3.getX())/2, (p2.getY() + p3.getY())/2),
                    order - 1);
            fractalTriangle(turtle,
                    new Point((p1.getX() + p2.getX())/2, (p1.getY() + p2.getY())/2),
                    new Point((p1.getX() + p3.getX())/2, (p1.getY() + p3.getY())/2),
                    new Point((p2.getX() + p3.getX())/2, (p2.getY() + p3.getY())/2),
                    order - 1);


        }
    }
}
