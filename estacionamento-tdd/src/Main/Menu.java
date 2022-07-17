package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Estacionamento estacionamento1;
    private Estacionamento estacionamento2;
    private Estacionamento estacionamento3;
    private String placa, horarioEntrada, horarioSaida;
    Scanner sc = new Scanner(System.in);
    
    List<Estacionamento> estacionamentos = new ArrayList<Estacionamento>();
	public Menu() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
	  

	    this.estacionamento1 = new Estacionamento("estacionamento1", 30f, 0.15f, 120f, 0.45f, "09-05-2000 19:00:00", "09-05-2000  08:00:00", 600f, 50f, 300, 50f);
	    
	    estacionamentos.add(estacionamento1);
	    
		System.out.println("==========="); 
		// System.out.println("1- Cadastrar estacionamento"); 
		System.out.println("2- Cadastrar acesso"); 
		System.out.println("0- Sair"); 
		
		int opcao = Integer.parseInt(sc.nextLine());
		switch(opcao) {
		  case 2:
			  System.out.println("====Cadastrar acesso===="); 
			  System.out.println("Escolha um estacionamento"); 	
			  sc.nextLine();
			 
			  System.out.println("Placa do carro"); 	
			  this.placa = sc.nextLine();
			  System.out.println("horario Entrada dd/MM/yy hh:mm:ss"); 	
			  this.horarioEntrada = sc.nextLine();
			  System.out.println("horario Saida dd/MM/yy hh:mm:ss"); 
			  this.horarioSaida = sc.nextLine();
			  Acesso acesso = new Acesso(estacionamento1, this.placa, this.horarioEntrada, this.horarioSaida);
			  System.out.println(acesso.calculaAcesso());
		  break;
		  default:
		    return;
		}

	}
	
}
