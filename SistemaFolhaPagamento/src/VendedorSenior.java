public class VendedorSenior extends Vendedor {

	public VendedorSenior(String nome, String cpf, double salarioBase, int anoContratacao, double totalVendas) {
		super(nome, cpf, salarioBase, anoContratacao, totalVendas);
	}

	@Override
	public double calcularComissao() {
		if (this.totalVendas < 50000) {
			return this.totalVendas * 0.10;
		}
		return this.totalVendas * 0.15;
	}

	@Override
	public double calcularBonus() {
		return super.calcularBonus() + (this.salarioBase * 0.05);
	}

	@Override
	protected double calcularBeneficioAdicional() {
		double beneficio = super.calcularBeneficioAdicional();
		if (this.calcularTempoEmpresa() > 3) {
			beneficio += 2000.0;
		}
		return beneficio;
	}

	public double calcularBonusLideranca() {
		if (this.totalVendas > 150000) {
			return 3000.0;
		}
		return 0.0;
	}

	@Override
	public double calcularSalarioTotal() {
		return this.salarioBase
			 + this.calcularComissao()
			 + this.calcularBonus()
			 + this.calcularAdicionalTempoServico()
			 + this.calcularBeneficioAdicional()
			 + this.calcularBonusLideranca();
	}
}
