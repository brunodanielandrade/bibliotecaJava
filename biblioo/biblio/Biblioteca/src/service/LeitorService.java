package service;

import model.Leitor;
import model.Livro;
import java.util.ArrayList;

public class LeitorService {
    private static ArrayList<Leitor> livros = new ArrayList<>();

    public void cadastrarLeitor(Leitor l){
        livros.add(l);

    }
    public class Livro(ArrayList<Livro> livros) {
        System.out.println("Consulta de Livros na Biblioteca:");

        for (Livro livro : livros) {
            String status = livro.isDisponivel() ? "Disponível" : "Emprestado";
            System.out.println("- " + livro.getTitulo() + " (" + status + ")");
        }

        public String getTitulo() {
        }
    }

    public static void consultarLivroPorTitulo(ArrayList<Livro> livros, String titulo) {
        boolean encontrado = false;

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                String status = livro.isDisponivel() ? "Disponível" : "Emprestado";
                System.out.println("Livro encontrado: " + livro.getTitulo() + " (" + status + ")");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("O livro com o título '" + titulo + "' não foi encontrado na biblioteca.");

        }
    }

    }