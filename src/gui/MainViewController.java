package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.Numeros;
import gui.util.Alerts;
import gui.util.CalculaExpressao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainViewController implements Initializable{
	@FXML
	private Button btNum0;
	@FXML
	private Button btNum1;
	@FXML
	private Button btNum2;
	@FXML
	private Button btNum3;
	@FXML
	private Button btNum4;
	@FXML
	private Button btNum5;
	@FXML
	private Button btNum6;
	@FXML
	private Button btNum7;
	@FXML
	private Button btNum8;
	@FXML
	private Button btNum9;
	@FXML
	private Button btSoma;
	@FXML
	private Button btSub;
	@FXML
	private Button btDiv;
	@FXML
	private Button btMult;
	@FXML
	private Button btIgual;
	@FXML
	private Button btPercent;
	@FXML
	private Button btMod;
	@FXML
	private Button ponto;
	@FXML
	private Button virgula;
	@FXML
	private Button btApagador;
	@FXML
	private TextField contaEResultado;
	
	@FXML
	public void onBtIgualAction() {
		List<Numeros>numeros = new ArrayList<>();
		if(contaEResultado.getText()==null) {
			Alerts.showAlertaDeException("Erro",null,"Opa, não da para calcular o nada, informe pelo menos algum valor para calcular!",AlertType.ERROR);
		}
		else {
			CalculaExpressao.extruturaEquação(contaEResultado.getText(), numeros);
			for(Numeros num : numeros) {
				System.out.println(num);
			}
			CalculaExpressao.resolveEquacao(numeros);
			Numeros resultado = numeros.get(0);
			System.out.println();
			contaEResultado.setText(String.format("%.2f",resultado.getNumero()));
		}
	}
	
	@FXML
	public void onBtApagadorAction() {
		contaEResultado.requestFocus();
		contaEResultado.setText(null);
	}
	
	@FXML
	public void onBtNum0Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "0");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtNum1Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "1");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtNum2Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "2");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtNum3Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "3");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtNum4Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "4");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtNum5Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "5");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtNum6Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "6");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtNum7Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "7");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtNum8Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "8");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtNum9Action() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "9");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtSomaAction() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "+");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtSubAction() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "-");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtDivAction() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "/");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtMultAction() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "*");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtPercAction() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "%");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtModAction() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, "#");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtPotAction() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, ".");
		contaEResultado.requestFocus();
	}
	
	@FXML
	public void onBtVirAction() {
		String equacao = contaEResultado.getText();
		montaEquacao(equacao, ",");
		contaEResultado.requestFocus();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		onBtApagadorAction();
	}
	
	private void montaEquacao(String eq,String op) {
		if(eq==null) {
			eq=op;
		}
		else {
			eq+=op;
		}
		contaEResultado.setText(eq);
	}
}
