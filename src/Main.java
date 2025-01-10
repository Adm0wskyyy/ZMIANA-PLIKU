import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        String inputFilePath = "C:\\Users\\alukasiewicz\\Desktop\\STO\\wjescie wyjscie\\input.txt"; //plik źródłowu
        String outputFilePath = "C:\\Users\\alukasiewicz\\Desktop\\STO\\wjescie wyjscie\\output2.txt"; //plik wyjściowy

        processFile(inputFilePath, outputFilePath);
    }

    //przetwarzanie pliku
    private static void processFile(String inputFilePath, String outputFilePath)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath)))
        {
            String line;

            while ((line = reader.readLine()) != null)
            {
                //zastępowanie spacji myślnikami w każdej linii
                writer.write(transformLine(line));
                writer.newLine();
            }
            System.out.println("Plik został przetworzony i zapisany do: " + outputFilePath);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nie odnaleziono pliku wejściowego: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("Błąd przetwarzania pliku: " + e.getMessage());
        }
    }

    //metoda do przekształcania linii tekstu
    private static String transformLine(String line)
    {
        return line.replace(" ", "-");
    }
}