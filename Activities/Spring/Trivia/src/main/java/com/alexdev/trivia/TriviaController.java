package com.alexdev.trivia;

import ch.qos.logback.core.net.ObjectWriter;
import com.alexdev.trivia.clients.ChatGPTClient;
import com.alexdev.trivia.models.Categoria;
import com.alexdev.trivia.models.Pregunta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TriviaController {
    @GetMapping("/categories")
    public List<Categoria> getCategories() {
        return loadCategories();

    }

    private static List<Categoria> loadCategories() {
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
    public String getQuestion(@PathVariable String categoria) throws IOException {
        //var converter = new ObjectMapper();
        var chatgpt = new ChatGPTClient();
        var question = "Estoy desarrollando una trivia, necesito que realices una pregunta de "+categoria+" en formato JSON, de la siguiente manera: \n" +
                "{\n" +
                "\t\"category\": \"aca va el nombre de la categoria("+categoria+")\",\n" +
                "        \"question\": \"aca va la pregunta acerca de la categoria\",\n" +
                "        \"options\": \"aca va una lista de opciones, de nomas de 3 opciones la cual una de ellas tiene que ser la correcta\",\n" +
                "        \"answer\": \"aca va la opcion correcta, en caso de ser la primera es el numero 0, en caso de ser la segunda es el numero 1, en caso de ser la segunda es el numero 2, en caso de ser la tercera es el numero 3\",\n" +
                "        \"explanation\": \\\"aca va una pequeña explicacion, de por que la respuesta es correcta\"\n" +
                "}";

        return chatgpt.sendQuestion(question);
         //converter.convertValue(responseGPT, Pregunta.class);

    }
}
