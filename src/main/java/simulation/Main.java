package simulation;

import simulation.exception.InvalidFormatException;
import simulation.core.Simulation;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        String fileName = "scenario.txt";
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