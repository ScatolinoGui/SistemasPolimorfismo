public abstract class FuncionarioComissionado extends Funcionario {

    protected double totalVendas;

    public FuncionarioComissionado(String nome, String cpf, double salarioBase, int anoContratacao, double totalVendas) {
        super(nome, cpf, salarioBase, anoContratacao);
        this.totalVendas = totalVendas;
    }

    public abstract double calcularComissao();
}
