package src.main.java.simulation;

import java.io.IOException;
import src.main.java.simulation.core.Simulation;
import src.main.java.simulation.exception.InvalidFormatException;

public class Main {
    public static void main(String[] args)
    {
        if (args.length != 1){
            System.out.println("Kullanım: java Main <dosya_adı>");
            System.out.println("Örnek: java Main scenario.txt");
            return;
        }
        String fileName = args[0];
        Simulation simulation = new Simulation();
        try {
            simulation.openFile(fileName);
            simulation.readAndParse();
            simulation.runSimulation();
        }
        catch (IOException e)
        {
            System.out.println("Dosya açılamadı: " + e.getMessage());
            return;
        }
        catch (InvalidFormatException e)
        {
            System.out.println("Dosya format hatası: " + e.getMessage());
            return;
        }

    }
}