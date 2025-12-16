package controllers;

import models.Pessoa;
import models.Status;
import play.mvc.Controller;

public class Logins extends Controller {
    
    public static void form() {
        render();
    }
    
    public static void logar(String login, String senha) {
        // Validação básica
        if (login == null || login.trim().isEmpty()) {
            flash.error("O login é obrigatório.");
            form();
            return;
        }
        
        if (senha == null || senha.trim().isEmpty()) {
            flash.error("A senha é obrigatória.");
            form();
            return;
        }
        
        // Busca pessoa com login e senha fornecidos e status ativo
        Pessoa pessoa = Pessoa.find("login = ?1 and senha = ?2 and status = ?3", 
                login.trim(), senha, Status.ATIVO).first();
        
        if (pessoa == null) {
            flash.error("Login ou senha inválidos.");
            form();
        } else {
            session.put("usuarioLogado", pessoa.email);
            session.put("usuarioId", pessoa.id.toString());
            session.put("usuarioNome", pessoa.nome);
            flash.success("Bem-vindo(a), " + pessoa.nome + "!");
            Compras.principal();
        }
    }
    
    public static void logout() {
        session.clear();
        flash.success("Você saiu do sistema!");
        form();
    }
}