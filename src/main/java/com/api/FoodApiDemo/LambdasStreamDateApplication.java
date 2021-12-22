package com.api.FoodApiDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.FoodApiDemo.model.Usuario;

@SpringBootApplication
public class LambdasStreamDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdasStreamDateApplication.class, args);
//		maneiraAntiga();n
		ordenarComSort();
	}
	
	public static void ordenarComSort() {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);
		List<Usuario> user = Arrays.asList(user1,user2,user3);
		user.sort((u1,u2) -> u1.getNome().compareTo(u2.getNome()));
		user.sort(Comparator.comparing(u -> u.getNome()));
		user.forEach(u -> System.out.println(u));
//		List<String> palavras =
//				Arrays.asList("Casa do Código", "Alura", "Caelum");
//				palavras.sort(Comparator.naturalOrder());
//				
//				
//				usuarios.stream()
//				.filter(u -> u.getPontos() > 100)
//				.collect(Collectors.toList());
//				
//				usuarios.stream()
//				.sorted(Comparator.comparing(Usuario::getNome))
//				.peek(System.out::println)
//				.findAny();

	}
	
	public static void forEch() {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);
		List<Usuario> user = Arrays.asList(user1,user2,user3);
		user.forEach(new Consumer<Usuario>() {
			@Override
			public void accept(Usuario t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		});
	}
	
	public static void forEachLambda() {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);
		List<Usuario> user = Arrays.asList(user1,user2,user3);
		user.forEach(u -> System.out.println(u));
	}
	
	public static void maneiraAntiga() {
		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 190);
		List<Usuario> user = Arrays.asList(user1,user2,user3);
		for (Usuario usuario : user) {
			System.out.println(usuario);
		}
	}

}
