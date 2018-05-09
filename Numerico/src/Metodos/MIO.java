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

public class MIO {
    private int k = 1;
    private double x;
    private double xk;
    private double erro;
    private int kMax=1000;
    private Function funcao;

    public MIO(String funcao ,double x , int casasDecimais){
        this.x = x;
        this.erro = Math.pow(10,-casasDecimais);
        this.funcao = new Function(funcao);
    }


    public double calcularMIO(){
        xk = calcularFuncao(x);

        while((calcularErro()> erro) && (k<kMax)){
            x = xk;
            xk = calcularFuncao(x);
            k++;
        }

        System.out.println("XK :"+xk+". K:"+k);
        return xk;
    }

    private double calcularFuncao(double x){
        return funcao.calculate(x);//atualizar para a equação escolhida
    }
    private double calcularErro(){
        return  Math.abs((xk-x)/xk);
    }
}
