import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

class ReadFile{
    public static void main(String[] args) throws Exception {
    //FileReader fileReader = new FileReader("jc.txt");
    String fileContents = "";
    int iLines=0;
    String stLine = "";
    String stChar = "";
    File file = 
new File("jc.txt");
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()){
        stLine = sc.nextLine();
        int iLength = stLine.length();
        int[] alphabet = new int[27];
        for (int i=1; i < iLength;i++){
            
            char currentLetter = stLine.charAt(i);
            int ascVal = (int) currentLetter;
            if (ascVal>= 65 && ascVal<=90){
            
                alphabet[ascVal-64] +=1;
            
            }else if (ascVal >= 97 && ascVal <=122){
            
                alphabet[ascVal-96] +=1;
            
            }else{
                
                alphabet[0] +=1;
            
                }
            
            }
        fileContents+= "\n" + stLine ;
       iLines++;
        }
        System.out.println(fileContents);
        System.out.println(iLines);
        System.out.println("jc.txt contains " + iLines + " lines.");
        
        for (int n = 0;n<7;n++){
           // int x =alphabet[n];
            System.out.println("alphabet[" + n + "] : "  + alphabet[n]);
            
            }
        
    
    }
}
