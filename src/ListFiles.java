import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class ListFiles {
    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("User did not provide input");
            return;
        }

        String directoryPath=args[0];

        File directory=new File(directoryPath);
        if(!directory.exists()){
            System.out.println("Invalid path (file/directory does not exist)");
            return;
        }

        if(!directory.isDirectory()){
            System.out.println("Invalid path (not a directory)");
            return;
        }
        Set<String> attributes = args.length > 1 ?
                Arrays.stream(Arrays.copyOfRange(args, 1, args.length)).collect(Collectors.toSet())
                : new HashSet<String>();
        var fileList= Arrays.stream(Objects.requireNonNull(directory.listFiles())).toList();
        if (fileList.isEmpty()) {
            System.out.println("This directory is empty");
        }

        for(File file : fileList){
            try {
                BasicFileAttributes attr= Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                StringBuilder currentFile=new StringBuilder();
                currentFile.append(file.getName());
                if(attributes.contains("-s")){
                    currentFile.append(" ").append(attr.size());
                }
                if(attributes.contains("-q")){
                    currentFile.append(" ").append(attr.creationTime());
                }
                System.out.println(currentFile);
            }
            catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
