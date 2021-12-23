package com.api.FoodApiDemo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.FoodApiDemo.model.Usuario;

@SpringBootApplication
public class LambdasStreamDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdasStreamDateApplication.class, args);
//		
//		long dias = ChronoUnit.DAYS.between(outraData, agora);
//		long meses = ChronoUnit.MONTHS.between(outraData, agora);
//		long anos = ChronoUnit.YEARS.between(outraData, agora);
//		System.out.printf("%s dias, %s meses e %s anos", dias, meses, anos);

//		LocalDate agora = LocalDate.now();
//		LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);
//		Period periodo = Period.between(outraData, agora);
//		System.out.printf("%s dias, %s meses e %s anos",
//		periodo.getDays(), periodo.getMonths(), periodo.getYears());
		
//		LocalDateTime agora = LocalDateTime.now();
//		LocalDateTime daquiAUmaHora = LocalDateTime.now().plusHours(1);
//		Duration duration = Duration.between(agora, daquiAUmaHora);
//		if (duration.isNegative()) {
//		duration = duration.negated();
//		}
		ArrayList<Usuario> usuarios =  CriaUsuarios();
		Stream<Usuario> users = usuarios.stream();
		
		Optional<Usuario> usersr = users.filter(u -> u.getPontos() > 200).
				sorted(Comparator.comparing(us -> us.getNome()))
				.max(Comparator.comparing(ut -> ut.getPontos()));
		System.out.println(usersr);
		
		LocalDate dat = LocalDate.now();
		LocalDate datFinal = LocalDate.now().plusMonths(1).plusDays(12).plusYears(2);
		
		Period period = Period.between(dat, datFinal);
		System.out.println(period.getDays());
		
		LocalTime lt = LocalTime.now();
		LocalTime lte = LocalTime.now().plusHours(2).plusMinutes(45);
		Duration duracao = Duration.between(lt, lte);
		System.out.println(duracao.toMinutes());
		System.out.println(duracao.toHours());
		
		System.out.println(dat.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
	}
	
	public static ArrayList<Usuario> CriaUsuarios() {
		Usuario user1 = new Usuario("Fabricio Junior", 120000);
		Usuario user2 = new Usuario("Fabiana Caroline", 1200);
		Usuario user3 = new Usuario("Fabio Henrique", 200);
		Usuario user4 = new Usuario("Ordalina Rodrigues", 100);
		Usuario user5 = new Usuario("Vitoria", 50);
		Usuario user6 = new Usuario("Aline D", 25);
		Usuario user7 = new Usuario("Vanda Valle", 500);
		Usuario user8 = new Usuario("Julia N", 500);
		Usuario user9 = new Usuario("Gabriela C", 600);
		Usuario user10 = new Usuario("Celina G", 8088);
		Usuario user11 = new Usuario("Geovana S", 7800);
		Usuario user12 = new Usuario("Amanda M", 700);
		Usuario user13 = new Usuario("Luan R", 9190);
		Usuario user14 = new Usuario("Rafael H", 100);
		Usuario user15 = new Usuario("Maicon J", 3500);
		Usuario user16 = new Usuario("Nilda B", 12000);
		Usuario user17 = new Usuario("Isabel G", 1100);
		Usuario user18 = new Usuario("Bruna C", 10);
		Usuario user19 = new Usuario("Larissa B", 1250);
		Usuario user20 = new Usuario("Isaias |", 1350);
		Usuario user21 = new Usuario("Japa Linguagem", 15940);
		
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
		users.add(user7);
		users.add(user8);
		users.add(user9);
		users.add(user10);
		users.add(user11);
		users.add(user12);
		users.add(user13);
		users.add(user14);
		users.add(user15);
		users.add(user16);
		users.add(user17);
		users.add(user18);
		users.add(user19);
		users.add(user20);
		return users;
		
	}
	
	public void DataLocalDate() {
		
//		maneiraAntiga();n
		LocalDate lc = LocalDate.now();
		System.out.println(lc.getDayOfYear());
		System.out.println(lc.plusMonths(1));
		System.out.println(lc.minusYears(1));
		
		LocalDateTime lct = LocalDateTime.now();
		System.out.println(lct);
		
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		
		LocalTime agora = LocalTime.now();
		LocalDate hoje = LocalDate.now();
		LocalDateTime dataEhora = hoje.atTime(agora);
		
		ZonedDateTime dataComHoraETimezone =
				dataEhora.atZone(ZoneId.of("America/Sao_Paulo"));
		System.out.println(dataComHoraETimezone);
		
		LocalDate date = LocalDate.of(2014, 12, 25);
		LocalDateTime dateTime = LocalDateTime.of(2014, 12, 25, 10, 30);
		
		LocalDateTime agoras = LocalDateTime.now();
		agoras.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
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
