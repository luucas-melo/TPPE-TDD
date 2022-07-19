package Tests;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Main.DescricaoEmBrancoException;
import Main.Estacionamento;
import Main.ValorAcessoInvalidoException;

public class TesteDeExcecaoCadastroEstacionamento {

	@Test(expected=ValorAcessoInvalidoException.class)
	@Category(TesteDeExcecao.class)
	public void instanciaEstacionamentoComValorFracaoNegativo() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		new Estacionamento("Estacionamento1", -1f, 0.15f);
	}
	
	@Test(expected=DescricaoEmBrancoException.class)
	@Category(TesteDeExcecao.class)
	public void instanciaEstacionamentoComNomeEmBranco() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		new Estacionamento("", 30f, 0.15f);
	}

}
