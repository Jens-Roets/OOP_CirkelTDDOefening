package domain;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CirkelTest {

    private Point2D.Double geldigMiddelpunt;
    private double geldigeStraal;
    private final double delta = 1E-10;
    private Cirkel cirkel;
    private Point2D.Double puntBinnen, puntBuiten;

    @org.junit.Before
    public void setUp() throws Exception {
        geldigeStraal = 2;
        geldigMiddelpunt = new Point2D.Double(5, 4);
        cirkel = new Cirkel(geldigMiddelpunt, geldigeStraal);
        puntBinnen = new Point2D.Double(4,3);
        puntBuiten = new Point2D.Double(12,250);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Middelpunt_is_leeg_maar_geldige_straal_gooit_Exception() {
        new Cirkel(null, geldigeStraal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Straal_is_net_kleiner_dan_nul_maar_geldig_middelpunt_gooit_Exception() {
        new Cirkel(geldigMiddelpunt, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Straal_is_veel_kleiner_dan_nul_maar_geldig_middelpunt_gooit_Exception() {
        new Cirkel(geldigMiddelpunt, -300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Straal_is_net_gelijk_aan_waarde_X_van_middelpunt_maar_geldig_middelpunt_gooit_Exception() {
        new Cirkel(geldigMiddelpunt, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Straal_is_net_groter_dan_waarde_X_van_middelpunt_maar_geldig_middelpunt_gooit_Exception() {
        new Cirkel(geldigMiddelpunt, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Straal_is_veel_groter_dan_waarde_X_van_middelpunt_maar_geldig_middelpunt_gooit_Exception() {
        new Cirkel(geldigMiddelpunt, 600);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Straal_is_net_gelijk_aan_waarde_Y_van_middelpunt_maar_geldig_middelpunt_gooit_Exception() {
        new Cirkel(geldigMiddelpunt, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Straal_is_net_groter_dan_waarde_Y_van_middelpunt_maar_geldig_middelpunt_gooit_Exception() {
        new Cirkel(geldigMiddelpunt, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Straal_is_veel_groter_dan_waarde_Y_van_middelpunt_maar_geldig_middelpunt_gooit_Exception() {
        new Cirkel(geldigMiddelpunt, 600);
    }

    @Test
    public void Cirkel_met_geldig_middelpunt_en_geldige_straal() {
        assertNotNull(cirkel);
        assertEquals(geldigeStraal, cirkel.getStraal(), delta);
        assertEquals(geldigMiddelpunt, cirkel.getMiddelpunt());
    }

    @Test
    public void Oppervlakte_Cirkel_met_geldige_straal_en_geldig_middelpunt() {
        double expectedGetal = geldigeStraal * geldigeStraal * Math.PI;
        assertEquals(expectedGetal, cirkel.berekenOppervlakte(), delta);
        assertEquals(12.566370614359172953850573533118, cirkel.berekenOppervlakte(), delta);
    }

    @Test
    public void Punt_is_binnen_cirkel_met_geldig_middelpunt_en_geldige_straal_is_True() {
        assertTrue(cirkel.isBinnenDeCirkel(puntBinnen));
    }

    @Test
    public void Punt_is_buiten_cirkel_met_geldig_middelpunt_en_geldige_straal_is_False() {
        assertFalse(cirkel.isBinnenDeCirkel(puntBuiten));
    }

    @Test(expected = IllegalArgumentException.class)
    public void VergrootStraal_met_negatieve_factor_Gooit_Exception() {
        cirkel.vergrootStraal(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void VergrootStraal_met_XY_groter_dan_middelpunt_Gooit_Exception() {
        cirkel.vergrootStraal(3);
    }

    @Test
    public void VergrootStraal_met_correcte_straal() {
        cirkel.vergrootStraal(1.5);
        assertEquals(3,cirkel.getStraal(), delta);
    }

    
}