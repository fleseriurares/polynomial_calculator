
import model.Operatii;
import model.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OperationsTest {
    Polinom p1=new Polinom("2x^2+5x-4");
    Polinom p2=new Polinom("3x^3+5x^2+1");

    @Test
    public void constructorTest(){
        Polinom p3 = new Polinom("2x^3+5x-4");
        assertEquals(p3.toString(),"2x^3+5x-4");
    }

    @Test
    public void addTest(){
       // System.out.println(Operatii.adunarePolinoame(p1,p2));
        assertEquals(Operatii.adunarePolinoame(p1,p2).toString(),"3x^3+7x^2+5x-3");
    }

    @Test
    public void addTestFalse(){
        // System.out.println(Operatii.adunarePolinoame(p1,p2));
        assertNotEquals(Operatii.adunarePolinoame(p1,p2).toString(),"5x^3+7x^2+5x-3");
    }



    @Test
    public void subTest(){
       // System.out.println(Operatii.scaderePolinoame(p2,p1));
        assertEquals(Operatii.scaderePolinoame(p2,p1).toString(),"3x^3+3x^2-5x+5");
    }

    @Test
    public void subTestFalse(){
        // System.out.println(Operatii.scaderePolinoame(p2,p1));
        assertNotEquals(Operatii.scaderePolinoame(p2,p1).toString(),"3x^4+3x^2-5x+5");
    }

    @Test
    public void proTest(){
        System.out.println(Operatii.produsPolinoame(p1,p2));
        assertEquals(Operatii.produsPolinoame(p1,p2).toString(),"6x^5+25x^4+13x^3-18x^2+5x-4");
    }

    @Test
    public void proTestFalse(){
        System.out.println(Operatii.produsPolinoame(p1,p2));
        assertNotEquals(Operatii.produsPolinoame(p1,p2),"6x^5+25x^4+13x^3+5x-4");
    }

    @Test
    public void divTestFalse(){
   //     System.out.println(Operatii.impartirePolinoame(p2,p1)[0].toString2());
   //     System.out.println(Operatii.impartirePolinoame(p2,p1)[1].toString2());
        assertNotEquals(Operatii.impartirePolinoame(p2,p1)[0].toString2(),"1.5x-1.5");
        assertNotEquals(Operatii.impartirePolinoame(p2,p1)[1].toString2(),"12.25x-4.5");
    }

    @Test
    public void divTest(){
        //     System.out.println(Operatii.impartirePolinoame(p2,p1)[0].toString2());
        //     System.out.println(Operatii.impartirePolinoame(p2,p1)[1].toString2());
        assertEquals(Operatii.impartirePolinoame(p2,p1)[0].toString2(),"1.5x-1.25");
        assertEquals(Operatii.impartirePolinoame(p2,p1)[1].toString2(),"12.25x-4");
    }

    @Test
    public void derivTest(){
        assertEquals(Operatii.derivarePolinom(p1).toString(),"4x+5");
    }

    public void derivTestFalse(){
        assertEquals(Operatii.derivarePolinom(p1).toString(),"0.67x^3+2.5x^2-4x");
    }

    @Test
    public void intTest(){
        System.out.println((Operatii.integrarePolinom(p1).toString2()));
        assertEquals(Operatii.integrarePolinom(p1).toString2(),"0.67x^3+2.5x^2-4x");
    }

    @Test
    public void intTestFalse(){
        System.out.println((Operatii.integrarePolinom(p1).toString2()));
        assertNotEquals(Operatii.integrarePolinom(p1).toString2(),"0.67x^5+2.5x^2-4x");
    }

}
