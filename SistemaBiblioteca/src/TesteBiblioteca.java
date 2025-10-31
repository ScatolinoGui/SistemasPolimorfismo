public class TesteBiblioteca {

    public static void main(String[] args) {

        ItemBiblioteca[] itens = new ItemBiblioteca[5];

        itens[0] = new Livro("O Senhor dos Anéis", "L001", 10, 1200);
        itens[1] = new Livro("Java para Iniciantes", "L002", 5, 250);
        itens[2] = new Revista("Veja", "R001", 5, 2550);
        itens[3] = new Livro("1984", "L003", 15, 350);
        itens[4] = new Revista("National Geographic", "R002", 2, 120);

        double totalMultas = 0.0;
        double maiorMulta = 0.0;
        ItemBiblioteca itemMaiorMulta = null;
        int totalAtrasados = 0;

        System.out.println("===== PROCESSANDO ITENS DA BIBLIOTECA =====");

        for (ItemBiblioteca item : itens) {
            
            item.exibirInfo();

            if (item.estaAtrasado()) {
                System.out.println("Status: ATRASADO");
                totalAtrasados++;
            } else {
                System.out.println("Status: Em dia");
            }

            double multa = item.calcularMulta();
            System.out.printf("Multa: R$ %.2f\n", multa);

            totalMultas += multa;

            if (multa > maiorMulta) {
                maiorMulta = multa;
                itemMaiorMulta = item; 
            }

            System.out.println("----------------------------------------");
        }

        System.out.println("\n===== RESUMO FINAL =====");
        System.out.printf("TOTAL DE MULTAS: R$ %.2f\n", totalMultas);
        System.out.println("TOTAL DE ITENS ATRASADOS: " + totalAtrasados);

        if (itemMaiorMulta != null) {
            System.out.printf("MAIOR MULTA: %s - R$ %.2f\n",
                    itemMaiorMulta.getTitulo(), maiorMulta);
        } else {
            System.out.println("Nenhum item gerou multa.");
        }
    }
}
