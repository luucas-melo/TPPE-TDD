package Main;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Acesso {
	
	String placa, horaEntrada, horaSaida;
	Estacionamento estacionamentoAcessado;
	String tipoAcesso;
	
	public Acesso(Estacionamento estacionamento, String placa, String horaEntrada, String horaSaida) throws DescricaoEmBrancoException {
		if (placa == null || placa.equals("")) {
            throw new DescricaoEmBrancoException("Dados da placa nulo ou vazio");
        }
		
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.estacionamentoAcessado = estacionamento;
	}
	
	public Acesso(Estacionamento estacionamento, String placa, String horaEntrada, String horaSaida, String tipoAcesso) throws DescricaoEmBrancoException {
		if (placa == null || placa.equals("")) {
            throw new DescricaoEmBrancoException("Dados da placa nulo ou vazio");
        }

		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.estacionamentoAcessado = estacionamento;
		this.tipoAcesso = tipoAcesso;
	}
	
	public float calculaAcesso() {
		if(tipoAcesso != null) {
			if(tipoAcesso.equals("evento")) {
				return estacionamentoAcessado.valorAcessoEvento;
			}
			else if(tipoAcesso.equals("mensalista")) {
				return estacionamentoAcessado.valorAcessoMensalista;
			}
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		LocalDateTime entradaTime = LocalDateTime.parse(this.horaEntrada, formatter);
		LocalDateTime saidaTime = LocalDateTime.parse(this.horaSaida, formatter);
		LocalDateTime entradaNoturna = LocalDateTime.parse(this.estacionamentoAcessado.entradaNoturna, formatter); 
		
		float tempoPermanencia = entradaTime.until(saidaTime, MINUTES);
		
		int fracoesDe15Minutos = (int) Math.ceil(tempoPermanencia/15f);
		
	
		LocalTime timeExtraidoNoturna = entradaNoturna.toLocalTime();
		LocalDate dateExtraidoAcesso = entradaTime.toLocalDate();

		if(entradaTime.until(LocalDateTime.parse(this.estacionamentoAcessado.entradaNoturna, formatter), MINUTES) <= 0) {
			LocalDateTime timeExtraidoNoturno = LocalDateTime.parse(this.estacionamentoAcessado.entradaNoturna, formatter);
			return this.estacionamentoAcessado.porcentagemDiariaNoturna * this.estacionamentoAcessado.valorDiariaDiurna;
		}
		
		if(fracoesDe15Minutos < 4) {
			return this.estacionamentoAcessado.valorFracao * fracoesDe15Minutos;
			
		}		
		else if(fracoesDe15Minutos >= 4 && fracoesDe15Minutos <=36) {
			return  (1 - this.estacionamentoAcessado.valorHoraCheia) * 
					(this.estacionamentoAcessado.valorFracao * fracoesDe15Minutos);
		}
		else {
			return this.estacionamentoAcessado.valorDiariaDiurna;
		}		
	}
}
