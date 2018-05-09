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
import org.mariuszgromada.math.mxparser.mXparser;

public class Secante {
    private int k = 1;
    private double y;
    private double x;
    private double xk;
    private double erro;
    private int kMax=1000;
    private Function funcaoX;
    private Function funcaoY;

    public Secante(String funcao , double x , double y , int casasDecimais){
        this.x = x;
        this.y = y;
        this.erro = Math.pow(10,-casasDecimais);
        String b[] = funcao.split("=");
        String funcaoAux = b[1].replaceAll("x","y");//isso é feito pois a funcao inicial é em relaçao a x
        //e é necessario uma função em relação a y
        this.funcaoX =new Function(funcao);
        this.funcaoY =new Function("f(y)="+funcaoAux);


    }


    public double calcularSecante(){
        xk = calcularXk();

        while((calcularErro()> erro) && (k<kMax)){
            y=x;
            x = xk;
            xk = calcularXk();
            k++;
        }

        System.out.println("XK :"+xk+". K:"+k);
        return xk;
    }

    private double calcularErro(){
        return  Math.abs((xk-x)/xk);
    }


    private double calcularXk(){
        return (calcularCima()/calcularBaixo());
    }


    private double calcularCima(){

        return x*(funcaoY.calculate(this.y))-y*(funcaoX.calculate(this.x));
    }

    private double calcularBaixo(){
        return (funcaoY.calculate(this.y))-(funcaoX.calculate(this.x));
    }
}
