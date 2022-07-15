package Tests;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Main.Acesso;
import Main.Estacionamento;


@RunWith(Parameterized.class)
public class TesteAcessoHoraCheia {
	
	Estacionamento estacionamento;
	private String placa, horaEntrada, horaSaida;
	private float valorCalculadoAcesso;
	private Acesso acesso;
	
	@Before
	public void setup() {
		estacionamento = new Estacionamento("Estacionamento1", 30f, 0.15f, 120f, 0.45f, "15-08-2022 19:00:00", "15-08-2022 08:00:00");
		acesso = new Acesso(estacionamento, placa, horaEntrada, horaSaida);
	}
	
	public TesteAcessoHoraCheia(String placa, String horaEntrada, String horaSaida, float valorCalculadoAcesso) {
		this.placa = placa; 
		this.horaEntrada = horaEntrada; 
		this.horaSaida = horaSaida;
		this.valorCalculadoAcesso = valorCalculadoAcesso;
	}
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
			{"HI139", "15-08-2022 08:30:00", "15-08-2022 09:30:00", 102f}, 
			{"HI139", "15-08-2022 08:00:00", "15-08-2022 10:00:00", 204f}, 
			{"HI139", "15-08-2022 08:00:00", "15-08-2022 11:00:00", 306f}, 
		};
		
		return Arrays.asList(resposta);
	}
	
	@Test
	public void calculaValorAcessoHoraCheia() {
		
		float valorAcesso = this.acesso.calculaAcesso();
		assertEquals(valorCalculadoAcesso, valorAcesso, 0.1f);
	}
	

}
