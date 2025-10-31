public abstract class Funcionario {
    
    // Atributos comuns
    protected String nome;
    protected String cpf;
    protected double salarioBase;
    protected int anoContratacao;

    public Funcionario(String nome, String cpf, double salarioBase, int anoContratacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
        this.anoContratacao = anoContratacao;
    }

    public abstract double calcularSalarioTotal();

    public abstract double calcularBonus();

    public int calcularTempoEmpresa() {
        return 2025 - this.anoContratacao;
    }

    public double calcularAdicionalTempoServico() {
        return this.calcularTempoEmpresa() * (this.salarioBase * 0.02);
    }
    
    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
