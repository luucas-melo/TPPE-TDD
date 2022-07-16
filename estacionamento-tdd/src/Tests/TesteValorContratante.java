package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Main.Acesso;
import Main.Estacionamento;

public class TesteValorContratante {

	private Estacionamento estacionamento;
	
	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento1", 30f, 0.15f, 120f, 0.45f, "15-08-2022 19:00:00", "15-08-2022 08:00:00");
	}
	
	@Test
	public void calculaValorContratante() {
		
		Acesso acesso1 = new Acesso(estacionamento, "AM31J", "", "", "evento");
		Acesso acesso2 = new Acesso(estacionamento, "AM31J", "15-08-2022 08:00:00", "15-08-2022 18:00:00", "");
		Acesso acesso3 = new Acesso(estacionamento, "AM31J", "15-08-2022 10:00:00", "15-08-2022 10:43:00", "");
		
		float valorContratante = this.estacionamento.calculaValorContratante();
		assertEquals(valorContratante, 130f, 0f);
	}
}
