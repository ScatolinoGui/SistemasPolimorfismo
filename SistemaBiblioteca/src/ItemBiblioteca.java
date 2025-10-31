public abstract class ItemBiblioteca {

    // Atributos comuns a todos os itens
    protected String titulo;
    protected String codigo;
    protected int diasEmprestado;

    /**
     * Construtor para inicializar os atributos comuns.
     */
    public ItemBiblioteca(String titulo, String codigo, int diasEmprestado) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.diasEmprestado = diasEmprestado;
    }

    // --- Métodos Abstratos ---
    // Forçam as subclasses (Livro, Revista) a implementarem suas próprias regras.

    public abstract double calcularMulta();

    public abstract boolean estaAtrasado();

    // --- Métodos Concretos ---

    public void exibirInfo() {
        System.out.println("Item: " + this.titulo);
        System.out.println("Código: " + this.codigo);
        System.out.println("Dias emprestado: " + this.diasEmprestado);
    }

    public String getTitulo() {
        return titulo;
    }
}
