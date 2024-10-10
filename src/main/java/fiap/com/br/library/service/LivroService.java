package fiap.com.br.library.service;

import fiap.com.br.library.model.Livro;
import fiap.com.br.library.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public void save(Livro livro) {
        livroRepository.save(livro);
    }

    public void delete(Long id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> searchByTitle(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }
}