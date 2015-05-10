package costa.barreto.alessandro.exemploblogbancosqlite.domain;

/**
 * Created by Alessandro on 09/05/2015.
 */
public class Pessoa {
    public Long _id;
    public String nome;
    public int idade;
    public String email;

    public Pessoa(Long _id, String nome, int idade, String email) {
        this._id = _id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public Pessoa() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
