package controller;

import model.Operatii;
import model.Polinom;
import view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.view = view;
        this.view.adunareListener(new AdunareListener());
        this.view.scadereListener(new ScadereListener());
        this.view.inmultireListener(new InmultireListener());
        this.view.impartireListener(new ImpartireListener());
        this.view.derivareListener(new DerivareListener());
        this.view.integrareListener(new IntegrareListener());
    }

    class AdunareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom pol1 = new Polinom(view.getFirstPolynomial());
            Polinom pol2 = new Polinom(view.getSecondPolynomial());
            if(pol1.isValid() && pol2.isValid() && !pol1.toString().equals("") && !pol2.toString().equals(""))
            {
                Polinom rez = Operatii.adunarePolinoame(pol1, pol2);
            view.setResult(rez.toString());}
            else{
                view.setResult("Nu ai introdus corect.");
            }
            view.setRemainder("");
        }
    }

    class ScadereListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom pol1 = new Polinom(view.getFirstPolynomial());
            Polinom pol2 = new Polinom(view.getSecondPolynomial());

            if(pol1.isValid() && pol2.isValid() && !pol1.toString().equals("") && !pol2.toString().equals(""))
            {
                Polinom rez = Operatii.scaderePolinoame(pol1, pol2);
                view.setResult(rez.toString());}
            else{
                view.setResult("Nu ai introdus corect.");
            }
            view.setRemainder("");
        }
    }

    class InmultireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom pol1 = new Polinom(view.getFirstPolynomial());
            Polinom pol2 = new Polinom(view.getSecondPolynomial());
            if(pol1.isValid() && pol2.isValid() && !pol1.toString().equals("") && !pol2.toString().equals(""))
            {
                Polinom rez = Operatii.produsPolinoame(pol1, pol2);
                view.setResult(rez.toString());}
            else{
                view.setResult("Nu ai introdus corect.");
            }
            view.setRemainder("");
        }
    }

    class ImpartireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom pol1= new Polinom(view.getFirstPolynomial());
            Polinom pol2= new Polinom(view.getSecondPolynomial());
            if(pol1.isValid() && pol2.isValid() && !pol1.toString().equals("") && !pol2.toString().equals("") && !pol2.toString().equals("0"))
            {
                Polinom rez[] = Operatii.impartirePolinoame(pol1, pol2);
                view.setResult(rez[0].toString2());
                view.setRemainder(rez[1].toString2());}
            else{
                view.setResult("Nu ai introdus corect.");
            }

        }
    }

    class DerivareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom pol1= new Polinom(view.getFirstPolynomial());
            view.setSecondPolynomial("");
            if(pol1.isValid() )
            {
                Polinom rez = Operatii.derivarePolinom(pol1);
                view.setResult(rez.toString());}
            else{
                view.setResult("Nu ai introdus corect.");
            }
            view.setRemainder("");
        }
    }

    class IntegrareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom pol1= new Polinom(view.getFirstPolynomial());
            view.setSecondPolynomial("");
            if(pol1.isValid() )
            {
                Polinom rez = Operatii.integrarePolinom(pol1);
                view.setResult(rez.toString2() + "+C");}
            else{
                view.setResult("Nu ai introdus corect.");
            }
            view.setRemainder("");
        }
    }


}
