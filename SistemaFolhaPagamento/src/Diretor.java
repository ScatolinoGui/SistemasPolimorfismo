public class Diretor extends Gerente {

    private double participacaoLucros;

    public Diretor(String nome, String cpf, double salarioBase, int anoContratacao, int numeroSubordinados, double participacaoLucros) {
        super(nome, cpf, salarioBase, anoContratacao, numeroSubordinados);
        this.participacaoLucros = participacaoLucros;
    }

    public double calcularParticipacaoLucros(double lucroEmpresa) {
        return lucroEmpresa * this.participacaoLucros;
    }

    @Override
    public double calcularBonus() {
        return super.calcularBonus() + (this.salarioBase * 0.30);
    }

    @Override
    public double calcularSalarioTotal() {
        return super.calcularSalarioTotal();
    }
}
