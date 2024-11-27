package model;
import java.util.Scanner;
import java.time.LocalDate;

public class Emprestimo {

        private Livro livro;
        private Pessoa leitor;
        private LocalDate dataEmprestimo;

        public Emprestimo(Livro livro, Pessoa leitor) {
            this.livro = livro;
            this.leitor = leitor;
            this.dataEmprestimo = LocalDate.now();
        }

        public Livro getLivro() {
            return livro;
        }

        public Pessoa getLeitor() {
            return leitor;
        }

        public LocalDate getDataEmprestimo() {
            return dataEmprestimo;
        }

        public LocalDate getDataDevolucao() {
            return dataEmprestimo.plusDays(14);
        }

}

public Livro getLivro() {
    return livro;
}

public Pessoa getLeitor() {
    return leitor;
}

public LocalDate getDataEmprestimo() {
    return dataEmprestimo;
}

public void realizarEmprestimo(Livro[] livrosDisponiveis, Pessoa leitor) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Livros disponíveis:");
    for (int i = 0; i < livrosDisponiveis.length; i++) {
        if (livrosDisponiveis[i].isDisponivel()) {
            System.out.println((i + 1) + ". " + livrosDisponiveis[i].getTitulo());
        }
    }

    System.out.print("\nEscolha o número do livro que deseja emprestar: ");
    int escolha = scanner.nextInt();

    if (escolha > 0 && escolha <= livrosDisponiveis.length && livrosDisponiveis[escolha - 1].isDisponivel()) {
        Livro livroEscolhido = livrosDisponiveis[escolha - 1];
        livroEscolhido.setDisponivel(false);
        Emprestimo emprestimo = new Emprestimo(livroEscolhido, leitor);
        System.out.println("Empréstimo realizado com sucesso!");
        System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
        System.out.println("Leitor: " + emprestimo.getLeitor().getNome());
        System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
    } else {
        System.out.println("Opção inválida ou livro indisponível.");
    }

    scanner.close();
}

public void main() {
}