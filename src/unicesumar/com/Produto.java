package unicesumar.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Produto {

	private String nome;
	private Double preco;
	private String unidade;
	private Integer quantidade;
	private List<Produto> produtos = new ArrayList<>();

	public Produto(String nome, Double preco, String unidade, Integer quantidade) { 
		this.nome = nome;
		this.preco = preco;
		this.unidade = unidade;
		this.quantidade = quantidade;
	}

	public Produto() {
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void addQuantidade(Integer valor) {
		this.quantidade += valor;
	}

	public void removeQuantidade(Integer valor) {
		this.quantidade -= valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "PRODUTO [NOME: " 
						+ nome 
						+ ", PREÇO: " 
						+ preco 
						+ ", UNIDADE: " 
						+ unidade 
						+ ", QUANTIDADE: " 
						+ quantidade
						+ "]";
	}
	
}




