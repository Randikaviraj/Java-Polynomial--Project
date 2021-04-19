import java.util.Iterator;

/**
 * AUTHOR :
 * 
 * PROJECT NAME:
 * 
 * DATE :
 * 
 * SHORT DISCRIPTION :Test class ,use to check funtionality of Polynomial and OrderdList class
 *                    All test cases are included in main method
 * 
 * 
 * 
 * 
 */

public class Test {
    public static void main(String[] args) throws Exception{
        int passedtest=0;
        int failedtest=0;
        
        try {
            System.out.println("Test No 1");
            Polynomial p=new Polynomial("4.0 3 2.5 1 8.0 0"); 
            assert p !=null;
            passedtest++;
            System.out.println("Test No 1 Passed");
        } catch (AssertionError e) {
            System.out.println("Test No 1 Failed");
            failedtest++;
        }

        try {
            System.out.println("Test No 2");
            Polynomial pp=new Polynomial("4.0 3 2.5 1 8.0 0"); 
            Iterator<Tuple> iterator=pp.iterator();
            Tuple t;
            while (iterator.hasNext()) {
                t=iterator.next();
                System.out.println(t.getCoefficientFromTuple()+"  "+t.getExponentFromTuple());
            }
            passedtest++;
            System.out.println("Test No 2 Passed");
        } catch (Exception e) {
            System.out.println("Test No 2 Failed");
            failedtest++;
        }

        try {
            System.out.println("Test No 3");
            Polynomial p=new Polynomial("4.0 3 2.5 1 8.0 "); 
            System.out.println("Test No 3 Failed");
            failedtest++;
        } catch (InvalidPolynomialSyntax e) {
            System.out.println("Test No 3 Passed");
            passedtest++;
        }catch(Exception e){
            System.out.println("Test No 3 Failed");
            failedtest++;
        }

        try {
            System.out.println("Test No 4");
            Polynomial p1=new Polynomial("4.0 3 2.5 1 8.0 0"); 
            Polynomial p2=new Polynomial("4.0 4 2.5 1 8.0 0"); 
            Polynomial p3=new Polynomial("5.0 3 2.5 1 8.0 0"); 
            Polynomial p4=new Polynomial("4.0 3 2.5 2 8.0 0"); 
            assert p1.compareTo(p2) < 1;
            assert p1.compareTo(p3) < 1;
            assert p4.compareTo(p1) > 1;
            passedtest++;
            System.out.println("Test No 4 Passed");
        } catch (AssertionError e) {
            System.out.println("Test No 4 Failed");
            failedtest++;
        }

        try {
            System.out.println("Test No 5");
            Polynomial p=new Polynomial("4.0 3 2.5 1 8.0 0"); 
            assert p.toString().compareTo("4.0X^3+2.5X+8.0")==0;
            System.out.println(p.toString());
            passedtest++;
            System.out.println("Test No 5 Passed");
        } catch (AssertionError e) {
            System.out.println("Test No 5 Failed");
            failedtest++;
        }

        System.out.println("=========================================================================");
        System.out.println("No of test cases passed :"+passedtest);
        System.out.println("No of test cases failed :"+failedtest);

    }
}
