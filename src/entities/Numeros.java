package entities;

public class Numeros {
	private Double numero;
	private String operador;
	public Numeros(Double numero, String operador) {
		this.numero = numero;
		this.operador = operador;
	}
	public Double getNumero() {
		return numero;
	}
	public void setNumero(Double numero) {
		this.numero = numero;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	@Override
	public String toString() {
		return "Numeros [numero=" + numero + ", operador=" + operador + "]";
	}
	
	
}
