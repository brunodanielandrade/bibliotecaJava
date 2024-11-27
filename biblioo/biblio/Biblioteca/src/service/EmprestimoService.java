package service;

import java.util.ArrayList;
import model.*;

public class EmprestimoService {


    private static ArrayList<Pessoa> leitores = new ArrayList<>();
    private static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public void realizarEmprestimo(Livro livro, Pessoa leitor) {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false); // Marca o livro como emprestado
            Emprestimo emprestimo = new Emprestimo(livro, leitor);
            emprestimos.add(emprestimo); // Armazena o empréstimo
            System.out.println("Empréstimo realizado com sucesso!");
            System.out.println("Livro: " + livro.getTitulo());
            System.out.println("Leitor: " + leitor.getNome());
            System.out.println("Data do Empréstimo: " + emprestimo.getDataEmprestimo());
        } else {
            System.out.println("O livro '" + livro.getTitulo() + "' já está emprestado.");
        }
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado.");
        } else {
            System.out.println("Lista de Empréstimos:");
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("- Livro: " + emprestimo.getLivro().getTitulo() +
                        ", Leitor: " + emprestimo.getLeitor().getNome() +
                        ", Data: " + emprestimo.getDataEmprestimo());
            }
        }
    }

}
