# Projeto-Hotel-java

--> Manter dados do Hospede:

    Hospede h = new Hospede();
		HospedeDAO hd = new HospedeDAO();

    Insert:  
		   h.setCodehospede(1);
		   h.setNome("Nome");
		   h.setCpf("00000000000");
		   h.setTelefone("00000000");
       
       hd.salvar(h);
       
    Update:
       h.setCodehospede(1);
		   h.setNome("Nome");
		   h.setCpf("00000000000");
		   h.setTelefone("00000000");
       
       hd.alterar(h, 1);
       
    Excluir
       hd.excluir(1);
       
       
    Select
      for (Hospede hos : hd.buscar(" selecionar entre as palavras [nome, cpf, telefone] ", "de acordo com o anterior selecionado, digitar o valor correspondente para pesquisa"))     {		  
		    System.out.println("ID: " + hos.getCodehospede());
		    System.out.println("Nome: " + hos.getNome()); 
        System.out.println("CPF: " + hos.getCpf()); 
        System.out.println("Telefone: " + hos.getTelefone());
		    System.out.println("-----------------------");
		 } 
       
       
       
----------> CheckIn


     CheckIn ci = new CheckIn();
		 CheckInDAO cd = new CheckInDAO();
      
     
     insert:
        ci.setCodecheck(1);
		    ci.setCodehospede(1);
		    ci.setDataentrada(new Date());
		    ci.setAddveiculo(true);
		    ci.setValortotal(500);
		 
		    cd.salvar(ci);
        
        
     update:
        ci.setCodecheck(1);
		    ci.setCodehospede(1);
		    ci.setDatasaida(new Date());
		    ci.setAddveiculo(true);
		    ci.setValortotal(500);
        
        cd.alterar(ci, 2);
        
        
      excluir: 
		    cd.excluir(2);
       
       
       
      select:
      for (CheckIn check  : cd.buscar()) {
			  
			  System.out.println("ID: " + check.getCodecheck());
			  System.out.println("Nome: " + check.getCodehospede());
			  System.out.println("Data Entrada: " + check.getDataentrada());
			  System.out.println("Data Saida: " + check.getDatasaida());
			  System.out.println("Garagem Veiculo: " + check.isAddveiculo());
			  System.out.println("Valor Total: " + check.getValortotal());
			  System.out.println("-----------------------");
			  
			  
			  }
       
       
       
       
