import java.util.Iterator;

/**
 * Polynomial
 */
public class Polynomial implements Iterable<Polynomial>, Comparable<Polynomial> {

    /**
     * The static Inner Node class for store exponent and coefficient of one term
     */
    static class Node {

        private int exponent;
        private double coefficient;
        private Node next;
        
        public Node(int exponent,double coefficient){
            this.exponent = exponent;
            this.coefficient = coefficient;
        }


        // getter for exponent
        public int getExponent() {
            return this.exponent;
        }

        // getter for coefficient
        public double getCoefficient() {
            return this.coefficient;
        }

        // getter for next node
        public Node getNextNode(){
            return this.next;
        }

        // setter for next node
        public void setNextNode(Node node){
            this.next=node;
        }

        // //setter for exponent
        // public void setExponent(int exponent){
        //     this.exponent = exponent;
        // }

        // // setter for coefficient
        // public void setCoefficient(double coefficient){
        //     this.coefficient = coefficient;
        // }
    }

    private Polynomial.Node headNode;

    public Polynomial(String polynomial) throws InvalidPolynomialSyntax {
        
        try {
            String[] list = polynomial.split(" ");

            if (list.length%2!=0 &&  list.length!=0) {
                // polynomial string check
                throw new InvalidPolynomialSyntax("Error in polynomial format");
            }
            this.headNode=new Polynomial.Node(Integer.parseInt(list[1]),Double.parseDouble(list[0]));
            Polynomial.Node tempNode=this.headNode;

            for (int i = 2; i < list.length; i=i+2) {
                tempNode.setNextNode(new Polynomial.Node(Integer.parseInt(list[i]),Double.parseDouble(list[i+1])));
                tempNode=tempNode.getNextNode();
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
            throw new InvalidPolynomialSyntax("Error in polynomial format");
        }
    }

    @Override
    public Iterator<Polynomial> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int compareTo(Polynomial o) {
        // TODO Auto-generated method stub
        return 0;
    }
}