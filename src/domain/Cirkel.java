package domain;

import java.awt.geom.Point2D;

public class Cirkel {
    private Point2D.Double middelpunt;
    private double straal;

    public Cirkel(Point2D.Double middelpunt, double straal) {
        if (middelpunt == null) throw new IllegalArgumentException();
        if (straal < 0 || straal >= middelpunt.getX() || straal >= middelpunt.getY()) throw new IllegalArgumentException();

        this.middelpunt = middelpunt;
        this.straal = straal;
    }

    public Point2D.Double getMiddelpunt() {
        return middelpunt;
    }

    public double getStraal() {
        return straal;
    }

    public double berekenOppervlakte() {
        return straal * straal * Math.PI;
    }

    public boolean isBinnenDeCirkel(Point2D.Double punt) {
        return ((punt.getX() - middelpunt.getX())*(punt.getX() - middelpunt.getX()) +
                (punt.getY() - middelpunt.getY())*(punt.getY() - middelpunt.getY()) < (straal*straal));
    }

    public void vergrootStraal(double factor) {
        if (factor < 0) throw new IllegalArgumentException();
        double nieuweStraal = straal * factor;
        if (nieuweStraal < 0 || nieuweStraal >= middelpunt.getX() || nieuweStraal >= middelpunt.getY()) throw new IllegalArgumentException();
        this.straal = nieuweStraal;
    }
}
