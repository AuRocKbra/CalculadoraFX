package gui.util;

import java.util.List;

import entities.Numeros;
import javafx.scene.control.Alert.AlertType;

public class CalculaExpressao {
	private static String numero;

	public static void extruturaEquação(String expressao, List<Numeros> numeros){
		try {
			String exp = expressao;
			exp = exp.replace(",", ".");
			numero = null;
			for(int i=0;i<exp.length();i++) {
				String aux = String.valueOf(exp.charAt(i));
				if(numero!=null) {
					//String proxChar = String.valueOf(exp.charAt(i+1));
					if(aux.equals("+") || aux.equals("-") || aux.equals("/") || aux.equals("*") || aux.equals("%") || aux.equals("#")) {
						numeros.add(new Numeros(Double.valueOf(numero), aux));
						numero=null;
					}
					else {
						numero +=aux;
					}	
				}
				else {
					if(aux.equals("+") || aux.equals("-") || aux.equals("/") || aux.equals("*") || aux.equals("%") || aux.equals("#") ) {
						Alerts.showAlertaDeException("Erro",null,"Formato da expressão errado",AlertType.ERROR);
					}
					else {
						numero=aux;
					}
				}
			}
			numeros.add(new Numeros(Double.valueOf(numero),null));
		}
		catch(NumberFormatException e) {
			Alerts.showAlertaDeException("Erro",null,"Formato da equação inválido",AlertType.ERROR);
		}
	}
	
	public static void resolveEquacao(List<Numeros>equacao) {
		int aux=0;
		int controle=0;
		String [] operador = {"*","/","+","-","%","#"};
		while(equacao.size()>1) {
			Numeros numero  = equacao.get(controle);
			if(numero.getOperador()!=null) {
				if(numero.getOperador().equals(operador[aux])) {
					if(equacao.get(controle+1)!=null) {
						numero = realizaOperacao(numero, equacao.get(controle+1));
						equacao.remove(controle+1);
						equacao.set(controle, numero);
						controle=0;
					}
				}
				else {
					if(controle < equacao.size()) {
						controle++;
					}
					else {
						controle=0;
						if(aux<operador.length) {
							aux++;
						}
						else {
							aux=0;
						}
					}
				}
			}
			else {
				controle=0;
				if(aux<operador.length) {
					aux++;
				}
				else {
					aux=0;
				}
			}
		}
	}
	
	private static Numeros realizaOperacao(Numeros numero1, Numeros numero2) {
		Double x,y;
		x = Double.valueOf(numero1.getNumero());
		y = Double.valueOf(numero2.getNumero());
		switch(numero1.getOperador()){
			case "*":
				x=x*y;
				break;
			case "/":
				x=x/y;
				break;
			case "+":
				x+=y;
				break;
			case "-":
				x-=y;
				break;
			case "%":
				x= (x*y)/100.0;
				break;
			case "#":
				x=x%y;
				break;
			default:
				x=0.0;
		}
		return new Numeros(x,numero2.getOperador());
	}
}
