package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Camera {
    private Point p0;
    private Vector vTo;
    private Vector vUp;
    private Vector vRight;

    private int distance;
    private int width;
    private int height;

    public Camera(Point p0, Vector vTo, Vector vUp) {
        if (!isZero(vTo.dotProduct(vUp))) {
            throw new IllegalArgumentException("vto  and vup are not orthogonal");
        }
        this.p0 = p0;

        this.vTo = vTo.normalize();
        this.vUp = vUp.normalize();

        vRight = this.vTo.crossProduct(this.vUp);
    }

    public Camera setVPDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public Camera setVPSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    // constructing a ray passing through pixel(i,j) of the view plane
    public Ray constructRay(int nX, int nY, int j, int i) {

        //view plane center Point
        Point Pc = p0.add(vTo.scale(distance));

        //pixels ratios
        double Rx = width / nX;
        double Ry = height / nY;

        //Pij point[i,j] in view-plane coordinates
        Point Pij = Pc;

        //delta values for moving on the view=plane
        double Xj = (j - (nX - 1) / 2d) * Rx;
        double Yi = -(i - (nY - 1) / 2d) * Ry;

        if (!isZero(Xj)) {
            Pij = Pij.add(vRight.scale(Xj));
        }
        if (!isZero(Yi)) {
            Pij = Pij.add(vUp.scale(Yi));
        }

        // vector from camera's eye in the direction of point(i,j) in the viewplane
        Vector Vij = p0.add(Pij);

        return new Ray(p0, Vij);

    }
}
