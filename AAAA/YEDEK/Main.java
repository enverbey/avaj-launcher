import java.io.IOException;

import core.Simulation;
import exception.InvalidFormatException;

class Main {
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
