package api.starwars.starwars;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarwarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class, args);
		
		Scanner lectura = new Scanner(System.in);

		ConsultaPelicula consulta = new ConsultaPelicula();
		System.out.println("Escriba el numero de la pelicula que quiere consultar: ");
		
		try{
 			var numeroDePelicula =  Integer.valueOf(lectura.nextLine());
			Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
        	System.out.println(pelicula);
			GeneradorDeArchivos generador = new GeneradorDeArchivos();
			generador.guardarJson(pelicula);
		}catch (NumberFormatException e){
			System.out.println("Numero no encontrado "+ e.getMessage());
		} 
		catch(RuntimeException | IOException e){
			System.out.println(e.getMessage());
			System.out.println("Finalizando la aplicacion");
		}
       

	}

}
