package unicesumar.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Produto {

	private String nome;
	private Double preço;
	private String unidade;
	private Integer quantidade;
	private List<Produto> produtos = new ArrayList<>();

	public Produto(String nome, Double preço, String unidade, Integer quantidade) { 
		this.nome = nome;
		if (preço <= 0) {
			System.out.println("ERRO!!! O preço deve ser maior que zero.");
		} else {
			this.preço = preço;
		}
		this.unidade = unidade;
		this.quantidade = quantidade;
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

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
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
		return "Produto [name=" + nome + ", preço=" + preço + ", unidade=" + unidade + ", quantidade=" + quantidade
				+ "]";
	}

}




