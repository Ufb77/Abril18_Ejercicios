package com.softtek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class Abril18EjerciciosApplication {

	public static void main(String[] args) {

		SpringApplication.run(Abril18EjerciciosApplication.class, args);


		//Ejercicio optional 1

		Optional<String> nombre = Optional.empty();//Optional.of("Jose");

		System.out.println(nombre.orElse("nombre de usuario inválido"));


		//Ejercicio optional 2


		ArrayList<String> lista = new ArrayList<>();
		lista.add("Jose");
		lista.add("Ana");
		lista.add("Jesús");



		Optional<ArrayList<String>> listaOp = Optional.of(lista);




	}




}
