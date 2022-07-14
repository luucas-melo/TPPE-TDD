package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Main.Acesso;
import Main.Estacionamento;

public class TesteAcessoNoturno {
	Estacionamento estacionamento;
	
	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento2", 20f, 0.10f, 70f, 0.30f, "21:00", "07:00");
		
	}
	
	@Test
	public void calculaValorAcessoNoturno() {
		Acesso acesso = new Acesso(estacionamento, "RM3A9", "21:36", "06:12");
		float valorAcesso = acesso.calculaAcesso();
		assertEquals(valorAcesso, 21f, 0.1f);
	}
}
