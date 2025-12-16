package controllers;

import java.util.List;

import javax.validation.Valid;

import models.Avaliacao;
import models.Produto;
import models.Status;

import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Compras extends Controller {
	
	// Página principal
	public static void principal() {
		List<Produto> produtos = Produto.findAll();
		render(produtos);
	}
	
	// Página de produtos 
	public static void produtos() {
		List<Produto> produtos = Produto.findAll();
		render(produtos);
	}
	
	// Salvar avaliação
	public static void salvaravaliacao(Avaliacao a) {
		if (a != null) {
			a.status = Status.ATIVO;
			a.save();
		}
		principal();
	}
	
	// Listar avaliações
	public static void avaliacoes(String busca) {
		List<Avaliacao> avaliacao;
		
		if (busca == null || busca.trim().isEmpty()) {
			avaliacao = Avaliacao.find("status <> ?1", Status.INATIVO).fetch();
		} else {
			busca = busca.toLowerCase();
			avaliacao = Avaliacao.find("(lower(mensagem) like ?1 or lower(usuario) like ?1) and status <> ?2", 
					"%" + busca + "%", Status.INATIVO).fetch();
		}
		render(avaliacao, busca);
	}
	
	// Exibir tela de edição
	public static void editaravaliacao(Long id) {
		Avaliacao a = Avaliacao.findById(id);
		if (a == null) {
			flash.error("Avaliação não encontrada.");
			avaliacoes(null);
		}
		render(a);
	}
	
	// Função para editar
	public static void editando(Avaliacao a) {
		if (a != null && a.id != null) {
			Avaliacao avaliacao = Avaliacao.findById(a.id);
			if (avaliacao != null) {
				avaliacao.usuario = a.usuario;
				avaliacao.mensagem = a.mensagem;
				avaliacao.save();
				flash.success("Avaliação editada com sucesso!");
			}
		}
		avaliacoes(null);
	}
	
	public static void deletar(Long id) {
		Avaliacao avaliacao = Avaliacao.findById(id);
		if (avaliacao != null) {
			avaliacao.status = Status.INATIVO;
			avaliacao.save();
			flash.success("Avaliação excluída com sucesso!");
		}
		avaliacoes(null);
	}
	
	public static void detalharproduto(Long id) {
		Produto produto = Produto.findById(id);
		if (produto == null) {
			flash.error("Produto não encontrado.");
			produtos();
		}
		List<Avaliacao> avaliacao = Avaliacao.find("produto.id = ?1 and status <> ?2", 
				id, Status.INATIVO).fetch();
		render(produto, avaliacao);
	}
	
	public static void contato() {
		render();
	}
}