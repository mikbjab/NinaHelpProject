package TextConvert;

public class TextConvert {
    public static void main(String[] args){
        Paragraphs paragraphs=new Paragraphs();
        paragraphs.read(args[0]);
        paragraphs.write(args[1]);
    }
}
