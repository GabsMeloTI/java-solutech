package fiap.com.br.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Livro {
    @Id
    @GeneratedValue()
    @Column(name = "id_livro")
    private Long id;
    @Column(name = "ds_titulo")
    private String titulo;
    @Column(name = "ds_autor")
    private String autor;
    @Column(name = "ds_categoria")
    private String categoria;
    @Column(name = "ano_publicacao")
    private int ano;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
