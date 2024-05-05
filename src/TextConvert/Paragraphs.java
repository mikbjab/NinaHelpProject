package TextConvert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Paragraphs {

    private List<String> paragraphs;

    public Paragraphs() {
        this.paragraphs = new ArrayList<>();
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public void read(String filename){
        try {
            File file=new File(filename);
            Scanner scanner = new Scanner(file);

            StringBuilder currentParagraph = new StringBuilder();
            while (scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                if (currentLine.isEmpty()) {
                    paragraphs.add(currentParagraph.toString().trim());
                    System.out.println(currentParagraph);
                    currentParagraph = new StringBuilder();
                } else {
                    currentParagraph.append(currentLine);
                    currentParagraph.append(" ");
                }
            }
            paragraphs.add(currentParagraph.toString().trim());
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void write(String filename){
        try {
            FileWriter fileWriter=new FileWriter(filename,false);
            for(String paragraph:this.paragraphs){
                fileWriter.write(paragraph+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getParagraph(int num){
        return this.paragraphs.get(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraphs that = (Paragraphs) o;
        return paragraphs.equals(that.paragraphs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paragraphs);
    }

}
