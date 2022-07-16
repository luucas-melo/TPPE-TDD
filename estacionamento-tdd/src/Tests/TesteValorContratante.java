package Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Main.Acesso;
import Main.Estacionamento;

public class TesteValorContratante {

	private Estacionamento estacionamento;
	private Estacionamento estacionamento2;
	private Estacionamento estacionamento3;
	
	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento1", 30f, 0.15f, 120f, 0.45f, 
				"15-08-2022 19:00:00", "15-08-2022 08:00:00", 600f, 50f, 300, 0.5f);
		estacionamento2 = new Estacionamento("Estacionamento2", 20f, 0.15f, 120f, 0.45f, 
				"15-08-2022 21:00:00", "15-08-2022 07:00:00", 455f, 60f, 120, 0.6f);
		estacionamento3 = new Estacionamento("Estacionamento3", 10f, 0f, 50f, 0.40f, 
				"15-08-2022 20:00:00", "15-08-2022 08:00:00", 350f, 40f, 600, 0.7f);
	}
	
	@Test
	public void calculaValorContratante() {
		
		Acesso acesso1 = new Acesso(estacionamento, "AM31J", "", "", "evento");
		Acesso acesso2 = new Acesso(estacionamento, "AM31J", "15-08-2022 08:00:00", "15-08-2022 18:00:00", "");
		Acesso acesso3 = new Acesso(estacionamento, "AM31J", "15-08-2022 10:00:00", "15-08-2022 10:43:00", "");
		
		ArrayList<Acesso> listaAcessos = new ArrayList<>();
		listaAcessos.add(acesso1);
		listaAcessos.add(acesso2);
		listaAcessos.add(acesso3);
		
		float valorContratante = this.estacionamento.calculaValorContratante(listaAcessos);
		System.out.print(valorContratante);
		assertEquals(valorContratante, 130f, 0.1f);
	}
	
	@Test
	public void calculaValorContratante2() {
		
		Acesso acesso1 = new Acesso(estacionamento2, "AM31J", "", "", "evento");
		Acesso acesso2 = new Acesso(estacionamento2, "AM31J", "15-08-2022 08:00:00", "15-08-2022 18:00:00", "");
		Acesso acesso3 = new Acesso(estacionamento2, "AM31J", "15-08-2022 10:00:00", "15-08-2022 10:43:00", "");
		
		ArrayList<Acesso> listaAcessos = new ArrayList<>();
		listaAcessos.add(acesso1);
		listaAcessos.add(acesso2);
		listaAcessos.add(acesso3);
		
		float valorContratante = this.estacionamento2.calculaValorContratante(listaAcessos);
		System.out.print(valorContratante);
		assertEquals(valorContratante, 144f, 0.1f);
	}
	
	@Test
	public void calculaValorContratante3() {
		
		Acesso acesso1 = new Acesso(estacionamento3, "AM31J", "", "", "evento");
		Acesso acesso2 = new Acesso(estacionamento3, "AM31J", "15-08-2022 08:00:00", "15-08-2022 18:00:00", "");
		Acesso acesso3 = new Acesso(estacionamento3, "AM31J", "15-08-2022 10:00:00", "15-08-2022 10:43:00", "");
		
		ArrayList<Acesso> listaAcessos = new ArrayList<>();
		listaAcessos.add(acesso1);
		listaAcessos.add(acesso2);
		listaAcessos.add(acesso3);
		
		float valorContratante = this.estacionamento3.calculaValorContratante(listaAcessos);
		System.out.print(valorContratante);
		assertEquals(valorContratante, 84f, 0.1f);
	}
}
