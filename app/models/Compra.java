package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Compra extends Model {

    @Required
    public Date data;

    @Required
    public Double valorTotal;

    @ManyToOne
    public Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    public Status status;

    public Compra() {
        this.data = new Date();
        this.status = Status.ATIVO;
    }

    public Compra(Date data, Double valorTotal, Pessoa pessoa) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.pessoa = pessoa;
        this.status = Status.ATIVO;
    }
}