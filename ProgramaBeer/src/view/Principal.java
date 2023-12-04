package view;

import controller.ControllerBeer;

public class Principal {

	public static void main(String[] args) {
		String filePath = "C:\\TEMP\\beer.json"; 
        ControllerBeer contBeer = new ControllerBeer();
		contBeer.lerArquivo(filePath);

	}

}
