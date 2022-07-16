package Tests;

import static org.junit.Assert.*;

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
public class TesteAcessoFracao {

	private Estacionamento estacionamento;
	private Acesso acesso;
	private String nomeEstacionamento, entradaNoturna, retiradaNoturna, placa, horaEntrada, horaSaida, tipoAcesso;
	private float valorFracao, valorHoraCheia, valorDiariaDiurna, porcentagemDiariaNoturna, valorAcessoMensalista,
	valorAcessoEvento, retornoContratante, valorCalculadoAcesso;
	private int capacidade;
		
	public TesteAcessoFracao(String nomeEstacionamento, float valorFracao, float valorHoraCheia, float valorDiariaDiurna, 
			float porcentagemDiariaNoturna,  String entradaNoturna, String retiradaNoturna, float valorAcessoMensalista, 
			float valorAcessoEvento, int capacidade, float retornoContratante, String placa, String horaEntrada, String horaSaida,
			String tipoAcesso, float valorCalculadoAcesso){
		
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
		
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.tipoAcesso = tipoAcesso;
		
		this.valorCalculadoAcesso = valorCalculadoAcesso;
	}
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
			{"Estacionamento1", 30f, 0.15f, 120f, 0.45f, "15-08-2022 19:00:00", "15-08-2022 08:00:00", 600f, 50f, 300, 0.5f, 
				"AM31J", "15-08-2022 10:00:00", "15-08-2022 10:43:00", "", 90f}, 
			{"Estacionamento1", 30f, 0.15f, 120f, 0.45f, "15-08-2022 19:00:00", "15-08-2022 08:00:00", 600f, 50f, 300, 0.5f, 
				"AM31J", "15-08-2022 10:00:00", "15-08-2022 10:30:00", "", 60f},
			{"Estacionamento1", 30f, 0.15f, 120f, 0.45f, "15-08-2022 19:00:00", "15-08-2022 08:00:00", 600f, 50f, 300, 0.5f, 
				"AM31J", "15-08-2022 10:00:00", "15-08-2022 10:14:00", "", 30f},
		};
		
		return Arrays.asList(resposta);
	}
	
	@Before
	public void setup() {
		
		estacionamento = new Estacionamento (nomeEstacionamento, valorFracao, valorHoraCheia,valorDiariaDiurna,
				porcentagemDiariaNoturna, entradaNoturna, retiradaNoturna, valorAcessoMensalista, valorAcessoEvento,
				capacidade,retornoContratante);
		
		acesso = new Acesso(estacionamento, placa, horaEntrada, horaSaida, tipoAcesso);
		
	}
	
	@Test
	public void calculaValorContratante() {	
		float valorAcesso = this.acesso.calculaAcesso();
		assertEquals(valorAcesso, this.valorCalculadoAcesso, 0.1f);
	}
}
