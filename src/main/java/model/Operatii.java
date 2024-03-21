package model;

import java.util.Map;

public class Operatii {

    public static Polinom adunarePolinoame(Polinom p1, Polinom p2) {
        Polinom rez = new Polinom();
        for(Map.Entry<Integer, Double> entry: p1.getPolinom().entrySet()) {
            int exp=entry.getKey();
            if(p2.getPolinom().get(exp)!=null) {
                rez.getPolinom().put(exp,entry.getValue()+ p2.getPolinom().get(exp));
            }
            else{
                rez.getPolinom().put(exp,entry.getValue());
            }
        }
        for(Map.Entry<Integer, Double> entry: p2.getPolinom().entrySet()) {
            int exp=entry.getKey();
            if(rez.getPolinom().get(exp)==null && p1.getPolinom().get(exp)!=null) {
                rez.getPolinom().put(exp,entry.getValue()+ p2.getPolinom().get(exp));
            }
            else if(rez.getPolinom().get(exp)==null && p1.getPolinom().get(exp)==null){
                rez.getPolinom().put(exp,entry.getValue());
            }
        }

        rez.verif0();
        rez.updateGrad();
        return rez;
    }

    public static Polinom scaderePolinoame(Polinom p1,Polinom p2) {
        Polinom rez = new Polinom();
        rez.setGrad(0);
        for(Map.Entry<Integer, Double> entry: p1.getPolinom().entrySet()) {
            int exp = entry.getKey();
            if (p2.getPolinom().get(exp) != entry.getValue()) {
                rez.setGrad(max(rez.getGrad(), exp));
                if (p2.getPolinom().get(exp) != null) {
                    rez.getPolinom().put(exp, entry.getValue() - p2.getPolinom().get(exp));
                } else {
                    rez.getPolinom().put(exp, entry.getValue());
                }
            }
        }
        for(Map.Entry<Integer, Double> entry: p2.getPolinom().entrySet()) {
            int exp = entry.getKey();
            if (p1.getPolinom().get(exp) != entry.getValue()) {
                rez.setGrad(max(rez.getGrad(), exp));
                if (rez.getPolinom().get(exp) == null && p1.getPolinom().get(exp) != null) {
                    rez.getPolinom().put(exp, p2.getPolinom().get(exp) - entry.getValue());
                } else if (rez.getPolinom().get(exp) == null) {
                    rez.getPolinom().put(exp, (-1) * entry.getValue());
                }
            }
        }
        rez.verif0();
        return rez;
    }

    public static Polinom produsPolinoame(Polinom p1,Polinom p2) {
        Polinom rez = new Polinom("0");
        Polinom aux= new Polinom();
        for(Map.Entry<Integer, Double> entry1: p1.getPolinom().entrySet()){
            aux=scaderePolinoame(new Polinom("1"),new Polinom("1"));
            for(Map.Entry<Integer, Double> entry2: p2.getPolinom().entrySet()) {
                if(entry1.getValue()!=0 && entry2.getValue()!=0)
                aux.getPolinom().put(entry1.getKey()+entry2.getKey(),entry1.getValue()*entry2.getValue());
            }
            rez=adunarePolinoame(rez,aux);
        }
        rez.setGrad(p1.getGrad() + p2.getGrad());
        return rez;
    }



    public static Polinom[] impartirePolinoame(Polinom p1,Polinom p2){
        Polinom[] rez = new Polinom[2];
        Polinom q = new Polinom("0");
        Polinom r = p1;
        while(!r.getPolinom().isEmpty() && r.getGrad()>=p2.getGrad())
        {
            Polinom t = new Polinom();
            t.getPolinom().put(r.getGrad()-p2.getGrad(),r.getPolinom().get(r.getGrad())/p2.getPolinom().get(p2.getGrad()));
            q=adunarePolinoame(q,t);
          //  q.verif0();
            r=scaderePolinoame(r,produsPolinoame(t,p2));
            //r.verif0();
            q.updateGrad();
            r.updateGrad();
        }
        q.verif0();
        r.verif0();
        rez[0]=q;
        rez[1]=r;
        rez[0].updateGrad();
        rez[1].updateGrad();
        return rez;
    }

    public static Polinom derivarePolinom(Polinom p1) {
        Polinom rez = new Polinom();
        for(Map.Entry<Integer, Double> entry: p1.getPolinom().entrySet()){
            if(entry.getKey()!=0) {
                rez.getPolinom().put(entry.getKey()-1, entry.getValue()* entry.getKey());
            }
        }
        if(p1.getGrad() >0){
            rez.setGrad(p1.getGrad() - 1);
        }
        else{
            rez.setGrad(0);
        }
        rez.updateGrad();
        return rez;
    }

    public static Polinom integrarePolinom(Polinom p1) {
        Polinom rez = new Polinom();
        for(Map.Entry<Integer, Double> entry: p1.getPolinom().entrySet()){
            if(entry.getKey()!=0) {
                rez.getPolinom().put(entry.getKey() + 1,(double) entry.getValue() / ((double)entry.getKey()+1));
            }
            if(entry.getKey()==0) {
                rez.getPolinom().put(entry.getKey() + 1, (double)entry.getValue());
            }
        }
            rez.setGrad(p1.getGrad() + 1);
        return rez;
    }

    public static int max(int a,int b)
    {
        if(a>b) {
            return a;
        }
        return b;
    }

}
