 /**
     * This class use to store tuplle of values that contains exponent and coefficient of a term
*/
public class Tuple {
    private int exponent;
    private double coefficient;

    public Tuple(int exponent,double coefficient){
        this.exponent=exponent;
        this.coefficient=coefficient;
    }

    public int getExponentFromTuple(){
        return this.exponent;
    }
    
    public double getCoefficientFromTuple(){
        return this.coefficient;
    }
}
