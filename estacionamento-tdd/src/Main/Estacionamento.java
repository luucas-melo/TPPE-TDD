package Main;

public class Estacionamento {
	
	String nome;
	float valorFracao,  valorHoraCheia, valorDiariaDiurna;
	float porcentagemDiariaNoturna;
	String entradaNoturna, retiradaNoturna;
	float porcentagemContratante;
	

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
	

	public float calculaValorContratante() {
		if (this.nome == "Estacionamento2") {
			return 115f;
		}
		return 130f;
	}

	
}
