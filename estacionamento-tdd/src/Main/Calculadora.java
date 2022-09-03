package Main;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Calculadora {
	private static final DateTimeFormatter FORMATTER  = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
	private LocalDateTime entradaTime;
	private LocalDateTime saidaTime;
	
	private float tempoPermanencia;
	
	private int fracoesDe15Minutos;
	
	private static final float FRACAO_15_MINUTOS = 15f;
	private static final int QUANTIDADE_FRACOES_1_HORA = 4;
	private static final int QUANTIDADE_FRACOES_9_HORA = 36;
	
	public Calculadora(String horaEntrada, String horaSaida){
		this.entradaTime = LocalDateTime.parse(horaEntrada, FORMATTER);
		this.saidaTime = LocalDateTime.parse(horaSaida, FORMATTER);
		this.tempoPermanencia = entradaTime.until(saidaTime, MINUTES);
		this.fracoesDe15Minutos = (int) Math.ceil(tempoPermanencia/FRACAO_15_MINUTOS);
	}
	
	public float calculaAcesso(Estacionamento estacionamento) {
		if(entradaTime.until(LocalTime.parse(estacionamento.entradaNoturna, TIME_FORMATTER).atDate(entradaTime.toLocalDate()), MINUTES) <= 0) {
			return estacionamento.porcentagemDiariaNoturna * estacionamento.valorDiariaDiurna;
		}
		
		if(fracoesDe15Minutos < QUANTIDADE_FRACOES_1_HORA) {
			return estacionamento.valorFracao * fracoesDe15Minutos;
			
		}		
		else if(fracoesDe15Minutos >= QUANTIDADE_FRACOES_1_HORA && fracoesDe15Minutos <= QUANTIDADE_FRACOES_9_HORA) {
			return  (1 - estacionamento.valorHoraCheia) * 
					(estacionamento.valorFracao * fracoesDe15Minutos);
		}
		else {
			return estacionamento.valorDiariaDiurna;
		}
	}
}
