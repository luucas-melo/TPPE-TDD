package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Estacionamento estacionamento1;
    private Estacionamento estacionamento2;
    private Estacionamento estacionamento3;
    private Estacionamento estacionamentoAcessado;
    private float valorContratante = 0;
    private ArrayList<Acesso> listaAcessoEstacionamento1 = new ArrayList<>();
    private ArrayList<Acesso> listaAcessoEstacionamento2 = new ArrayList<>();
    private ArrayList<Acesso> listaAcessoEstacionamento3 = new ArrayList<>();
    
    private String placa, horarioEntrada, horarioSaida, tipoAcesso;
    Scanner sc = new Scanner(System.in);
    
    private List<Estacionamento> estacionamentos = new ArrayList<>();
    private List<List<Acesso>> listasDeAcessos = new ArrayList<>();

	public Menu() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
	  

	    this.estacionamento1 = new Estacionamento("Estacionamento1", 30f, 0.15f, 120f, 0.45f, "19:00:00", "08:00:00", 600f, 50f, 300, 0.5f);
	    this.estacionamento2 = new Estacionamento ("Estacionamento2", 20f, 0.15f, 120f, 0.45f,"21:00:00", "07:00:00", 455f, 60f, 120, 0.6f);
	    this.estacionamento3 = new Estacionamento ("Estacionamento3", 10f, 0f, 50f, 0.40f, "20:00:00", "08:00:00", 350f, 40f, 600, 0.7f);
	    
	    estacionamentos.add(estacionamento1);
	    estacionamentos.add(estacionamento2);
	    estacionamentos.add(estacionamento3);

		listasDeAcessos.add(listaAcessoEstacionamento1);
		listasDeAcessos.add(listaAcessoEstacionamento2);
		listasDeAcessos.add(listaAcessoEstacionamento3);
	    
		executaMenu();

	}

	private void executaMenu() throws DescricaoEmBrancoException {
		int opcao;
		
		do {
			System.out.println("==========="); 
			System.out.println("1- Cadastrar acesso");
			System.out.println("2- Apurar valor do contratante");
			System.out.println("0- Sair"); 
			
			opcao = Integer.parseInt(sc.nextLine());
			System.out.println("\n\n"); 
			switch(opcao) {
			  case 1:
				  menuCadastrarAcesso();
				  break;
			  case 2:
				  menuApurarValorContratante();
				  break;
			  default:
			    return;
			} 
		} while(opcao != 0);
	}

	private void menuCadastrarAcesso() throws DescricaoEmBrancoException {
		System.out.println("====Cadastrar acesso===="); 
				  menuEstacionamento();

				  for(int i = 0; i < estacionamentos.size(); i++) {

					if (this.estacionamentoAcessado == estacionamentos.get(i)) {
						if (this.estacionamentoAcessado.capacidade == this.listasDeAcessos.get(i).size()) {
							System.out.println("Estacionamento lotado \n\n");
							break;
						}
					}
				  }
				  
				  System.out.println("Placa do carro"); 	
				  this.placa = sc.nextLine();
				  System.out.println("Tipo de acesso (evento ou mensalista):"); 
				  this.tipoAcesso = sc.nextLine();
				  if (this.tipoAcesso.equals("evento") || this.tipoAcesso.equals("mensalista")) {
					  Acesso acesso = new Acesso(this.estacionamentoAcessado, this.placa, this.tipoAcesso);
					  System.out.println("Valor do acesso: " + acesso.calculaAcesso() + "\n\n\n\n\n");
					  adicionaAcesso(acesso);
					
				  }else {
					  System.out.println("horario Entrada dd-MM-yyyy hh:mm:ss"); 	
					  this.horarioEntrada = sc.nextLine();
					  System.out.println("horario Saida dd-MM-yyyy hh:mm:ss"); 
					  this.horarioSaida = sc.nextLine();
					  Acesso acesso = new Acesso(this.estacionamentoAcessado, this.placa, (String)this.horarioEntrada, (String)this.horarioSaida);
					  System.out.println("Valor do acesso: " + acesso.calculaAcesso() + "\n\n\n\n\n");
					  adicionaAcesso(acesso);
				  }
	}

	private void menuApurarValorContratante() {
		System.out.println("====Apurar valor do contratante===="); 
		menuEstacionamento();
		System.out.println("Valor do contratante: " + this.valorContratante + "\n\n\n\n\n");
	}

	private void adicionaAcesso(Acesso acesso) {

		for(int i = 0; i < estacionamentos.size(); i++) {
			if (this.estacionamentoAcessado == estacionamentos.get(i)) {
				this.listasDeAcessos.get(i).add(acesso);
			}
		}
	}
	
	public void menuEstacionamento() {
		
		System.out.println("Escolha um estacionamento:"); 
		System.out.println("1- Estacionamento 1");
		System.out.println("2- Estacionamento 2");
		System.out.println("3- Estacionamento 3");
		int opcao = Integer.parseInt(sc.nextLine());
		
		switch(opcao) {
		case 1:
			this.estacionamentoAcessado = this.estacionamento1;
			this.valorContratante = this.estacionamentoAcessado.calculaValorContratante(this.listaAcessoEstacionamento1);
			break;
		case 2:
			this.estacionamentoAcessado = this.estacionamento2;
			this.valorContratante = this.estacionamentoAcessado.calculaValorContratante(this.listaAcessoEstacionamento2);
			break;
		case 3:
			this.estacionamentoAcessado = this.estacionamento3;
			this.valorContratante = this.estacionamentoAcessado.calculaValorContratante(this.listaAcessoEstacionamento3);
			break;
		default:
			menuEstacionamento();
		}
		  
	}
}