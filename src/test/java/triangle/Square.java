package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Square {
    private  Triangle triangle;
@DataProvider
public Object[][]Data(){
        return new Object[][]{
                {3, 4, 5, 6},
                {4, 5, 3, Math.sqrt(36)}
        };
}
@DataProvider
public Object[][] ExceptionData(){
        return new Object[][]{
                {Double.POSITIVE_INFINITY, 3, 4},//Одна сторона рана +бесконечности
                {3,Double.POSITIVE_INFINITY , 4},
                {3,4,Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, 3, 4},//Одна сторона рана -бесконечности
                {3,Double.NEGATIVE_INFINITY , 4},
                {3, 4,Double.NEGATIVE_INFINITY},
                { 0, 3, 4}, // одна из сторон равна 0
                { 5, 0, 4},
                { 5, 3, 0},
        };
    }
    @Test (dataProvider = "ExceptionData", expectedExceptions = Exception.class)
    public void ExceptionTest (double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        triangle.getSquare();
    }
    @Test(dataProvider = "Data")
    public  void SquareCalculate(double a,double b,double c, double result){
        triangle= new Triangle(a,b,c);
        Assert.assertEquals(triangle.getSquare(),result);
    }

}
