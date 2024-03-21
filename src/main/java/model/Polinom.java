package model;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private Map<Integer,Double> polinom = new HashMap<>();
    private Map<Integer,Double> polinomd = new HashMap<>();
    private Integer grad;
    private boolean valid=true;

    public Map<Integer, Double> getPolinom() {
        return polinom;
    }

    public void setPolinom(Map<Integer, Double> polinom) {
        this.polinom = polinom;
    }

    public Map<Integer, Double> getPolinomd() {
        return polinomd;
    }

    public void setPolinomd(Map<Integer, Double> polinomd) {
        this.polinomd = polinomd;
    }

    public Integer getGrad() {
        return grad;
    }

    public void setGrad(Integer grad) {
        this.grad = grad;
    }

    public Polinom()
    {
        setGrad(0);
    }

    public Polinom(String exString)
    {
       this.setPolinom(stringToMap(exString));
        this.updateGrad();
    }

    public boolean isValid() {
        return valid;
    }

    public HashMap stringToMap(String exString) {
        exString=exString.replace(" ","");
        this.setGrad(-1);      valid=true;
        HashMap<Integer, Double> m = new HashMap<>();
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(exString);
        int x = 0;
        while (matcher.find()) {
            x = x + 1;

            try{
            Integer[] vec=getElements(matcher.group(1));
            if(vec[0]> this.getGrad()){
                this.setGrad(vec[0]);
            }m.put(vec[0],(double)vec[1]);
            }
            catch (Exception e){
                valid=false;
            }
        }
        return m;
    }

    public Integer[] getElements(String s) {
        int exp=s.indexOf('^'),coeff=s.indexOf('x'),coefs,coef=0;
        if(exp==-1){
            if(coeff==-1) {
                exp = 0;
                coef=Integer.parseInt(s);
            }else{
                exp= 1;
            }
        }
        else {
            exp=Integer.parseInt(s.substring(exp+1));
        }
        if(coeff==0) {
            coef=1;
        }
        else {
            if(coeff==1 ) {
                if(s.charAt(0)=='-') {
                    coef = -1;
                }else {
                    coef=Integer.parseInt(s.charAt(0)+"");
                }
            }
            else if (exp != 0) {
                coef = Integer.parseInt(s.substring(0, coeff));
            }
        }
        Integer[] rez={exp,coef};
        return rez;}

    public void verif0()
    {
        int aux[] = new int[100],i=0;
        for(Map.Entry<Integer, Double> entry: this.polinom.entrySet()){
            if(entry.getValue()==0.0)
            {
               aux[i]=entry.getKey();
               i++;
            }
        }
        for(int j=0;j<i;j++)
        {
            this.polinom.remove(aux[j]);
        }
    }

    public void updateGrad()
    {   int maxim=-1;
        for(Map.Entry<Integer, Double> entry: this.polinom.entrySet()){
            if(entry.getValue()!=0.0 && entry.getKey()>maxim)
            {
                maxim=entry.getKey();
            }
        }
        this.grad=maxim;
    }

    public Map<Integer,Integer> doubleToInt()
    {
        Map<Integer,Integer> m = new HashMap<>();
        for(Map.Entry<Integer, Double> entry: this.polinom.entrySet()){
            m.put(entry.getKey(),Double.valueOf(entry.getValue()).intValue());
        }
        return m;
    }

    public String toString() {
        Map<Integer,Integer> aux= this.doubleToInt();
        TreeMap<Integer,Integer> polOrdonat = new TreeMap<>(Comparator.reverseOrder());
        polOrdonat.putAll(aux);
        String polAfisat="";
        for(Map.Entry<Integer,Integer> entry: polOrdonat.entrySet()) {
            String coef = entry.getValue().toString();
            Integer coefInt = Integer.parseInt(coef); coef=coefInt.toString();
            String exp = entry.getKey().toString();
            String semn = "";
            if (coef.charAt(0) != '-' && !(Integer.parseInt(exp) == this.getGrad())) {
                semn = "+";
            }
            if (exp.equals("0")) {
                polAfisat = polAfisat + semn + coef;
            } else {
                if (Integer.parseInt(coef)==1 ) {
                    coef = "";                System.out.println("Ok");
                } else if (coef.equals("-1")) {
                    coef = "-";
                }
                if (exp.equals("1")) {
                    polAfisat = polAfisat + semn + coef + "x";
                } else {
                        polAfisat = polAfisat + semn + coef + "x" + "^" + exp;
                    }
                }
            }
        return polAfisat;
    }
    public String toString2() {
        TreeMap<Integer,Double> polOrdonat = new TreeMap<>(Comparator.reverseOrder());
        polOrdonat.putAll(this.polinom);;
        String polAfisat="";

        for(Map.Entry<Integer,Double> entry: polOrdonat.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.##");
            String coef = df.format(entry.getValue());
            String exp = entry.getKey().toString();

            String semn = "";
            if (coef.charAt(0) != '-' && !(Integer.parseInt(exp) == this.getGrad())) {
                semn = "+";
            }
            if (exp.equals("0")) {
                polAfisat = polAfisat + semn + coef;
            } else {

                if (Double.parseDouble(coef)==1 ) {
                    coef = "";                System.out.println("Ok");
                } else if (coef.equals("-1")) {
                    coef = "-";

                }
                if (exp.equals("1")) {
                    polAfisat = polAfisat + semn + coef + "x";
                } else {
                    polAfisat = polAfisat + semn + coef + "x" + "^" + exp;
                }
            }
        }
        return polAfisat;
    }


}
