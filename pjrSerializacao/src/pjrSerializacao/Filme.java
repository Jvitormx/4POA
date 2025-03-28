package pjrSerializacao;

import java.io.Serializable;
public class Filme implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	private String titulo;
	private int lancamento;
	private double avaliacao;
	private transient String descricao;
	
	public Filme(String titulo, int lancamento , double avaliacao, String descricao) {
		super();
		this.titulo = titulo;
		this.lancamento = lancamento;
		this.avaliacao = avaliacao;
		this.descricao = descricao;
	}
	
	public String toString() {
		return "Filme [titulo=" + titulo + ", lancamento= " + lancamento + ", avaliacao=" + avaliacao + ", descricao=" + descricao + "]";
	}
	
		public String getTiulo() {return titulo;}
		public void setTitulo(String titulo) {this.titulo = titulo;}
		public int getLancamento() {return lancamento;}
		public void setLancamento(int lancamento) {this.lancamento = lancamento;}
		public double getAvaliacao() {return avaliacao;}
		public void setAvaliacao(double avaliacao) {this.avaliacao = avaliacao;}
		public String getDescricao() {return descricao;}
		public void setDescricao(String descricao) {this.descricao = descricao;}	
}

