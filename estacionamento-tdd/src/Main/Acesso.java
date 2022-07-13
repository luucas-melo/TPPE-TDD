package Main;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalTime;

public class Acesso {
	
	String placa, horaEntrada, horaSaida;
	Estacionamento estacionamentoAcessado;
	
	public Acesso(Estacionamento estacionamento, String placa, String horaEntrada, String horaSaida) {
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.estacionamentoAcessado = estacionamento;
	}
	
	public float calculaAcesso() {
		LocalTime entradaTime = LocalTime.parse(this.horaEntrada);
		LocalTime saidaTime = LocalTime.parse(this.horaSaida);
		float tempoPermanencia = entradaTime.until(saidaTime, MINUTES);
		
		int fracoesDe15Minutos = (int) Math.ceil(tempoPermanencia/15f);
		
		if(fracoesDe15Minutos >= 4 && fracoesDe15Minutos <=36) {
			return  (1 - this.estacionamentoAcessado.valorHoraCheia) * 
					(this.estacionamentoAcessado.valorFracao * fracoesDe15Minutos);
		} 
		
		return 0f;
				
	}
}
