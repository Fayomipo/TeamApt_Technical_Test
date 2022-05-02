import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Assessment{


    //Here I am declaring and initialising the variables to store the count of numbers for each network with initial value of 0
    private static int MTN = 0;
    private static int Airtel = 0;
    private static int Globacom = 0;
    private static int Ninemobile = 0;
    private static int MTEL = 0;

    //This function accepts the file to be read and reads its content
    static void readFile(String file){

        //declaring variables to store get the number and its code
        String number = "";
        String firstFourDigits = "";
		String firstFiveDigits = "";

        try
        {
            //Using the Scanner method to read the file line by line and getting the file to be used with the FileInputStream method 
            FileInputStream fis = new FileInputStream(file);
            Scanner sc = new Scanner(fis);

            while(sc.hasNextLine())
            {
                number = sc.nextLine();
                firstFourDigits = number.substring(0,4);
				
            //If the number's first four digits is "0702", expand to check for "07025" and "07026"
		if (firstFourDigits.equals("0702")){
			firstFiveDigits = number.substring(0,5);
			checkNumber(number, firstFiveDigits);
		}
		else{
			checkNumber(number, firstFourDigits);
		}
            }

            sc.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //This function uses the code gotten from the readFile function to assign and count the numbers 
    static void checkNumber(String number, String code){

        List<String> MTNCode = Arrays.asList("0703","0706","0803","0806","0810","0813","0814","0816","0903","0906","0913","0916","07025","07026","0704");
        List<String> AirtelCode = Arrays.asList("0701","0708","0802","0808","0812","0901","0902","0904","0907","0912");
        List<String> GlobacomCode = Arrays.asList("0705","0805","0807","0811","0815","0905","0915");
        List<String> NinemobileCode = Arrays.asList("0809","0817","0818","0909","0908");
        List<String> MTELCode = Arrays.asList("0804");


        if(MTNCode.contains(code)){
            MTN += 1;
        }
        else if (AirtelCode.contains(code)){
            Airtel += 1;
        }
        else if(GlobacomCode.contains(code)){
            Globacom += 1;
        }
        else if(NinemobileCode.contains(code)){
            Ninemobile += 1;
        }
        else if(MTELCode.contains(code)){
            MTEL += 1;
        }

    }

    public static void main(String args[]){
		
	int Total_Number;

        Assessment.readFile("PhoneNumbers.txt");

        System.out.println("Total MTN numbers: " + MTN);
        System.out.println("Total Airtel numbers: " + Airtel);
        System.out.println("Total Globacom numbers: " + Globacom);
        System.out.println("Total 9mobile numbers: " + Ninemobile);
        System.out.println("Total MTEL numbers: " + MTEL);
		
	Total_Number = MTN + Globacom + Airtel + Ninemobile +MTEL;
		
	System.out.println("Total numbers checked is: " + Total_Number); 
    }
}
