package simulation.core;

import java.io.*;
import java.util.*;
import simulation.aircraft.FlyableData;
import simulation.exception.InvalidFormatException;
import simulation.weather.WeatherTower;

public class Simulation {

    private File file;
    private BufferedReader reader;
    private int simulationCycles;
    private List<FlyableData> flyables = new ArrayList<>();

    public void openFile(String fileName) throws IOException {
        file = new File(fileName);
        if (!file.exists() || !file.canRead()) {
            throw new FileNotFoundException("Dosya bulunamadı veya okunamıyor: " + fileName);
        }
        reader = new BufferedReader(new FileReader(file));
    }

    public void readAndParse() throws IOException, InvalidFormatException {
        String line;
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
            lineNumber++;
            line = line.trim();
            if (line.isEmpty()) continue;

            if (lineNumber == 1) {
                try {
                    simulationCycles = Integer.parseInt(line);
                    if (simulationCycles <= 0) {
                        throw new InvalidFormatException("Simülasyon döngü sayısı pozitif olmalıdır.");
                    }
                } catch (NumberFormatException e) {
                    throw new InvalidFormatException("İlk satır geçerli bir pozitif tamsayı olmalıdır.");
                }
                continue;
            }

            String[] parts = line.split("\\s+");
            if (parts.length != 5) {
                throw new InvalidFormatException("Satır " + lineNumber + ": Format hatası. 5 öğe bekleniyordu.");
            }

            String type = parts[0];
            String name = parts[1];

            if (!isValidType(type)) {
                throw new InvalidFormatException("Satır " + lineNumber + ": Geçersiz uçuş tipi: " + type);
            }

            int longitude = parsePositiveInt(parts[2], lineNumber, "LONGITUDE");
            int latitude = parsePositiveInt(parts[3], lineNumber, "LATITUDE");
            int height = parsePositiveInt(parts[4], lineNumber, "HEIGHT");

            if (height > 100) {
                System.err.println("\u001B[31mSatır " + lineNumber + ": HEIGHT 0 ile 100 arasında olmalıdır.\u001B[0m");
                continue;
            }

            flyables.add(new FlyableData(type, name, longitude, latitude, height));
        }

        if (flyables.isEmpty()) {
            throw new InvalidFormatException("Hiçbir uçuş nesnesi tanımlanmadı.");
        }
    }

    private boolean isValidType(String type) {
        return type.equals("Baloon") || type.equals("JetPlane") || type.equals("Helicopter");
    }

    private int parsePositiveInt(String value, int lineNumber, String fieldName) throws InvalidFormatException {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new InvalidFormatException("Satır " + lineNumber + ": " + fieldName + " negatif olamaz.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("Satır " + lineNumber + ": " + fieldName + " geçerli bir sayı olmalıdır.");
        }
    }

    public int getSimulationCycles() {
        return simulationCycles;
    }

    public List<FlyableData> getFlyables() {
        return flyables;
    }

    public void runSimulation() {

        WeatherTower weatherTower = new WeatherTower();
      
      
    }
}
