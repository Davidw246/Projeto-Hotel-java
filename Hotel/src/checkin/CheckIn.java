package checkin;

import java.util.Date;

public class CheckIn {
	private int codecheck;
	private int codehospede;
	private Date data_entrada;
	private Date data_saida;
	private boolean add_veiculo;
	private double valortotal;

	public int getCodecheck() {
		return codecheck;
	
	}

	public void setCodecheck(int codecheck) {
		this.codecheck = codecheck;
	}

	public int getCodehospede() {
		return codehospede;
	}

	public void setCodehospede(int codehospede) {
		this.codehospede = codehospede;
	}

	public Date getDataentrada() {
		return data_entrada;
	}

	public void setDataentrada(Date dataentrada) {
		this.data_entrada = dataentrada;
	}

	public Date getDatasaida() {
		return data_saida;
	}

	public void setDatasaida(Date datasaida) {
		this.data_saida = datasaida;
	}

	public boolean isAddveiculo() {
		return add_veiculo;
	}

	public void setAddveiculo(boolean addveiculo) {
		this.add_veiculo = addveiculo;
	}

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	
	
}
