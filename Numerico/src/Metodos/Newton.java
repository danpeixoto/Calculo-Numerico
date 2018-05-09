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
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;

public class Newton {

    private int k = 1;
    private double x;
    private double xk;
    private double erro;
    private int kMax=1000;
    private Function funcao;
    private String valorParaDerivada;

    public Newton(String funcao , double x , int casasDecimais){
        this.x = x;
        this.erro = Math.pow(10,-casasDecimais);
        this.funcao = new Function(funcao);
        String s[] = funcao.split("=");
        this.valorParaDerivada  = s[1];
    }


    public double calcularNewton(){
        xk = calcularXk(x);

        while((calcularErro()> erro) && (k<kMax)){
            x = xk;
            xk = calcularXk(x);
            k++;
        }

        System.out.println("XK :"+xk+". K:"+k);
        return xk;
    }

    private double calcularErro(){
        return  Math.abs((xk-x)/xk);
    }


    private double calcularXk(double X){
        return X-(calcularFuncao(X)/calcularDerivada(X));
    }


    private double calcularFuncao(double X){
        return funcao.calculate(X);
    }

    private double calcularDerivada(double X){
        Argument x = new Argument("x="+X);
        return new Expression("der("+valorParaDerivada+",x)",x).calculate();
    }
}
