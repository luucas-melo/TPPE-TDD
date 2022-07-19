package Tests;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import Main.Acesso;
import Main.DescricaoEmBrancoException;
import Main.Estacionamento;
import Main.ValorAcessoInvalidoException;

public class TesteDeExcecaoCadastroAcesso {

	@Test(expected=DescricaoEmBrancoException.class)
	@Category(TesteDeExcecao.class)
	public void instanciaAcessoComPlacaEmBranco() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		Estacionamento estacionamento = new Estacionamento("Estacionamento1", 30f, 0.15f);
		new Acesso(estacionamento, "", "15-08-2022 10:00:00", "15-08-2022 19:30:00", "");
	}
	
	@Test(expected=DescricaoEmBrancoException.class)
	@Category(TesteDeExcecao.class)
	public void instanciaAcessoComPlacaNulo() throws DescricaoEmBrancoException, ValorAcessoInvalidoException {
		Estacionamento estacionamento = new Estacionamento("Estacionamento1", 30f, 0.15f);
		new Acesso(estacionamento, null, "15-08-2022 10:00:00", "15-08-2022 19:30:00", "");
	}

}
