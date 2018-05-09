package Controlador;


import Metodos.Bisseccao;
import Metodos.MIO;
import Metodos.Newton;
import Metodos.Secante;


import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class Controller {
    @FXML
    private TextField intervaloA;
    @FXML
    private TextField intervaloB;
    @FXML
    private TextField erroId;
    @FXML
    private ComboBox<String> comboboxId;//String pq quero apenas receber o nome do método selecionado no combobox
    @FXML
    private TextField funcaoArea;
    @FXML
    private Label respostaArea;



    public void calcularMetodo() {

        checarStringVazias();

            //checa se no intervalo nao possui nenhum caractere
            if  (intervaloA.getText().matches("[+-]?([0-9]*[.])?[0-9]+") && (intervaloB.getText().matches("[+-]?([0-9]*[.])?[0-9]+"))
                    && (erroId.getText().matches("[+-]?([0-9]*[.])?[0-9]+"))){

                String metodo = comboboxId.getSelectionModel().getSelectedItem();
                double a = Double.parseDouble(intervaloA.getText());
                double b = Double.parseDouble(intervaloB.getText());
                double resultado = 0;

                String funcao = funcaoArea.getText().trim();
                int erro = Integer.parseInt(erroId.getText());


                if (metodo.equals("Bissecção")) {
                    resultado = new Bisseccao(funcao, a, b, erro).calcularBisseccao();
                } else if (metodo.equals("M.I.O")) {
                    resultado = new MIO(funcao, a, erro).calcularMIO();
                } else if (metodo.equals("Newton")) {
                    resultado = new Newton(funcao, a, erro).calcularNewton();
                } else if (metodo.equals("Secante")) {
                    resultado = new Secante(funcao, a, b, erro).calcularSecante();
                }

                respostaArea.setText(String.valueOf(resultado));

            }
    }





    private void checarStringVazias(){
        if(intervaloA.getText().isEmpty()){
            intervaloA.setText(" ");
        }
        if(intervaloB.getText().isEmpty()){
            intervaloB.setText(" ");
        }
        if(erroId.getText().isEmpty()){
            erroId.setText(" ");
        }
        if(funcaoArea.getText().isEmpty()){
            funcaoArea.setText(" ");
        }
    }


    @FXML
    public void limparCampos(){

        intervaloA.setText("");
        intervaloB.setText("");
        erroId.setText("");
        funcaoArea.setText("");
        respostaArea.setText("1+1 = 3?");
    }


    @FXML
    public void entrarSite() throws URISyntaxException, IOException {
        //Abre uma nova aba no seu navegador favorito com o site da biblioteca usada
        Desktop d = Desktop.getDesktop();
        d.browse(new URI("http://mathparser.org/"));
    }


}
/*Por utilizar muitas aproximações pode ocorrer que o resultado não seja tão preciso , por isso é necessario sempre checar utilizando
* outro métodos ou aumentar a precisão */