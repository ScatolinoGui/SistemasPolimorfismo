public class Livro extends ItemBiblioteca {

    // Atributo específico de Livro
    private int numeroPaginas;

    public Livro(String titulo, String codigo, int diasEmprestado, int numeroPaginas) {
        super(titulo, codigo, diasEmprestado);
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public boolean estaAtrasado() {
        return this.diasEmprestado > 7;
    }

    @Override
    public double calcularMulta() {
        if (!this.estaAtrasado()) {
            return 0.0;
        }

        int diasAtraso = this.diasEmprestado - 7;

        double taxaDiaria = 2.00;

        if (this.numeroPaginas > 300) {
            taxaDiaria = 3.00;
        }

        return diasAtraso * taxaDiaria;
    }
}
