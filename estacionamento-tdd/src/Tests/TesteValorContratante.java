package Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Main.Acesso;
import Main.Estacionamento;

@RunWith(Parameterized.class)
@Category(TesteFuncional.class)
public class TesteValorContratante {

	private Estacionamento estacionamento;
	Object[][] acessos;
	private String nomeEstacionamento, entradaNoturna, retiradaNoturna;
	private float valorFracao, valorHoraCheia, valorDiariaDiurna, porcentagemDiariaNoturna, valorAcessoMensalista,
	valorAcessoEvento, retornoContratante, totalContratante;
	private int capacidade;
	
	public TesteValorContratante(String nomeEstacionamento, float valorFracao, float valorHoraCheia, float valorDiariaDiurna, 
			float porcentagemDiariaNoturna,  String entradaNoturna, String retiradaNoturna, float valorAcessoMensalista, 
			float valorAcessoEvento, int capacidade, float retornoContratante, Object[][] acessos, float totalContratante) {
		
		this.nomeEstacionamento = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		this.valorDiariaDiurna = valorDiariaDiurna;
		this.porcentagemDiariaNoturna = porcentagemDiariaNoturna;
		this.entradaNoturna =  entradaNoturna;
		this.retiradaNoturna = retiradaNoturna;
		this.valorAcessoMensalista = valorAcessoMensalista;
		this.valorAcessoEvento = valorAcessoEvento;
		this.capacidade = capacidade;
		this.retornoContratante = retornoContratante;
		
		this.acessos = acessos;
		this.totalContratante = totalContratante;
	}
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[] acesso1 = new Object[] {"AM31J", "", "", "evento"};
		Object[] acesso2 = new Object[] {"AM31J", "15-08-2022 08:00:00", "15-08-2022 18:00:00", ""};
		Object[] acesso3 = new Object[] {"AM31J", "15-08-2022 10:00:00", "15-08-2022 10:43:00", ""};
		
		Object[][] resposta = new Object[][] {
			{"Estacionamento1", 30f, 0.15f, 120f, 0.45f, "15-08-2022 19:00:00", "15-08-2022 08:00:00", 600f, 50f, 300, 0.5f, 
				new Object[][]{
					acesso1,
					acesso2,
					acesso3},130f}, 
			{"Estacionamento2", 20f, 0.15f, 120f, 0.45f,"15-08-2022 21:00:00", "15-08-2022 07:00:00", 455f, 60f, 120, 0.6f, 
				new Object[][]{
					acesso1,
					acesso2,
					acesso3},144f},
			{"Estacionamento3", 10f, 0f, 50f, 0.40f, "15-08-2022 20:00:00", "15-08-2022 08:00:00", 350f, 40f, 600, 0.7f,
				new Object[][]{
					acesso1,
					acesso2,
					acesso3},84f},
		};
		
		return Arrays.asList(resposta);
	}
	
	
	@Before
	public void setup() {
		
		estacionamento = new Estacionamento (nomeEstacionamento, valorFracao, valorHoraCheia,valorDiariaDiurna,
				porcentagemDiariaNoturna, entradaNoturna, retiradaNoturna, valorAcessoMensalista, valorAcessoEvento,
				capacidade,retornoContratante);
	}
	
	@Test
	public void calculaValorContratante() {
		
		ArrayList<Acesso> listaAcessos = new ArrayList<>();
		
		for (Object[] acesso: acessos) {
			listaAcessos.add(new Acesso(this.estacionamento, (String)acesso[0], 
							(String)acesso[1], (String)acesso[2], (String)acesso[3]));
		}
		
		
		float valorContratante = this.estacionamento.calculaValorContratante(listaAcessos);
		assertEquals(valorContratante, this.totalContratante, 0.1f);
	}
}
