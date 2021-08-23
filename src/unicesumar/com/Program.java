package unicesumar.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	private static List<Produto> list;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		list = new ArrayList<>();

		menuPrincipal();
	}

	// TELA 1.0 MENU PRINCIPAL
	private static void menuPrincipal() {
		System.out.print("\nEMPRESA DE IMPORTA��O DE PRODUTOS LTDA.\n" + "SISTEMA DE CONTROLE DE ESTOQUE\n\n"
				+ "MENU PRINCIPAL\n" + "0 - FINALIZAR\n" + "1 - CADASTRO DE PRODUTOS\n" + "2 - MOVIMENTA��O\n"
				+ "3 - REAJUSTE DE PRE�OS\n" + "4 - RELAT�RIOS\n" + "OP��O: _");

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
			movimentacaoDeProduto();
			break;
		case 3:
			System.out.println("\nM�TODO N�O IMPLEMENTADO");
			menuPrincipal();
			break;
		case 4:
			imprimirRelatorio();
			menuPrincipal();
			break;
		default:
			System.out.println("\nDIGITE SOMENTE N�MEROS ENTRE 0 E 4\n\n");
			menuPrincipal();
			break;
		}
		sc.close();
	}

//GERAR UM RELAT�RIO DE TODOS PRODUTOS CADASTRADOS
	private static void imprimirRelatorio() {
		for (Produto produto : list) {
			System.out.println("\n" + produto);
		}
	}

//0 - FINALIZAR
	private static void exit() {
		System.out.println("PROGRAMA FINALIZADO.");
	}

//TELA 1.1 - CADASTRO DE PRODUTOS
	private static void cadastroProdutos() {
		System.out.print("\nEMPRESA DE IMPORTA??O DE PRODUTOS LTDA.\n" + "SISTEMA DE CONTROLE DE ESTOQUE\n\n"
				+ "CADASTRO DE PRODUTOS\n" + "0 - RETORNAR\n" + "1 - INCLUS�O\n" + "2 - ALTERA��O\n" + "3 - CONSULTA\n"
				+ "4 - EXCLUS�O\n" + "OP��O: _");

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
			alteraProduto();
			break;
		case 3:
			consultaProduto();
			break;
		case 4:
			excluirProduto();
			break;
		default:
			System.out.println("\nDIGITE SOMENTE N�MEROS ENTRE 0 E 4\n\n");
			cadastroProdutos();
			break;
		}
		sc.close();
	}

//TELA 1.1.1 - INCLUS?O DE PRODUTO
	public static void incluirProduto() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEMPRESA DE IMPORTA��OO DE PRODUTOS LTDA.\n" + "SISTEMA DE CONTROLE DE ESTOQUE\n\n"
				+ "INCLUS�O DE PRODUTO\n\n" + "NOME: ");

		String nome = sc.nextLine();
		double preco = 0;
		while (preco <= 0) {
			System.out.print("PRE�O: ");
			preco = sc.nextDouble();
			if (preco <= 0) {
				System.err.println("ERRO!!! O PRE�O DEVE SER MAIOR DE ZERO.");
			}
		}

		System.out.print("UNIDADE: ");
		String unidade = sc.next();
		System.out.print("QUANTIDADE: ");
		sc.nextLine();
		int quantidade = sc.nextInt();

		if (!verificaSeProdutoExiste(nome)) {
			System.out.print("\nCONFIRMAR INCLUS�O (S/N)? ");
			char x = sc.next().charAt(0);
			if (x == 'S' || x == 's') {
				Produto p = new Produto(nome, preco, unidade, quantidade);
				list.add(p);
				System.out.println("\nPRODUTO CADASTRADO COM SUCESSO\n");
			}
		} else {
			System.err.println("\nO PRODUTO INFORMADO J� EST� CADASTRADO\n");
		}

		System.out.print("DESEJA REPETIR OPERA��O (S/N)? _");
		char y = sc.next().charAt(0);
		if (y == 'S' || y == 's') {
			incluirProduto();
		}
		cadastroProdutos();
		sc.close();
	}

//TELA 1.1.2 - ALTERAR DE PRODUTO
	public static void alteraProduto() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nQUAL PRODUTO DESEJA ALTERAR? ");
		String nomeAlterado = sc.next();
		if (verificaSeProdutoExiste(nomeAlterado)) {
			for (int p = 0; p < list.size(); p++) {
				Produto prod = list.get(p);
				if (prod.getNome().equals(nomeAlterado)) {
					list.remove(p);
				}
			}

			System.out.print("NOME: ");
			String nome = sc.next();
			System.out.print("PRE�O: ");
			double preco = sc.nextDouble();
			System.out.print("UNIDADE: ");
			String unidade = sc.next();
			System.out.print("QUANTIDADE: ");
			sc.nextLine();
			int quantidade = sc.nextInt();

			if (!verificaSeProdutoExiste(nome)) {
				System.out.print("\nCONFIRMAR ALTERA��O (S/N)? ");
				char x = sc.next().charAt(0);
				if (x == 'S' || x == 's') {
					Produto p = new Produto(nome, preco, unidade, quantidade);
					list.add(p);
					System.out.println("\nPRODUTO ALTERADO COM SUCESSO\n");
				} else {
					System.err.println("\nPRODUTO N�O EXISTENTE");
				}
				cadastroProdutos();
				sc.close();
			}
		} else {
			System.err.println("\nPRODUTO N�O CADASTRADO");
			cadastroProdutos();
		}
	}

//TELA 1.1.3 - CONSULTA DE PRODUTO
	public static void consultaProduto() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nQUAL PRODUTO DESEJA CONSULTAR? ");
		String nome = sc.nextLine();
		if (verificaSeProdutoExiste(nome)) {
			listarDadosProduto(nome);
		} else {
			System.err.println("\nPRODUTO N�O CADASTRADO");
		}
		cadastroProdutos();
		sc.close();
	}

//VALIDA??O DO NOME DO PRODUTO, CASO SEJA REPETIDO, 
//	N?O PODE SER ADICIONADO NA LISTA
	public static boolean verificaSeProdutoExiste(String nome) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

//MOSTRAR DADOS DO PRODUTO
	public static void listarDadosProduto(String nome) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNome().equals(nome)) {
				Produto prod = list.get(i);
				System.out.println(prod);
			}
		}
	}

// TELA 1.1.4 - M�TODO PARA EXCLUIR PRODUTO DA LISTA CASO EXISTA ALGUM PRODUTOS
//COM O MESMO NOME NA LISTA
	public static void excluirProduto() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nQUAL PRODUTO DESEJA EXCLUIR? ");
		String produtoExcluido = sc.nextLine();

		if (verificaSeProdutoExiste(produtoExcluido)) {
			listarDadosProduto(produtoExcluido);

			System.err.print("\nREALMENTE DESEJA EXCLUIR " + produtoExcluido + " DA SUA LISTA (S/N)? _");
			char y = sc.next().charAt(0);
			if (y == 'S' || y == 's') {
				for (Produto produto : list) {
					if (produto.getNome().equals(produtoExcluido)) {
						list.remove(produto);
						System.out.println("PRODUTO EXCLU�DO COM SUCESSO!");
						cadastroProdutos();
					}
				}
			}

		} else {
			System.err.println("\nPRODUTO N�O CADASTRADO");
		}
		cadastroProdutos();
		sc.close();
	}

//TELA 1.2 - MOVIMENTA��O
	public static void movimentacaoDeProduto() {
		System.out.print("\nEMPRESA DE IMPORTA��O DE PRODUTOS LTDA. " + "\nSISTEMA DE CONTROLE DE ESTOQUE MOVIMENTA��O "
				+ "\n1 - ENTRADA " + "\n2 - SA�DA " + "\n0 - RETORNAR " + "\nOP��O: _");

		Scanner sc = new Scanner(System.in);
		int opcao = sc.nextInt();
		switch (opcao) {
		case 0:
			menuPrincipal();
			break;
		case 1:
			entradaDeProduto();
			break;
		case 2:
			saidaDeProduto();
			break;
		default:
			System.out.println("\nDIGITE SOMENTE N�MEROS ENTRE 0 E 2\n\n");
			cadastroProdutos();
			break;
		}
		sc.close();
	}

	public static void saidaDeProduto() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nQUAL PRODUTO DESEJA REMOVER DO ESTOQUE? ");
		String nome = sc.nextLine();
		if (verificaSeProdutoExiste(nome)) {
			for (Produto p : list) {
				p.getNome().equals(nome);
				System.out.print("QUANTIDADE ATUAL: " + p.getQuantidade());

				System.out.print("\nQUANTIDADE SA�DA:_ ");
				int valor = sc.nextInt();
				System.out.print("\nCONFIRMA SA�DA DO ESTOQUE (S/N)?_");
				char y = sc.next().charAt(0);
				if (y == 'S' || y == 's') {
					for (Produto prod : list) {
						prod.getNome().equals(nome);
						prod.removeQuantidade(valor);
						System.out.println("QUANTIDADE FINAL: " + prod.getQuantidade());
					}
				}
			}
		} else {
			System.err.println("\nPRODUTO N�O EXISTENTE");
			movimentacaoDeProduto();
			System.out.print("REPETIR OPERA��O (S/N)?_");
			char x = sc.next().charAt(0);
			if (x == 'S' || x == 's') {
				entradaDeProduto();
			}
		}
		movimentacaoDeProduto();
		sc.close();
	}

	public static void entradaDeProduto() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nQUAL PRODUTO DESEJA ACRESCENTAR AO ESTOQUE? ");
		String nome = sc.nextLine();
		if (verificaSeProdutoExiste(nome)) {
			for (Produto p : list) {
				p.getNome().equals(nome);
				System.out.print("QUANTIDADE ATUAL: " + p.getQuantidade());

				System.out.print("\nQUANTIDADE ENTRADA:_ ");
				int valor = sc.nextInt();
				System.out.print("\nCONFIRMA ENTRADA NO ESTOQUE (S/N)?_");
				char y = sc.next().charAt(0);
				if (y == 'S' || y == 's') {
					for (Produto prod : list) {
						prod.getNome().equals(nome);
						prod.addQuantidade(valor);
						System.out.println("QUANTIDADE FINAL: " + prod.getQuantidade());
					}
				}
			}
		} else {
			System.err.println("\nPRODUTO N�O EXISTENTE");
			movimentacaoDeProduto();
			System.out.print("REPETIR OPERA��O (S/N)?_");
			char x = sc.next().charAt(0);
			if (x == 'S' || x == 's') {
				entradaDeProduto();
			}
		}
		movimentacaoDeProduto();
		sc.close();
	}

}