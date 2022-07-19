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
import Main.DescricaoEmBrancoException;
import Main.Estacionamento;
import Main.ValorAcessoInvalidoException;

@RunWith(Parameterized.class)
@Category(TesteFuncional.class)
public class TesteAcessoEvento {

	private Estacionamento estacionamento;
	private Acesso acesso;
	private String nomeEstacionamento, entradaNoturna, retiradaNoturna, placa, tipoAcesso;
	private float valorFracao, valorHoraCheia, valorDiariaDiurna, porcentagemDiariaNoturna, valorAcessoMensalista,
	valorAcessoEvento, retornoContratante, valorCalculadoAcesso;
	private int capacidade;
		
	public TesteAcessoEvento(String nomeEstacionamento, float valorFracao, float valorHoraCheia, float valorDiariaDiurna, 
			float porcentagemDiariaNoturna,  String entradaNoturna, String retiradaNoturna, float valorAcessoMensalista, 
			float valorAcessoEvento, int capacidade, float retornoContratante, String placa,
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
		this.tipoAcesso = tipoAcesso;
		
		this.valorCalculadoAcesso = valorCalculadoAcesso;
	}
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
			{"Estacionamento1", 30f, 0.15f, 120f, 0.45f, "15-08-2022 19:00:00", "15-08-2022 08:00:00", 600f, 50f, 300, 0.5f, 
				"AM31J", "evento", 50f}, 
			{"Estacionamento2", 20f, 0.15f, 70f, 0.45f,"15-08-2022 21:00:00", "15-08-2022 07:00:00", 455f, 60f, 120, 0.6f, 
				"G49NG", "evento", 60f},
			{"Estacionamento3", 10f, 0f, 50f, 0.40f, "15-08-2022 20:00:00", "15-08-2022 08:00:00", 350f, 40f, 600, 0.7f, 
				"RM3A9", "evento", 40f},
		};
		
		return Arrays.asList(resposta);
	}
	
	@Before
	public void setup() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		
		estacionamento = new Estacionamento (nomeEstacionamento, valorFracao, valorHoraCheia,valorDiariaDiurna,
				porcentagemDiariaNoturna, entradaNoturna, retiradaNoturna, valorAcessoMensalista, valorAcessoEvento,
				capacidade,retornoContratante);
		
		acesso = new Acesso(estacionamento, placa, tipoAcesso);
		
	}
	
	@Test
	public void calculaValorAcessoEvento() {	
		float valorAcesso = this.acesso.calculaAcesso();
		assertEquals(valorAcesso, this.valorCalculadoAcesso, 0.1f);
	}

}
