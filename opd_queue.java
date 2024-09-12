import java.util.*;
import java.io.*;
import java.nio.file.*;;
class opd_queue
{
    private static String str="";
    private static int choice = 0;
    private static String arr[] = new String[30];
    private static int i;
    private static int len=0;

    public void accept()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Name - ");
        str = s.nextLine();
        System.out.println("Enter Choice, 1 - Enter, 2 - Delete");
        choice = s.nextInt();
    }
    public void push_element(String s)
    {
        for(i=0;i<30;i++)
        {
            if(arr[i]==null)
            {
                arr[i]=s;
                len++;
                break;
            }
        }
    }
    public void pop_element() throws IOException
    {
        File inputFile = new File("file.txt");
        File tempFile = new File("temp.txt");
        
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        BufferedReader brTest = new BufferedReader(new FileReader(inputFile));
        String text = brTest.readLine();
        
        String lineToRemove = text;
        String currentLine;
        
        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close(); 
        reader.close(); 
        // boolean successful = tempFile.renameTo(inputFile);
        
    }

    public void read_file() throws IOException
    {
        List<String> listOfStrings
            = new ArrayList<String>();
       
        // load the data from file
        listOfStrings
            = Files.readAllLines(Paths.get("C://Personal//VIT//Smart India Hackathon//VITISH 2024//file.txt"));
       
        // convert arraylist to array
        arr= listOfStrings.toArray(new String[0]);
       
        // print each line of string in array
        for (String eachString : arr) {
            System.out.println(eachString);
        }
    }

    public void write_file() throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));
              for(int i = 0; i < len; i++) {
                 writer.write(arr[i].toString());
                 writer.newLine();
              }
              writer.flush();
              System.out.println("Data Entered in to the file successfully");
    }

    public static void main(String args[]) throws IOException
    {
        opd_queue obj = new opd_queue();
        obj.accept();
        if(choice==1)
        {
            obj.push_element(str);
        }
        else
        {
            obj.pop_element();
        }
        System.out.print("C:/Personal/VIT/Smart India Hackathon/VITISH 2024/file.txt");
        System.out.println();
        obj.write_file();
    }
}