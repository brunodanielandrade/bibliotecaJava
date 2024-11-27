import model.*;
import service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeitorService ls = new LeitorService();
        EmprestimoService emprestimoService = new EmprestimoService();
        LivroService livroService;
        livroService = new LivroService();
        ArrayList<Livro> livros = new ArrayList<>();

        inicializarLivros(livros);

        int opcao;

        do {
            System.out.println("\n=== Sistema de Biblioteca ===");
            System.out.println("1. Cadastrar Leitor");
            System.out.println("2. Consultar Livros");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Consultar Empréstimos");
            System.out.println("5. Listar Leitores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Leitor l = new Leitor();
                    ls.cadastrarLeitor(l);
                    break;

                case 2:
                    livroService.consultarLivros(livros);
                    break;

                case 3:
                    System.out.println("Digite o nome do leitor:");
                    String nomeLeitor = scanner.nextLine();
                    Leitor leitor = ls.buscarLeitorPorNome(nomeLeitor);

                    if (leitor == null) {
                        System.out.println("Leitor não encontrado.");
                        break;
                    }

                    System.out.println("Livros disponíveis para empréstimo:");
                    livroService.consultarLivros(livros);

                    System.out.println("Digite o título do livro que deseja emprestar:");
                    String tituloLivro = scanner.nextLine();

                    Livro livro = livros.stream()
                            .filter(l -> l.getTitulo().equalsIgnoreCase(tituloLivro) && l.isDisponivel())
                            .findFirst()
                            .orElse(null);

                    if (livro == null) {
                        System.out.println("Livro não encontrado ou não está disponível.");
                    } else {
                        emprestimoService.realizarEmprestimo(livro, leitor);
                    }
                    break;

                case 4:
                    emprestimoService.listarEmprestimos();
                    break;

                case 5:
                    ls.listarLeitores();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void inicializarLivros(ArrayList<Livro> livros) {
        livros.add(new Livro("O Senhor dos Anéis"));
        livros.add(new Livro("Dom Casmurro"));
        livros.add(new Livro("Harry Potter e a Pedra Filosofal"));
        System.out.println("Livros inicializados com sucesso!");
    }
}
