import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<String> list = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader("src/textexample.txt"));
            String text =reader.readLine();

            while (text!=null){
                list.add(text);
                text = reader.readLine();
            }

            reader.close();
        }

        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try {
            File file = new File("newFile");
            FileWriter writer = new FileWriter(file);

            if (!file.exists()){
                file.createNewFile();
            }

            for (int i = 0;i<list.size();i++){
                String text;

                char [] charsList = list.get(i).toCharArray();

                for (int j = 0; j<charsList.length;j++){

                    if (charsList[j]=='-'||charsList[j]=='+'||charsList[j]=='/'||charsList[j]=='*'||charsList[j]=='%'){
                        String number = list.get(i);
                        String sim = String.valueOf(charsList[j]);
                        double a =  Double.parseDouble(number.substring(0, j));
                        double b =  Double.parseDouble(number.substring(j+1));
                        MyOpFactory result = new MyOpFactory();
                        Operation operation = result.getOpInstance(sim);
                        double c = operation.exec(a,b);
                        text = "\n"+a+sim+b+"="+c;
                        writer.append(text);


                    }

                }


            }

            writer.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }


    }
}