package fiap.com.br.library.controller;

import fiap.com.br.library.model.Livro;
import fiap.com.br.library.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livroService.findAll());
        return "livros/list";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Livro livro) {
        livroService.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Livro livro = livroService.findById(id);
        model.addAttribute("livro", livro);
        return "livros/form";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        livroService.delete(id);
        return "redirect:/livros";
    }

    @GetMapping("/pesquisa")
    public String pesquisar(@RequestParam(required = false) String titulo, Model model) {
        System.out.println("Buscando por título: " + titulo);
        if (titulo == null || titulo.trim().isEmpty()) {
            return "livros/pesquisa";
        }
        List<Livro> resultados = livroService.searchByTitle(titulo);
        System.out.println("Resultados encontrados: " + resultados.size());

        model.addAttribute("resultados", resultados);
        return "livros/pesquisa";
    }

}
