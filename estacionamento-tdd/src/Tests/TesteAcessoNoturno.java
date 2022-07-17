package Tests;


import static org.junit.Assert.assertEquals;

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
public class TesteAcessoNoturno {
	
	private String nome;
	private float valorFracao, valorHoraCheia, valorDiariaDiurna;
	private float porcentagemDiariaNoturna;
	private String entradaNoturna, retiradaNoturna;
	
	private Estacionamento estacionamento;
	private String placa, horaEntrada, horaSaida;
	private float valorCalculadoAcesso;
	private Acesso acesso;
	
	@Before
	public void setup() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		estacionamento = new Estacionamento(nome, valorFracao, valorHoraCheia, 
				valorDiariaDiurna, porcentagemDiariaNoturna, entradaNoturna, retiradaNoturna);
		acesso = new Acesso(estacionamento, placa, horaEntrada, horaSaida);
	}
	
	public TesteAcessoNoturno(String nomeEstacionamento, float valorFracao, float valorHoraCheia, 
			float valorDiariaDiurna, float porcentagemDiariaNoturna,  
			String entradaNoturna, String retiradaNoturna, String placa, String horaEntrada, 
			String horaSaida, float valorCalculadoAcesso) {
		this.nome = nomeEstacionamento;
		this.valorFracao = valorFracao;
		this.valorHoraCheia = valorHoraCheia;
		this.valorDiariaDiurna = valorDiariaDiurna;
		this.porcentagemDiariaNoturna = porcentagemDiariaNoturna;
		this.entradaNoturna =  entradaNoturna;
		this.retiradaNoturna = retiradaNoturna;
		
		this.placa = placa; 
		this.horaEntrada = horaEntrada; 
		this.horaSaida = horaSaida;
		this.valorCalculadoAcesso = valorCalculadoAcesso;
	}
	
	@Parameters
	public static Iterable<Object[]> getParameters() {
		Object[][] resposta = new Object[][] {
			{"Estacionamento1", 30f, 0.15f, 120f, 0.45f, "15-08-2022 19:00:00", "15-08-2022 08:00:00", "RM3A9", "15-08-2022 19:00:00", "16-08-2022 08:00:00", 54f}, 
			{"Estacionamento2", 20f, 0.10f, 70f, 0.30f, "15-08-2022 21:00:00", "15-08-2022 07:00:00", "RM3A9", "15-08-2022 21:36:00", "16-08-2022 06:12:00", 21f},
			{"Estacionamento3", 10f, 0f, 50f, 0.40f, "15-08-2022 20:00:00", "15-08-2022 08:00:00", "RM3A9", "15-08-2022 20:00:00", "16-08-2022 08:00:00", 20f}
		};
		
		return Arrays.asList(resposta);
	}
	
	@Test
	public void calculaValorAcessoNoturno() {
		
		float valorAcesso = this.acesso.calculaAcesso();
		assertEquals(valorCalculadoAcesso, valorAcesso, 0.1f);
	}
}

