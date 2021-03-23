import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class writeToCSV {
        FileWriter csvWriter;

        public writeToCSV(String name) throws IOException{
            this.csvWriter = new FileWriter(name+".csv");
            this.csvWriter.append("N");
            this.csvWriter.append(",");
            this.csvWriter.append("Comparism");
            this.csvWriter.append(",");
            this.csvWriter.append("Time(ns)");
            this.csvWriter.append(",");
            this.csvWriter.append("Sort type");
            this.csvWriter.append(",");
            this.csvWriter.append("Data Type");
            this.csvWriter.append("\n");
        }

        public void writeData(List<List<String>> data) throws IOException{
            for (List<String> rowData : data) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
        }
}
