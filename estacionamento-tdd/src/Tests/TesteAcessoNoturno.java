package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Main.Acesso;
import Main.Estacionamento;

public class TesteAcessoNoturno {
	Estacionamento estacionamento1, estacionamento2, estacionamento3;
	
	@Before
	public void setup() {
		estacionamento1 = new Estacionamento("Estacionamento1", 30f, 0.15f, 120f, 0.45f, "15-08-2022 19:00:00", "15-08-2022 08:00:00");
		estacionamento2 = new Estacionamento("Estacionamento2", 20f, 0.10f, 70f, 0.30f, "15-08-2022 21:00:00", "15-08-2022 07:00:00");	
		//estacionamento3 = new Estacionamento("Estacionamento3", 10f, 0f, 50f, 0.40f, "15-08-2022 20:00:00", "15-08-2022 08:00:00");	
	}
	
	@Test
	public void calculaValorAcessoNoturno1() {
		Acesso acesso = new Acesso(estacionamento2, "RM3A9", "15-08-2022 21:36:00", "15-08-2022 06:12:00");
		float valorAcesso = acesso.calculaAcesso();
		assertEquals(valorAcesso, 21f, 0.1f);
	}
	
	@Test
	public void calculaValorAcessoNoturno2() {
		Acesso acesso = new Acesso(estacionamento1, "RM3A9", "15-08-2022 19:00:00", "15-08-2022 08:00:00");
		float valorAcesso = acesso.calculaAcesso();
		assertEquals(valorAcesso, 54f, 0.1f);
	}
}
