package br.com.creativesoftwares.contatosapi;

/**
 * Created by 16254840 on 14/11/2017.
 */

public class Contato {

    private int id;
    private String nome;
    private String telefone;
    private String foto;

    // FABRICA DE CONTATOS
    public static Contato create (int id, String nome, String telefone, String foto){

        Contato c = new Contato();
        c.setId(id);
        c.setNome(nome);
        c.setTelefone(telefone);
        c.setFoto(foto);

        return c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
