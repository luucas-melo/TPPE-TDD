package Main;

import java.util.ArrayList;

public class Estacionamento {
	
	String nome, entradaNoturna, retiradaNoturna;
	float valorFracao,  valorHoraCheia, valorDiariaDiurna, porcentagemContratante,
		valorAcessoMensalista, valorAcessoEvento, retornoContratante, porcentagemDiariaNoturna;
	int capacidade;	

	public Estacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia) {
		this.nome = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
	}
	

	public Estacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia, 
	float valorDiariaDiurna, float porcentagemDiariaNoturna,  
	String entradaNoturna, String retiradaNoturna) {
		this.nome = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		this.valorDiariaDiurna = valorDiariaDiurna;
		this.porcentagemDiariaNoturna = porcentagemDiariaNoturna;
		this.entradaNoturna =  entradaNoturna;
		this.retiradaNoturna = retiradaNoturna;
	}
	
	public Estacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia, 
			float valorDiariaDiurna, float porcentagemDiariaNoturna,  
			String entradaNoturna, String retiradaNoturna, float valorAcessoMensalista, 
			float valorAcessoEvento, int capacidade, float retornoContratante) {
				this.nome = nomeEstacionamento;
				this.valorFracao = valorFracao;
				this.valorHoraCheia = valorHoraCheia;
				this.valorDiariaDiurna = valorDiariaDiurna;
				this.porcentagemDiariaNoturna = porcentagemDiariaNoturna;
				this.entradaNoturna =  entradaNoturna;
				this.retiradaNoturna = retiradaNoturna;
				this.valorAcessoMensalista = valorAcessoMensalista;
				this.valorAcessoEvento = valorAcessoEvento;
				this.capacidade = capacidade;
				this.retornoContratante = retornoContratante;
		}
	

	public float calculaValorContratante(ArrayList<Acesso> listaAcessos) {
		float total = 0f;
		for(Acesso acesso : listaAcessos) {
			total = total + (acesso.calculaAcesso() * retornoContratante);
		}
		return total;
	}

	
}
