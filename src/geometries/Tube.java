package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Tube implements Geometry {
    protected Ray _axisRay;
    protected double _radius;

    /**
     * Constructor to initialize Double3 based object with its ray and number
     *
     * @param axisRay first number value
     * @param radius second number value
     */
    public Tube(double radius,Ray axisRay){
      this._axisRay = axisRay;
      this._radius = radius;
    }

    @Override
    public Vector getNormal(Point temp){
        double t = _axisRay.getVec().dotProduct(temp.subtract(_axisRay.getPoint()));
        Point o = _axisRay.getPoint().add(_axisRay.getVec().scale(t));
        return temp.subtract(o).normalize();
    }

    public Ray getAxisRay() {
        return _axisRay;
    }

    public double getRadius() {
        return _radius;
    }

    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + _axisRay +
                ", radius=" + _radius +
                '}';
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        Vector vAxis = _axisRay.getVec();
        Vector v = ray.getVec();
        Point p0 = ray.getPoint();

        // At^2+Bt+C=0
        double a = 0;
        double b = 0;
        double c = 0;

        double vVa = alignZero(v.dotProduct(vAxis));
        Vector vVaVa;
        Vector vMinusVVaVa;
        if (vVa == 0) // the ray is orthogonal to the axis
            vMinusVVaVa = v;
        else {
            vVaVa = vAxis.scale(vVa);
            try {
                vMinusVVaVa = v.subtract(vVaVa);
            } catch (IllegalArgumentException e1) { // the rays is parallel to axis
                return null;
            }
        }
        // A = (v-(v*va)*va)^2
        a = vMinusVVaVa.lengthSquared();

        Vector deltaP = null;
        try {
            deltaP = p0.subtract(_axisRay.getPoint());
        } catch (IllegalArgumentException e1) { // the ray begins at axis P0
            if (vVa == 0) // the ray is orthogonal to Axis
                return List.of(ray.getPoint(_radius));

            double t = alignZero(Math.sqrt(_radius * _radius / vMinusVVaVa.lengthSquared()));
            return t == 0 ? null : List.of(ray.getPoint(t));
        }

        double dPVAxis = alignZero(deltaP.dotProduct(vAxis));
        Vector dPVaVa;
        Vector dPMinusdPVaVa;
        if (dPVAxis == 0)
            dPMinusdPVaVa = deltaP;
        else {
            dPVaVa = vAxis.scale(dPVAxis);
            try {
                dPMinusdPVaVa = deltaP.subtract(dPVaVa);
            } catch (IllegalArgumentException e1) {
                double t = alignZero(Math.sqrt(_radius * _radius / a));
                return t == 0 ? null : List.of(ray.getPoint(t));
            }
        }

        // B = 2(v - (v*va)*va) * (dp - (dp*va)*va))
        b = 2 * alignZero(vMinusVVaVa.dotProduct(dPMinusdPVaVa));
        c = dPMinusdPVaVa.lengthSquared() - _radius * _radius;

        // A*t^2 + B*t + C = 0 - lets resolve it
        double discr = alignZero(b * b - 4 * a * c);
        if (discr <= 0) return null; // the ray is outside or tangent to the tube

        double doubleA = 2 * a;
        double tm = alignZero(-b / doubleA);
        double th = Math.sqrt(discr) / doubleA;
        if (isZero(th)) return null; // the ray is tangent to the tube

        double t1 = alignZero(tm + th);
        if (t1 <= 0) // t1 is behind the head
            return null; // since th must be positive (sqrt), t2 must be non-positive as t1

        double t2 = alignZero(tm - th);

        // if both t1 and t2 are positive
        if (t2 > 0)
            return List.of(ray.getPoint(t1), ray.getPoint(t2));
        else // t2 is behind the head
            return List.of(ray.getPoint(t1));
    }
}
