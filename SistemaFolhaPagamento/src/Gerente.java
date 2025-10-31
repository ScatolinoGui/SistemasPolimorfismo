public class Gerente extends Funcionario {

    protected int numeroSubordinados;

    public Gerente(String nome, String cpf, double salarioBase, int anoContratacao, int numeroSubordinados) {
        super(nome, cpf, salarioBase, anoContratacao);
        this.numeroSubordinados = numeroSubordinados;
    }

    @Override
    public double calcularBonus() {
        return (this.salarioBase * 0.20) + (this.numeroSubordinados * 500);
    }

    protected double calcularBeneficioAdicional() {
        if (this.calcularTempoEmpresa() > 5) {
            return this.salarioBase * 0.10;
        }
        return 0.0;
    }

    @Override
    public double calcularSalarioTotal() {
        return this.salarioBase 
             + this.calcularBonus() 
             + this.calcularAdicionalTempoServico()
             + this.calcularBeneficioAdicional();
    }
}
