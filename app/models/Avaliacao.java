package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Avaliacao extends Model {
    public String mensagem;
    public String usuario;

    @Enumerated(EnumType.STRING)
    public Status status;

    @ManyToOne
    @Required
    public Produto produto;

    public Double valor;

    public Date data;

    public Avaliacao(String mensagem, String usuario, Produto p) {
        super();
        this.mensagem = mensagem;
        this.usuario = usuario;
        this.status = Status.ATIVO;
        this.produto = p;
        this.data = new Date();
    }

    public Avaliacao() {
        this.status = Status.ATIVO;
        this.data = new Date();
    }
}