package com.alexdev.bootcampATL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

@RestController
public class MainController {
    @GetMapping("/holaMundo")
    public String helloWorld(){ //midominio.com/holaMundo
        return "Hola mundo!";
    }
    @GetMapping("/generatePassword")
    public String generatePass(){
        var random = new Random();

        int aleatoryNumber = random.nextInt(10000);

        return "passALF"+aleatoryNumber;
    }
    @GetMapping("/transform-morse-code/{text}")
    public String transformToMorseCode(@PathVariable String text){
        var sb = new StringBuilder();
        text = text.toUpperCase();

        var morseCode = loadMorseCode();
        for(int i=0; i < text.length(); i++){
            for(var key : morseCode.keySet()){
                if(text.charAt(i) != ' ') {
                    if (text.charAt(i) == key) {
                        sb.append(morseCode.get(key));
                    }
                }else {
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }

    /**
     * Este metodo generara un diccionario con todas
     * las letras y numeros como clave y su traduccion en Morse como valor.
     * @return Diccionario con traduccion de codigo Morse
     */
    private static Map<Character, String> loadMorseCode() {
        Map<Character, String> morseCode = new HashMap<>();
        morseCode.put('A', ".-");
        morseCode.put('B', "-...");
        morseCode.put('C', "-.-.");
        morseCode.put('D', "-..");
        morseCode.put('E', ".");
        morseCode.put('F', "..-.");
        morseCode.put('G', "--.");
        morseCode.put('H', "....");
        morseCode.put('I', "..");
        morseCode.put('J', ".---");
        morseCode.put('K', "-.-");
        morseCode.put('L', ".-..");
        morseCode.put('M', "--");
        morseCode.put('N', "-.");
        morseCode.put('O', "---");
        morseCode.put('P', ".--.");
        morseCode.put('Q', "--.-");
        morseCode.put('R', ".-.");
        morseCode.put('S', "...");
        morseCode.put('T', "-");
        morseCode.put('U', "..-");
        morseCode.put('V', "...-");
        morseCode.put('W', ".--");
        morseCode.put('X', "-..-");
        morseCode.put('Y', "-.--");
        morseCode.put('Z', "--..");

        morseCode.put('0', "-----");
        morseCode.put('1', ".----");
        morseCode.put('2', "..---");
        morseCode.put('3', "...--");
        morseCode.put('4', "....-");
        morseCode.put('5', ".....");
        morseCode.put('6', "-....");
        morseCode.put('7', "--...");
        morseCode.put('8', "---..");
        morseCode.put('9', "----.");

        return morseCode;
    }
}
