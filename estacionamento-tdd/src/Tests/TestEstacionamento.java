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
	public void calculaValorAcessoHoraCheia() {
		int valorAcesso = estacionamento.calculaAcesso("Estacionamento1", "8:30", "9:30");
		assertEquals(valorAcesso, 102);
		
	}

}
