
import java.util.Scanner; // This import is for the Scanner utility, used for user inputs in this context.
import java.io.File; //This allows the programme to input and output to system files.
import javafx.application.Application; //Provides the application life-cycle classes.
import javafx.scene.Scene; // The scene is the window that appears with content in it.
import javafx.scene.chart.BarChart; // This allows for a bar chart to be initialised.
import javafx.scene.chart.CategoryAxis; //This allows for a string axis to be created.
import javafx.scene.chart.NumberAxis; //This allows for a number axis to be created.
import javafx.scene.chart.XYChart; // This is the chart base class for the 2 axis class.
import javafx.scene.layout.VBox; // Lays out bars in single vertical columns.
import javafx.stage.Stage; //the top level JavaFX container.

public class ass1 extends Application{
  public static  int[] alphabet = new int[27]; //This is the array to count the letters,
    // it is declared at class level so it is accessible to both methods

    public static void main(String[] args) throws Exception { //this is the main method that populates the array.
        //FileReader fileReader = new FileReader("jc.txt");
        String fileContents = "";
        int iLines = 0;
        File file = new File("jc.txt"); //This retrieves the file from its path

        Scanner sc = new Scanner(file); //This scans through the file
        while (sc.hasNextLine()) { //The loop runs until there is an empty line
            String stLine = sc.nextLine(); //This line takes the next line and puts it into a string
            int iLength = stLine.length(); //This gets the length of the line for the 'for' loop
            for (int i = 0; i < iLength; i++) { //This loop runs until the end of the current line.
                char currentLetter = stLine.charAt(i); //This takes the next letter in the line.
                int ascVal = (int) currentLetter; //This converts the current letter to ASCII.
                if (ascVal >= 65 && ascVal <= 90) { //If ASCII is between A and Z (Upper case)
                    alphabet[ascVal - 64] += 1; //Increase the correct array value
                } else if (ascVal >= 97 && ascVal <= 122) { //If ASCII is between a and z (Lower case)
                    alphabet[ascVal - 96] += 1;
                } else {// Else, if its not a letter it must be a special character
                    alphabet[0] += 1;//alphabet[0] is the special characters
                }
            }
            fileContents += "\n" + stLine;//adds a new line for the text file to be printed.
            iLines++; //increments the line its on.
        }
        System.out.println(fileContents); //Prints out the whole file
        System.out.println(iLines); //This prints out the number of lines
        System.out.println("jc.txt contains " + iLines + " lines.");

        /*try{
        for (int i = 0; i < 26 ; i++) {
            System.out.println(alphabet[i]);
        }} catch (Exception e){
            System.err.println(e.getStackTrace());
        }*/
        /*try {
            for (int n = 0; n < 27; n++) {
                System.out.println("alphabet[" + n + "] : " + alphabet[n]);
            }
        } catch (Exception e) {
            System.err.println();
        }
*/
        try{
        for (int n = 0;n<27;n++){ //This loop prints out the entire array
            if (n==0){
                System.out.println("alphabet[ Special Characters ] : " + alphabet[n]);
            } else {

                System.out.println("alphabet[" + (char) (n + 64) + "] : " + alphabet[n]);
            }
        }} catch (Exception e) {
            System.err.println();
        }
        //Histogram
        /*I am not sure if a histogram is the right chart to use in this context.
        The graph i created is my interpretation of what is needed to represent the data.
        I have used a bar char because each letter is a category and it makes sense to have gaps
        to distinguish between the individual letters. Histograms are used for number ranges
        which is why there are no gaps so i believe a bar chart better represents what the task
        requires.
         */
        Application.launch(args); //This launches the scene containing the bar chart.
    }


    public  void start(Stage stage) {
        stage.setTitle("Bar Chart"); //This is the title of the stage, what will be shown at the top of the window
        final CategoryAxis xAxis = new CategoryAxis(); //The category axis is for creating a string axis
        final NumberAxis yAxis = new NumberAxis();//The nummber axis is for creating a numerical axis
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Letter Appearances"); //This sets the title of the chart
        xAxis.setLabel("Letters"); //This sets the title of the x-axis, the letters.
        yAxis.setLabel("Amount of appearances"); //This sets the title of the y-axis.

        XYChart.Series series1 = new XYChart.Series(); //This creates a series, a set of bars
        /*
        As the number of letters in the alphabet does not change,
        it is best to hard code the Nodes of the chart as it will
         not change in future and there is no need for modification.
        */
        series1.getData().add(new XYChart.Data("Special Characters", alphabet[0]));
        series1.getData().add(new XYChart.Data("A", alphabet[1]));
        series1.getData().add(new XYChart.Data("B", alphabet[2]));
        series1.getData().add(new XYChart.Data("C", alphabet[3]));
        series1.getData().add(new XYChart.Data("D", alphabet[4]));
        series1.getData().add(new XYChart.Data("E", alphabet[5]));
        series1.getData().add(new XYChart.Data("F", alphabet[6]));
        series1.getData().add(new XYChart.Data("G", alphabet[7]));
        series1.getData().add(new XYChart.Data("H", alphabet[8]));
        series1.getData().add(new XYChart.Data("I", alphabet[9]));
        series1.getData().add(new XYChart.Data("J", alphabet[10]));
        series1.getData().add(new XYChart.Data("K", alphabet[11]));
        series1.getData().add(new XYChart.Data("L", alphabet[12]));
        series1.getData().add(new XYChart.Data("M", alphabet[13]));
        series1.getData().add(new XYChart.Data("N", alphabet[14]));
        series1.getData().add(new XYChart.Data("O", alphabet[15]));
        series1.getData().add(new XYChart.Data("P", alphabet[16]));
        series1.getData().add(new XYChart.Data("Q", alphabet[17]));
        series1.getData().add(new XYChart.Data("R", alphabet[18]));
        series1.getData().add(new XYChart.Data("S", alphabet[19]));
        series1.getData().add(new XYChart.Data("T", alphabet[20]));
        series1.getData().add(new XYChart.Data("U", alphabet[21]));
        series1.getData().add(new XYChart.Data("V", alphabet[22]));
        series1.getData().add(new XYChart.Data("W", alphabet[23]));
        series1.getData().add(new XYChart.Data("X", alphabet[24]));
        series1.getData().add(new XYChart.Data("Y", alphabet[25]));
        series1.getData().add(new XYChart.Data("Z", alphabet[26]));


        bc.getData().add(series1);

        VBox vbox = new VBox(bc);

        Scene scene = new Scene(vbox, 400, 200);

        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(1000);

        stage.show();
    }
}






