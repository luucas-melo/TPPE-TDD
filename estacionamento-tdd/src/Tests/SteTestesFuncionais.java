package Tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ TesteAcessoHoraCheia.class, 
				TesteAcessoNoturno.class, 
				TesteValorContratante.class,
				TesteAcessoFracao.class,
				TesteAcessoDiurno.class,
				TesteAcessoMensalista.class,
				TesteAcessoEvento.class})
@IncludeCategory(TesteFuncional.class)
public class SteTestesFuncionais {

}
