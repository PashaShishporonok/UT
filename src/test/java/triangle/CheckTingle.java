package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckTingle {
    private Triangle triangle;
    @DataProvider(name= "TriangleParam")
    public Object[][] createSomeData(){
        return new Object[][]{
                {1.0,1.0,5.0},
                {6.0,3.0,3.0},

        };
    }

    @DataProvider(name="ZeroSideParam")
    public Object[][] createSomeData1(){
        return new Object[][]{
                {1.0,1.0,0.0},
                {1.0,0.0,5.0},
                {0.0,1.0,5.0}
        };
    }
    @DataProvider(name="NegativeValuesParam")
    public Object[][] createSomeData2(){
        return new Object[][]{
                {-1.0,1.0,1.0},
                {1.0,-1.0,1.0},
        };
    }


    @Test(dataProvider ="TriangleParam")
    public void checkTriangleInequality(double a,double b, double c){
        triangle = new Triangle(a,b,c);
        Assert.assertFalse(triangle.checkTriangle());

    }

    @Test(dataProvider ="ZeroSideParam")
    public void CheckZeroSide(double a ,double b , double c){
        triangle =  new Triangle(a,b,c);
        Assert.assertFalse(triangle.checkTriangle());

    }
    @Test(dataProvider ="NegativeValuesParam")
    public void CheckNegativeSide(double a , double b , double c){
        triangle= new Triangle(a,b,c);
        Assert.assertFalse(triangle.checkTriangle());
    }


}
