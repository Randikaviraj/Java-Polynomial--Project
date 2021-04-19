import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws IOException{
       
        System.out.println("Enter yes to run program or no to exit :");
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in)); 
        String answeString;
        while (true) {
            answeString=reader.readLine();
            if (answeString.equals("yes")) {
                break;
            }else if(answeString.equals("no")){
                return;
            }
            System.out.println("Incorrect argument::Enter yes or no");
        }

        // JFileChooser points to user's default directory
        JFileChooser j = new JFileChooser();
        // Open the save dialog
        j.showSaveDialog(null);
        //Create Polynomial ArrayList 
        ArrayList<Polynomial> polynomialList = new ArrayList<>();
        //Set to show both directories and files
        j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int res = j.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION){
            
            try {  
                // open the file and read lines from file
                File file = j.getSelectedFile();
                Scanner scanner = new Scanner(file);
                String polynomialString =null; 
                Polynomial polynomial=null;
                if (file.isFile()){
                    while (scanner.hasNextLine()){
                        polynomialString=scanner.nextLine();
                        polynomial=new Polynomial(polynomialString);
                        System.out.println("Polynomial :: "+polynomial.toString());
                        polynomialList.add(polynomial);//add polynomials to polynomial list
                    }
                }
            }catch (InvalidPolynomialSyntax err){
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Error in polynomial format of file!");
                return;
            }catch(FileNotFoundException exception){
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"File is not found!");
                return;
            }catch(Exception exception){
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Something wrong!");
                return;
            }

            System.out.println("Weak order sorting result :"+Main.checkWeakOrder(polynomialList));
            System.out.println("Strong order sort result :"+OrderedList.checkSorted(polynomialList));
        }

    }

    // Method to checked to see whether it is in sorted order according to Weak order (exponents only)
    public static boolean checkWeakOrder( List<Polynomial> polyList){
        Iterator<Tuple> iterator_poly_prev=null;
        Iterator<Tuple> iterator_poly_current=null;
        Tuple tuple_of_prevpoly;
        Tuple tuple_of_currentpoly;
        for (int i = 1; i < polyList.size(); i++) {
            iterator_poly_prev=polyList.get(i-1).iterator();
            iterator_poly_current=polyList.get(i).iterator();
            
            while (iterator_poly_current.hasNext() || iterator_poly_prev.hasNext()) {
                if (!iterator_poly_current.hasNext()) {
                    return false;
                }else if(!iterator_poly_prev.hasNext()){
                    break;
                }

                tuple_of_currentpoly=iterator_poly_current.next();
                tuple_of_prevpoly=iterator_poly_prev.next();


                if (tuple_of_currentpoly.getExponentFromTuple()>tuple_of_prevpoly.getExponentFromTuple()) {
                    break;
                }else if (tuple_of_currentpoly.getExponentFromTuple()<tuple_of_prevpoly.getExponentFromTuple()) {
                   return false; 
                }
            }
        }
        return true;
    }
}
