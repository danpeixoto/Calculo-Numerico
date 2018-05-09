package Metodos;
/*Esse projeto ,para poder ser feito do jeito que eu queria , só foi possivel a biblioteca mXparser
 * Ela permite que p usuário digite a função desejada , sem que essa pessoa mexa diretamente com o código
 * e nem derivar as funções
 *
 *
 * http://mathparser.org/   <- site da biblioteca
 *
 *
 *
 * */

import org.mariuszgromada.math.mxparser.Function;

public class Bisseccao {

    private int k = 0;
    private double a;
    private double b;
    private double xk;
    private double x;
    private double erro;
    private int kMax=1000;
    private Function funcao;


    public Bisseccao(String funcao , double a , double b , int casaDecimal){
        this.a = a;
        this.b = b;
        this.erro = Math.pow(10 , -casaDecimal);
        this.funcao = new Function(funcao);
    }




    public double calcularBisseccao(){
        calcularXk();
        x = xk;
        calcularXk();
        k++;
        while((calcularErro() > erro) && (k<kMax)){
            x = xk;
            calcularXk();
            k++;
        }

        System.out.println("XK :"+xk+". K:"+k);

        return x;
    }


    private void calcularXk(){
        xk = calcularMedia();


        if(calcularFuncao(a)*calcularFuncao(xk)>0){
            a = xk;
        }else{
            b = xk;
        }

    }

    private double calcularMedia(){
        return (a+b)/2;
    }

    private double calcularErro(){
        return  Math.abs((xk-x)/xk);
    }

    private double calcularFuncao(double x){
        return funcao.calculate(x);//atualizar para a equação escolhida
    }



}
