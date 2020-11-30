import java.util.Date;

import checkin.CheckIn;
import checkin.CheckInDAO;
import hospede.Hospede;
import hospede.HospedeDAO;

public class Executa {

	public static void main(String[] args) {
		Hospede h = new Hospede();
		HospedeDAO hd = new HospedeDAO();
		CheckIn ci = new CheckIn();
		CheckInDAO cd = new CheckInDAO();

		// h.setCodehospede(1);
		// h.setNome("CHorra");
		// h.setCpf("05333334467");
		// h.setTelefone("629999938");

		// hd.salvar(h);
		// hd.alterar(h, 1);
		// hd.excluir(1);

		// Buscar
		/*
		 * for (Hospede hos : hd.buscar("cpf", "05333334467")) {
		 * 
		 * System.out.println("ID: " + hos.getCodehospede());
		 * System.out.println("Nome: " + hos.getNome()); System.out.println("CPF: " +
		 * hos.getCpf()); System.out.println("Telefone: " + hos.getTelefone());
		 * System.out.println("-----------------------");
		 * 
		 * 
		 * }
		 */

		 ci.setCodecheck(1);
		 ci.setCodehospede(1);
		 ci.setDataentrada(new Date());
		 ci.setAddveiculo(true);
		 ci.setValortotal(500);
		 
		 

		 //cd.salvar(ci);
		//cd.alterar(ci, 2);
		//cd.excluir(2);
		 
 for (CheckIn check  : cd.buscar()) {
			  
			  System.out.println("ID: " + check.getCodecheck());
			  System.out.println("Nome: " + check.getCodehospede());
			  System.out.println("Data Entrada: " + check.getDataentrada());
			  System.out.println("Data Saida: " + check.getDatasaida());
			  System.out.println("Garagem Veiculo: " + check.isAddveiculo());
			  System.out.println("Valor Total: " + check.getValortotal());
			  System.out.println("-----------------------");
			  
			  
			  }

	}

}
