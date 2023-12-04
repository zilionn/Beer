package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControllerBeer {

	public ControllerBeer() {
		super();
	}
	
	public void lerArquivo(String arquivo) {
        try (BufferedReader ler = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = ler.readLine()) != null) {
                exibe(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibe(String linha) {
        String[] elementos = linha.split("\"id\":");

        for (int i = 1; i < elementos.length; i++) {
            String[] campos = elementos[i].split(",");

            String name = "";
            String tagline = "";
            String firstBrewed = "";
            String description = "";
            
            for (String campo : campos) {
                if (campo.contains("\"name\":")) {
                    name = extrairValor(campo);
                } else if (campo.contains("\"tagline\":")) {
                    tagline = extrairValor(campo);
                } else if (campo.contains("\"first_brewed\":")) {
                    firstBrewed = extrairValor(campo);
                } else if (campo.contains("\"description\":")) {
                    description = extrairValor(campo);
                }
            }

            System.out.println("Name: " + name);
            System.out.println("Tagline: " + tagline);
            System.out.println("First Brewed: " + firstBrewed);
            System.out.println("Description: " + description);
            System.out.println("-----------------------------------------");
        }
    }

    private String extrairValor(String campo) {
        int inicio = campo.indexOf(":") + 1;
        return campo.substring(inicio).replace("\"", "").trim();
    }
}