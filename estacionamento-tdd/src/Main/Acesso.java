package Main;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		LocalDateTime entradaTime = LocalDateTime.parse(this.horaEntrada, formatter);
		LocalDateTime saidaTime = LocalDateTime.parse(this.horaSaida, formatter);
		LocalDateTime entradaNoturna = LocalDateTime.parse(this.estacionamentoAcessado.entradaNoturna, formatter); 
		
		float tempoPermanencia = entradaTime.until(saidaTime, MINUTES);
		
		int fracoesDe15Minutos = (int) Math.ceil(tempoPermanencia/15f);
		
	
		LocalTime timeExtraidoNoturna = entradaNoturna.toLocalTime();
		LocalDate dateExtraidoAcesso = entradaTime.toLocalDate();
		// Falsificação entrada noturna
		if(entradaTime.until(LocalDateTime.parse(this.estacionamentoAcessado.entradaNoturna, formatter), MINUTES) <= 0) {
			LocalDateTime timeExtraidoNoturno = LocalDateTime.parse(this.estacionamentoAcessado.entradaNoturna, formatter);
			return this.estacionamentoAcessado.porcentagemDiariaNoturna * this.estacionamentoAcessado.valorDiariaDiurna;
		}
		
		if(fracoesDe15Minutos >= 4 && fracoesDe15Minutos <=36) {
			return  (1 - this.estacionamentoAcessado.valorHoraCheia) * 
					(this.estacionamentoAcessado.valorFracao * fracoesDe15Minutos);
		} 
		
		
		return 0f;
		
				
	}
}
