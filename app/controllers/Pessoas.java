package controllers;

import java.util.List;

import models.Compra;
import models.Pessoa;
import models.Status;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Pessoas extends Controller {

	public static void form(Long id) {
		Pessoa pessoa = null;
		if (id != null) {
			pessoa = Pessoa.findById(id);
		}
		List<Compra> compras = Compra.findAll();
		render(pessoa, compras);
	}

	public static void listar(String termo) {
		List<Pessoa> pessoas;

		if (termo == null || termo.trim().isEmpty()) {
			pessoas = Pessoa.find("status <> ?1", Status.INATIVO).fetch();
		} else {
			pessoas = Pessoa.find("(lower(nome) like ?1 or lower(email) like ?1) and status <> ?2",
					"%" + termo.toLowerCase() + "%", Status.INATIVO).fetch();
		}

		render(pessoas, termo);
	}

	/** AJAX - Retorna JSON com lista de pessoas filtradas **/
	public static void listarAjax(String termo) {
		List<Pessoa> pessoas;

		if (termo == null || termo.trim().isEmpty()) {
			pessoas = Pessoa.find("status <> ?1", Status.INATIVO).fetch();
		} else {
			pessoas = Pessoa.find("(lower(nome) like ?1 or lower(email) like ?1) and status <> ?2",
					"%" + termo.toLowerCase() + "%", Status.INATIVO).fetch();
		}

		renderJSON(pessoas);
	}

	public static void detalhar(Pessoa pessoa) {
		if (pessoa == null || pessoa.id == null) {
			flash.error("Pessoa não encontrada.");
			listar(null);
		}
		render(pessoa);
	}

	public static void editar(Long id) {
		Pessoa pessoa = Pessoa.findById(id);
		if (pessoa == null) {
			flash.error("Pessoa não encontrada.");
			listar(null);
		}
		List<Compra> compras = Compra.findAll();
		renderTemplate("Pessoas/form.html", pessoa, compras);
	}

	public static void salvar(@Valid Pessoa pessoa) {

		if (validation.hasErrors()) {
			params.flash();
			validation.keep();
			form(pessoa.id);
		}

		if (pessoa.nome != null && !pessoa.nome.trim().isEmpty()) {
			pessoa.nome = pessoa.nome.toUpperCase();
		}

		if (pessoa.email != null && !pessoa.email.trim().isEmpty()) {
			pessoa.email = pessoa.email.toLowerCase();
		}

		pessoa.status = Status.ATIVO;
		pessoa.save();

		flash.success(pessoa.nome + " foi cadastrada com sucesso.");
		listar(null);
	}

	public static void remover(Long id) {
		Pessoa pessoa = Pessoa.findById(id);
		if (pessoa != null) {
			pessoa.status = Status.INATIVO;
			pessoa.save();
			flash.success("Pessoa removida com sucesso!");
		} else {
			flash.error("Pessoa não encontrada.");
		}
		listar(null);
	}
}