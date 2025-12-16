package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

@Entity
public class Pessoa extends Model {

    @Required(message = "O nome é obrigatório.")
    @MinSize(value = 3, message = "O nome deve ter no mínimo 3 caracteres.")
    public String nome;

    @Required(message = "O e-mail é obrigatório.")
    @Email(message = "Informe um e-mail válido.")
    @Unique(message = "Este e-mail já está cadastrado.")
    public String email;

    @Required(message = "O login é obrigatório.")
    @MinSize(value = 3, message = "O login deve ter no mínimo 3 caracteres.")
    @Unique(message = "Este login já está sendo utilizado.")
    public String login;

    @Required(message = "A senha é obrigatória.")
    @MinSize(value = 4, message = "A senha deve ter no mínimo 4 caracteres.")
    public String senha;

    @ManyToOne
    public Avaliacao avaliacao;

    @Enumerated(EnumType.STRING)
    public Status status;

    public Pessoa() {
        this.status = Status.ATIVO;
    }
}