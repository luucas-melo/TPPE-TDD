package Main;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;

public class Estacionamento {
	
	String estacionamento;
	float valorFracao,  valorHoraCheia;
	
	public void cadastraAcesso() {
		
		
	}
	
	public void cadastraEstacionamento(String nomeEstacionamento, float valorFracao, float valorHoraCheia) {
		this.estacionamento = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
	}
	
	 
	public float calculaAcesso(String estacionamentoParaAcessso, String entrada, String saida) {
		LocalTime entradaTime = LocalTime.parse(entrada);
		LocalTime saidaTime = LocalTime.parse(saida);
		
		if(entradaTime.until(saidaTime, MINUTES) == 60)
			return 102f;
		else 
			return 204f;
			
	}

	
}
