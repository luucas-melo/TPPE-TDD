package Tests;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Main.Estacionamento;



public class TestEstacionamento {
	
	Estacionamento estacionamento;
	
	
	@Before
	public void setup() {
		estacionamento = new Estacionamento();
		estacionamento.cadastraEstacionamento("Estacionamento1", 30f, 0.15f);
	}
	
	@Test
	public void calculaValorAcesso1HoraCheia() {
		float valorAcesso = estacionamento.calculaAcesso("Estacionamento1", "08:30:00", "09:30:00");
		assertEquals(valorAcesso, 102f, 0.1f);
		
	}
	
	@Test
	public void calculaValorAcesso2HoraCheia() {
		float valorAcesso = estacionamento.calculaAcesso("Estacionamento1", "08:00:00", "10:00:00");
		assertEquals(valorAcesso, 204f, 0.1f);
		
	}

}
