public class Revista extends ItemBiblioteca {

    private int edicao;

    public Revista(String titulo, String codigo, int diasEmprestado, int edicao) {
        super(titulo, codigo, diasEmprestado);
        this.edicao = edicao;
    }

    @Override
    public boolean estaAtrasado() {
        return this.diasEmprestado > 3;
    }

    @Override
    public double calcularMulta() {
        if (!this.estaAtrasado()) {
            return 0.0;
        }

        // Calcula os dias de atraso
        int diasAtraso = this.diasEmprestado - 3;

        // Taxa fixa para revistas
        double taxaDiaria = 1.00;

        return diasAtraso * taxaDiaria;
    }
}
