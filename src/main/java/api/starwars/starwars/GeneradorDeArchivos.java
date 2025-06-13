package api.starwars.starwars;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeneradorDeArchivos {

    public void guardarJson(Pelicula pelicula) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter escritura = new FileWriter(pelicula.title()+"Json");
        escritura.write(gson.toJson(pelicula));
        escritura.close();

    }
}
