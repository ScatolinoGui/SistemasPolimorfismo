import java.text.NumberFormat;
import java.util.Locale;

public class SistemaFolhaPagamento {

    private static final double LUCRO_EMPRESA = 500000.00;
    private static final NumberFormat MOEDA = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));

    public static void main(String[] args) {

        Funcionario[] funcionarios = new Funcionario[6];

        funcionarios[0] = new Diretor("João Silva", "111.111.111-11", 15000.00, 2018, 10, 0.05);
        funcionarios[1] = new Gerente("Maria Santos", "222.222.222-22", 8000.00, 2020, 3);
        funcionarios[2] = new Gerente("Carlos Oliveira", "333.333.333-33", 9000.00, 2017, 8);
        funcionarios[3] = new Vendedor("Ana Costa", "444.444.444-44", 3000.00, 2022, 45000.00);
        funcionarios[4] = new Vendedor("Paulo Souza", "555.555.555-55", 3500.00, 2023, 25000.00);
        funcionarios[5] = new VendedorSenior("Fernanda Lima", "666.666.666-66", 5000.00, 2019, 180000.00);

        System.out.println("\n\n\n-x-x-x- FOLHA DE PAGAMENTO - OUTUBRO 2025 -x-x-x-");

        for (Funcionario f : funcionarios) {
            double comissao = 0.0;
            double participacaoLucros = 0.0;
            double bonus = f.calcularBonus();
            double adicionalTempo = f.calcularAdicionalTempoServico();
            double salarioTotal = f.calcularSalarioTotal();

            if (f instanceof FuncionarioComissionado) {
                comissao = ((FuncionarioComissionado) f).calcularComissao();
            }
            if (f instanceof Diretor) {
                participacaoLucros = ((Diretor) f).calcularParticipacaoLucros(LUCRO_EMPRESA);
                salarioTotal += participacaoLucros; // Adiciona PL ao total
            }
            System.out.println("=============X=============");
            System.out.println("Funcionário: " + f.getNome());
            System.out.println("Tipo: " + f.getClass().getSimpleName());
            System.out.println("Salário Base: " + formatarMoeda(f.getSalarioBase()));
            System.out.println("Bônus: " + formatarMoeda(bonus));
            System.out.println("Tempo de Empresa: " + f.calcularTempoEmpresa() + " anos");
            System.out.println("Adicional Tempo Serviço: " + formatarMoeda(adicionalTempo));
            if (f instanceof FuncionarioComissionado) {
                System.out.println("Comissão: " + formatarMoeda(comissao));
            }
            if (f instanceof Diretor) {
                System.out.println("Participação Lucros: " + formatarMoeda(participacaoLucros));
            }
            System.out.println("Salário Total: " + formatarMoeda(salarioTotal));
        }

        double folhaTotal = calcularFolhaTotal(funcionarios, LUCRO_EMPRESA);
        System.out.println("TOTAL DA FOLHA: " + formatarMoeda(folhaTotal));
        System.out.println("Final da Folha de Pagamento - Outubro 2025 \n=============X=============");
        encontrarMaiorSalario(funcionarios, LUCRO_EMPRESA);
    }

    public static double calcularFolhaTotal(Funcionario[] funcionarios, double lucroEmpresa) {
        double total = 0.0;
        for (Funcionario f : funcionarios) {
            double salarioDoFuncionario = f.calcularSalarioTotal();
            if (f instanceof Diretor) {
                salarioDoFuncionario += ((Diretor) f).calcularParticipacaoLucros(lucroEmpresa);
            }
            total += salarioDoFuncionario;
        }
        return total;
    }

    public static Funcionario encontrarMaiorSalario(Funcionario[] funcionarios, double lucroEmpresa) {
        Funcionario maiorSalarioFunc = null;
        double maiorSalarioValor = 0.0;

        for (Funcionario f : funcionarios) {
            double salarioDoFuncionario = f.calcularSalarioTotal();
            if (f instanceof Diretor) {
                salarioDoFuncionario += ((Diretor) f).calcularParticipacaoLucros(lucroEmpresa);
            }

            if (maiorSalarioFunc == null || salarioDoFuncionario > maiorSalarioValor) {
                maiorSalarioValor = salarioDoFuncionario;
                maiorSalarioFunc = f;
            }
        }

        if (maiorSalarioFunc != null) {
            System.out.println("MAIOR SALÁRIO: "
                + maiorSalarioFunc.getNome()
                + " (" + maiorSalarioFunc.getClass().getSimpleName() + ") - "
                + formatarMoeda(maiorSalarioValor));
        }
        
        return maiorSalarioFunc;
    }

    private static String formatarMoeda(double valor) {
        return MOEDA.format(valor);
    }
}
