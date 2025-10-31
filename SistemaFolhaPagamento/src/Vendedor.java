public class Vendedor extends FuncionarioComissionado {

    public Vendedor(String nome, String cpf, double salarioBase, int anoContratacao, double totalVendas) {
        super(nome, cpf, salarioBase, anoContratacao, totalVendas);
    }

    @Override
    public double calcularComissao() {
        if (this.totalVendas < 50000) {
            return this.totalVendas * 0.05;
        } else {
            return this.totalVendas * 0.08;
        }
    }

    @Override
    public double calcularBonus() {
        if (this.totalVendas >= 30000) {
            return this.salarioBase * 0.15;
        }
        return 0.0;
    }

    protected double calcularBeneficioAdicional() {
        if (this.totalVendas >= 100000) {
            return 1000.0;
        }
        return 0.0;
    }

    @Override
    public double calcularSalarioTotal() {
        return this.salarioBase
             + this.calcularComissao()
             + this.calcularBonus()
             + this.calcularAdicionalTempoServico()
             + this.calcularBeneficioAdicional();
    }
}
