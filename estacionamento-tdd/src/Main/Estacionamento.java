package Main;

import java.util.ArrayList;

public class Estacionamento {
	
	String nome, entradaNoturna, retiradaNoturna;
	float valorFracao,  valorHoraCheia, valorDiariaDiurna, porcentagemContratante,
		valorAcessoMensalista, valorAcessoEvento, retornoContratante, porcentagemDiariaNoturna;
	int capacidade;	

	public Estacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia) throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		if (nomeEstacionamento == null || nomeEstacionamento.equals("")) {
            throw new DescricaoEmBrancoException("Dados do nome do estacionamento nulo ou vazio");
        }
		if (valorFracao < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor da fração inválido");
        }
		if (valorHoraCheia < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de hora cheia inválido");
        }
		
		this.nome = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
	}
	

	public Estacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia, 
	float valorDiariaDiurna, float porcentagemDiariaNoturna,  
	String entradaNoturna, String retiradaNoturna) throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		if (nomeEstacionamento == null || nomeEstacionamento.equals("")) {
            throw new DescricaoEmBrancoException("Dados do nome do estacionamento nulo ou vazio");
        }
		if (valorFracao < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor da fração inválido");
        }
		if (valorHoraCheia < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de hora cheia inválido");
        }
		if (valorDiariaDiurna < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de diária diurna inválido");
        }
		if (porcentagemDiariaNoturna < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de porcentagem da diária noturna inválido");
        }
		if (entradaNoturna == null || entradaNoturna.equals("")) {
            throw new DescricaoEmBrancoException("Dados do valor de entrada noturna nulo ou vazio");
        }
		if (retiradaNoturna == null || retiradaNoturna.equals("")) {
            throw new DescricaoEmBrancoException("Dados do valor de retirada noturna nulo ou vazio");
        }

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
			float valorAcessoEvento, int capacidade, float retornoContratante) throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		if (nomeEstacionamento == null || nomeEstacionamento.equals("")) {
            throw new DescricaoEmBrancoException("Dados do nome do estacionamento nulo ou vazio");
        }
		if (valorFracao < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor da fração inválido");
        }
		if (valorHoraCheia < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de hora cheia inválido");
        }
		if (valorDiariaDiurna < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de diária diurna inválido");
        }
		if (porcentagemDiariaNoturna < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de porcentagem da diária noturna inválido");
        }
		if (entradaNoturna == null || entradaNoturna.equals("")) {
            throw new DescricaoEmBrancoException("Dados do valor de entrada noturna nulo ou vazio");
        }
		if (retiradaNoturna == null || retiradaNoturna.equals("")) {
            throw new DescricaoEmBrancoException("Dados do valor de retirada noturna nulo ou vazio");
        }
		if (valorAcessoMensalista < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de acesso mensalista inválido");
        }
		if (valorAcessoEvento < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de acesso evento inválido");
        }
		if (capacidade < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de capacidade inválido");
        }
		if (retornoContratante < 0) {
            throw new ValorAcessoInvalidoException("Dados do valor de retorno do contratante inválido");
        }
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
		
		if (listaAcessos.isEmpty()) {
			return total;
		}
		
		for(Acesso acesso : listaAcessos) {
			total = total + (acesso.calculaAcesso() * retornoContratante);
		}
		return total;
	}

	
}

