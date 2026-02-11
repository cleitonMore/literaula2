package com.example.literaula2;

import com.example.literaula2.console.MenuConsole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Literaula2Application implements CommandLineRunner {

    private final MenuConsole menuConsole;

    public Literaula2Application(MenuConsole menuConsole) {
        this.menuConsole = menuConsole;
    }

    public static void main(String[] args) {
        SpringApplication.run(Literaula2Application.class, args);
    }

    @Override
    public void run(String... args) {
        menuConsole.iniciar();
    }
}
