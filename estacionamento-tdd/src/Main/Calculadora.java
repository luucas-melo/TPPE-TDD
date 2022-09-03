package Main;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Calculadora {
	DateTimeFormatter formatter;
	DateTimeFormatter timeFormatter;
	LocalDateTime entradaTime;
	LocalDateTime saidaTime;
	
	float tempoPermanencia;
	
	int fracoesDe15Minutos;
	
	public Calculadora(String horaEntrada, String horaSaida){
		this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		this.timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.entradaTime = LocalDateTime.parse(horaEntrada, formatter);
		this.saidaTime = LocalDateTime.parse(horaSaida, formatter);
		this.tempoPermanencia = entradaTime.until(saidaTime, MINUTES);
		this.fracoesDe15Minutos = (int) Math.ceil(tempoPermanencia/15f);
	}
	
	public float calculaAcesso(Estacionamento estacionamento) {
		if(entradaTime.until(LocalTime.parse(estacionamento.entradaNoturna, timeFormatter).atDate(entradaTime.toLocalDate()), MINUTES) <= 0) {
			return estacionamento.porcentagemDiariaNoturna * estacionamento.valorDiariaDiurna;
		}
		
		if(fracoesDe15Minutos < 4) {
			return estacionamento.valorFracao * fracoesDe15Minutos;
			
		}		
		else if(fracoesDe15Minutos >= 4 && fracoesDe15Minutos <=36) {
			return  (1 - estacionamento.valorHoraCheia) * 
					(estacionamento.valorFracao * fracoesDe15Minutos);
		}
		else {
			return estacionamento.valorDiariaDiurna;
		}
	}
//	public float calculaAcesso() {
//		if(tipoAcesso != null) {
//			if(tipoAcesso.equals("evento")) {
//				return estacionamentoAcessado.valorAcessoEvento;
//			}
//			else if(tipoAcesso.equals("mensalista")) {
//				return estacionamentoAcessado.valorAcessoMensalista;
//			}
//		}	
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		
//		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//		
//		LocalDateTime entradaTime = LocalDateTime.parse(this.horaEntrada, formatter);
//		LocalDateTime saidaTime = LocalDateTime.parse(this.horaSaida, formatter);
//		
//		float tempoPermanencia = entradaTime.until(saidaTime, MINUTES);
//		
//		int fracoesDe15Minutos = (int) Math.ceil(tempoPermanencia/15f);
//		
//	
//		
//
//		if(entradaTime.until(LocalTime.parse(this.estacionamentoAcessado.entradaNoturna, timeFormatter).atDate(entradaTime.toLocalDate()), MINUTES) <= 0) {
//			return this.estacionamentoAcessado.porcentagemDiariaNoturna * this.estacionamentoAcessado.valorDiariaDiurna;
//		}
//		
//		if(fracoesDe15Minutos < 4) {
//			return this.estacionamentoAcessado.valorFracao * fracoesDe15Minutos;
//			
//		}		
//		else if(fracoesDe15Minutos >= 4 && fracoesDe15Minutos <=36) {
//			return  (1 - this.estacionamentoAcessado.valorHoraCheia) * 
//					(this.estacionamentoAcessado.valorFracao * fracoesDe15Minutos);
//		}
//		else {
//			return this.estacionamentoAcessado.valorDiariaDiurna;
//		}		
//	}
}
