package Main;

public class Acesso {
	
	String placa, horaEntrada, horaSaida;
	Estacionamento estacionamentoAcessado;
	String tipoAcesso;
	
	public Acesso(Estacionamento estacionamento, String placa, String horaEntrada, String horaSaida) throws DescricaoEmBrancoException {
		if (placa == null || placa.equals("")) {
            throw new DescricaoEmBrancoException("Dados da placa nulo ou vazio");
        }
		
		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.estacionamentoAcessado = estacionamento;
	}
	
	public Acesso(Estacionamento estacionamento, String placa, String horaEntrada, String horaSaida, String tipoAcesso) throws DescricaoEmBrancoException {
		if (placa == null || placa.equals("")) {
            throw new DescricaoEmBrancoException("Dados da placa nulo ou vazio");
        }

		this.placa = placa;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.estacionamentoAcessado = estacionamento;
		this.tipoAcesso = tipoAcesso;
	}
	
	public Acesso(Estacionamento estacionamento, String placa, String tipoAcesso) throws DescricaoEmBrancoException {
		if (placa == null || placa.equals("")) {
            throw new DescricaoEmBrancoException("Dados da placa nulo ou vazio");
        }

		this.placa = placa;
		this.estacionamentoAcessado = estacionamento;
		this.tipoAcesso = tipoAcesso;
	}
	
	public float calculaAcesso() {
		if(tipoAcesso != null) {
			if(tipoAcesso.equals("evento")) {
				return estacionamentoAcessado.valorAcessoEvento;
			}
			else if(tipoAcesso.equals("mensalista")) {
				return estacionamentoAcessado.valorAcessoMensalista;
			}
		}
		
		Calculadora calculadora = new Calculadora(this.horaEntrada, this.horaSaida);
		
		return calculadora.calculaAcesso(this.estacionamentoAcessado);
	}
}
