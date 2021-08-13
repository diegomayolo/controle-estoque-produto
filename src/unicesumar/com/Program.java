package unicesumar.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Program {

	private static List<Produto> list;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		list = new ArrayList<>();

		menuPrincipal();
	}

	// TELA 1.0 MENU PRINCIPAL
	private static void menuPrincipal() {
		System.out.print("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n" + "SISTEMA DE CONTROLE DE ESTOQUE\n\n"
				+ "MENU PRINCIPAL\n" + "0 - FINALIZAR\n" + "1 - CADASTRO DE PRODUTOS\n" + "2 - MOVIMENTAÇÃO\n"
				+ "3 - REAJUSTE DE PREÇOS\n" + "4 - RELATÓRIOS\n" + "OPÇÃO: _");

		Scanner sc = new Scanner(System.in);
		int opcao = sc.nextInt();
		switch (opcao) {
		case 0:
			exit();
			break;
		case 1:
			cadastroProdutos();
			break;
		case 2:
			System.out.println("\nMOVIMENTAÇÃO");
			break;
		case 3:
			System.out.println("\nREAJUSTE");
			break;
		case 4:
			System.out.println("\nRELATÓRIOS");
			break;
		default:
			System.out.println("\nDIGITE SOMENTE NÚMEROS ENTRE 0 E 4\n\n");
			menuPrincipal();
			break;
		}
		sc.close();
	}

//0 - FINALIZAR
	private static void exit() {
		System.out.println("PROGRAMA FINALIZADO.");
	}

//TELA 1.1 - CADASTRO DE PRODUTOS
	private static void cadastroProdutos() {
		System.out.println();
		System.out.print("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n" + "SISTEMA DE CONTROLE DE ESTOQUE\n\n"
				+ "CADASTRO DE PRODUTOS\n" + "0 - RETORNAR\n" + "1 - INCLUSÃO\n" + "2 - ALTERAÇÃO\n" + "3 - CONSULTA\n"
				+ "4 - EXCLUSÃO\n" + "OPÇÃO: _");

		Scanner sc = new Scanner(System.in);
		int opcao = sc.nextInt();
		switch (opcao) {
		case 0:
			menuPrincipal();
			break;
		case 1:
			incluirProduto();
			break;
		case 2:
			System.out.println("\nMOVIMENTAÇÃO");
			break;
		case 3:
			consultaProduto();
			break;
		case 4:
			System.out.println("\nRELATÓRIOS");
			break;
		default:
			System.out.println("\nDIGITE SOMENTE NÚMEROS ENTRE 0 E 4\n\n");
			menuPrincipal();
			break;
		}
		sc.close();
	}

//TELA 1.1.1 - INCLUSÃO DE PRODUTO
	private static void incluirProduto() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n" 
				+ "SISTEMA DE CONTROLE DE ESTOQUE\n\n"
				+ "INCLUSÃO DE PRODUTO\n\n" 
				+ "NOME: ");
		String nome = sc.next();
		System.out.print("PREÇO: ");
		double preço = sc.nextDouble();
		System.out.print("UNIDADE: ");
		String unidade = sc.next();
		System.out.print("QUANTIDADE: ");
		sc.nextLine();
		int quantidade = sc.nextInt();
		
		if(validaNomeProduto(nome) == true) {	
			System.out.println();
			System.out.print("CONFIRMA INCLUSÃO (S/N)? ");
			char x = sc.next().charAt(0);
			if (x == 'S' || x == 's') {
				Produto p = new Produto(nome, preço, unidade, quantidade);
				list.add(p);
				System.out.println();
				System.out.println("PRODUTO CADASTRADO COM SUCESSO");
				System.out.println();
			}
		} else {
			System.out.println("O PRODUTO INFORMADO JÁ ESTÁ CADASTRADO");
			System.out.println();
		}
		

		System.out.print("DESEJA REPETIR OPERAÇÃO (S/N)? _");
		char y = sc.next().charAt(0);
		if (y == 'S' || y == 's') {
			System.out.println();

			incluirProduto();
		}
		cadastroProdutos();
		sc.close();

	}

//TELA 1.1.3 - CONSULTA DE PRODUTO
	private static void consultaProduto() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("QUAL PRODUTO DESEJA CONSULTAR? ");
		String nomeProdutoDesejado = sc.next();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNome().equals(nomeProdutoDesejado)) {
				System.out.println("NOME: " + list.get(i).getNome());
				System.out.println("PREÇO: " + list.get(i).getPreço());
				System.out.println("UNIDADE: " + list.get(i).getUnidade());
				System.out.println("QUANTIDADE: " + list.get(i).getQuantidade());
				System.out.println();
			} else {
				System.out.println("Produto não encontrado");
			}
		}
		cadastroProdutos();

		sc.close();
	}
	
//VALIDAÇÃO DO NOME DO PRODUTO, CASO SEJA REPETIDO, 
//	NÃO PODE SER ADICIONADO NA LISTA
	
	public static boolean validaNomeProduto(String nome) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNome() == nome) {
				return false;
			}
		}
		return true;
	}
}


//System.out.print("NOME JÁ EXISTE");
//System.out.print("REPETIR OPERAÇÃO (S/N)? _");
//char y = sc.next().charAt(0);
//if (y == 'S' || y == 's') {
//	incluirProduto();
//	System.out.println();
//}






