package api.login.model;

import jakarta.persistence.*;

@Entity
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @ManyToOne
    private EnderecoModel enderecoModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EnderecoModel getEndereco() {
        return enderecoModel;
    }

    public void setEndereco(EnderecoModel enderecoModel) {
        this.enderecoModel = enderecoModel;
    }
}
