package api.starwars.starwars;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class ConsultaPelicula {
    public Pelicula buscaPelicula(int numeroDePelicula){

        URI direccion = URI.create("https://swapi.py4e.com/api/films/"+numeroDePelicula+"/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri (direccion)
            .build();

       
        try {
             HttpResponse<String> response = client
                    .send(request, BodyHandlers.ofString());
                    return new Gson().fromJson(response.body(),Pelicula.class);
        } catch (Exception e) {
            throw new RuntimeException("Pelicula no encontrada");
        }
           

        
    }


}
