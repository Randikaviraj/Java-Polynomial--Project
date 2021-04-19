/**
 * AUTHOR :
 * 
 * PROJECT NAME:
 * 
 * DATE :
 * 
 * SHORT DISCRIPTION :
 * 
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Polynomial
 */
public class Polynomial implements Iterable<Tuple>, Comparable<Polynomial> {

    /**
     * The static Inner Node class for store exponent and coefficient of one term
     */
    static class Node {

        private int exponent;
        private double coefficient;
        private Node next=null;
        
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
            int earlyexponent=Integer.parseInt(list[1]);
            Polynomial.Node tempNode=this.headNode;

            for (int i = 2; i < list.length; i=i+2) {
                
                if (earlyexponent<Integer.parseInt(list[i+1])) {
                    throw new InvalidPolynomialSyntax("Error in polynomial format");
                }
                earlyexponent=Integer.parseInt(list[i+1]);
                tempNode.setNextNode(new Polynomial.Node(Integer.parseInt(list[i+1]),Double.parseDouble(list[i])));
                tempNode=tempNode.getNextNode();
            }
            
            
        } catch (RuntimeException e) {
            //TODO: handle exception
            System.out.println(e);
            throw new InvalidPolynomialSyntax("Error in polynomial format");
        }
    }

    @Override
    public Iterator<Tuple> iterator() {
        // TODO Auto-generated method stub
        ArrayList<Tuple> list =new ArrayList<Tuple>();
        Polynomial.Node temp=this.headNode;
        while (temp!=null) {
            list.add(new Tuple(temp.getExponent(), temp.getExponent()));
            temp=temp.getNextNode();
        }
        return list.iterator();
    }



    @Override
    public int compareTo(Polynomial o) {
        // TODO Auto-generated method stub
        Polynomial.Node tempOfPolynomial1=this.headNode;
        Polynomial.Node tempOfPolynomial2=o.getHeadNode();
        while (tempOfPolynomial1!=null && tempOfPolynomial2!=null) {
            if (tempOfPolynomial1.getExponent()>tempOfPolynomial2.getExponent()) {
                return 1;
            } else if (tempOfPolynomial1.getExponent()<tempOfPolynomial2.getExponent()) {
                return -1; 
            }
            if (tempOfPolynomial1.getCoefficient()>tempOfPolynomial2.getCoefficient()) {
                return 1;
            } else if (tempOfPolynomial1.getCoefficient()<tempOfPolynomial2.getCoefficient()) {
                return -1; 
            }
    
            tempOfPolynomial1=tempOfPolynomial1.getNextNode();
            tempOfPolynomial2=tempOfPolynomial2.getNextNode();
        }


        if (tempOfPolynomial1==null && tempOfPolynomial2==null) {
            return 0; 
        }else if(tempOfPolynomial1==null){
            return -1;
        }else{
            return 1;
        }
        
    }

    @Override
    public String toString() {
        String polynomial="";
        Polynomial.Node temp =this.headNode;
        while (temp.getNextNode()!=null) {
            if (temp.getCoefficient()!=0.0) {
                if (temp.getExponent()!=1) {
                    polynomial=polynomial+Double.toString(temp.getCoefficient())+"X^"+Integer.toString(temp.getExponent())+"+";
                }else{
                    polynomial=polynomial+Double.toString(temp.getCoefficient())+"X"+"+";
                }
            }
            temp=temp.getNextNode();
        }

        if (temp.getExponent()!=0) {
            polynomial=polynomial+Double.toString(temp.getCoefficient())+"X^"+Integer.toString(temp.getExponent());
        }else{
            polynomial=polynomial+Double.toString(temp.getCoefficient());
        }
        
        return polynomial;
    }

    // getter for head node
    public Polynomial.Node getHeadNode(){
        return this.headNode;
    }
}