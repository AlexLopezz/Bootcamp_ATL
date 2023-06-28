package com.alexdev.trivia;

import com.alexdev.trivia.models.Categoria;
import com.alexdev.trivia.models.Pregunta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TriviaController {
    @GetMapping("/categories")
    public List<Categoria> getCategories(){
        return cargarCategorias();
    }

    private static List<Categoria> cargarCategorias() {
        List<Categoria> categorias = new ArrayList<>();

        categorias.add(new Categoria(
                "Cultura",
                "Preguntas relacionadas con arte, literatura, música y otras expresiones culturales."
        ));
        categorias.add(new Categoria(
                "Deportes",
                "Preguntas relacionadas con diversos deportes y eventos deportivos."
        ));
        categorias.add(new Categoria(
                "Arte",
                "Preguntas relacionadas con pintura, escultura, arquitectura y otras formas de expresión artística."
        ));
        categorias.add(new Categoria(
                "Cine",
                "Preguntas relacionadas con películas, directores, actores y otros aspectos del cine."
        ));
        categorias.add(new Categoria(
                "Historia",
                "Preguntas relacionadas con eventos históricos, personajes y períodos importantes."
        ));
        categorias.add(new Categoria(
                "Ciencia",
                "Preguntas relacionadas con diferentes ramas de la ciencia, descubrimientos y avances científicos."
        ));
        return categorias;
    }

    @GetMapping("/question/{categoria}")
    public Pregunta getQuestion(@PathVariable String categoria) {
        String[] opciones = {
                "Cerveza, lima/limón, sal, chile en polvo, salsa tipo inglesa, picante",
                "Cerveza, lima/limón y limon",
                "Cerveza, sal, tabasco y lima/limón"
        };

        return new Pregunta(
                categoria,
                "¿Qué ingredintes se necesitan para hacer una michelada?",
                "La michelada, originaria de México, nacida de la creatividad y el deseo de refrescar, se convirtió en una popular bebida que cautivó a los amantes de la cerveza con su combinación única de sabores y su espíritu festivo.",
                opciones,
                0
        );
    }
}
