package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DetectedTriangle {
    final int TR_ISOSCELES = 2;   // равнобедренный
    final int TR_ORDINARY = 4;    // обычный
    final int TR_RECTANGULAR = 8; // прямоугольный
    final int TR_EQUILATERAL_ISOSCELES=3;//равнобедренный и равносторонний
    final int TR_ISOSCELES_RECTANGULAR = 10;   // равнобедренный + прямоугольный
    private Triangle triangle;

    @DataProvider
    public Object [][] DataISOSCELES(){
        return new Object[][]{
                {4.0,4.0,5.0},
                {5.0,4.0,5.0},
                {6.0,4.0,6.0},
        };
    }

    @DataProvider
    public Object [][] Data_EQUILATERAL(){
        return new Object[][]{
                {1.0,1.0,1.0},

        };
    }
    @DataProvider
    public Object[][] Data_ORDINARY(){
        return new Object[][]{
                {1.0,2.0,4.0}
        };
    }
    @DataProvider
    public Object [][] DataRECTANGULAR(){
        return  new Object[][]{
                {3.0, 4.0, 5.0},
                {5.0, 3.0, 4.0},
                {4.0, 5.0, 3.0},


        };
    }

    @DataProvider
    public Object[][] DataisoscelesRectangular(){
        return new Object[][]{
                {1.0, 1.0, Math.sqrt(2)},
                {Math.sqrt(2), 1.0, 1.0},
                {1.0, 1.0, Math.sqrt(2)},
        };
    }
    @Test(dataProvider ="DataISOSCELES" )
    public void detectISOSCELES(double a,double b, double c){
        triangle= new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(),TR_ISOSCELES);
    }

    @Test(dataProvider="Data_EQUILATERAL")
    public void detectedEQUILATERAL(double a ,double b , double c){
        triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(),TR_EQUILATERAL_ISOSCELES );
    }
    @Test(dataProvider = "Data_ORDINARY")
    public void dectedOrdinary(double a,double b ,double c){
        triangle= new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(),TR_ORDINARY);
    }
    @Test(dataProvider ="DataRECTANGULAR")// тест фэйлится ,проблема в формуле подсчёта if ((a*a+b*b == c*c) || (b*b + c*c == a*a)||(a*a + c*c == b*c)).
    public void detectedRectangular(double a, double b , double c){
        triangle= new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(),TR_RECTANGULAR);
    }
    @Test(dataProvider = "DataisoscelesRectangular")//Тест фэйлится , проблема с округлением
    public void detectIsoscelesRectangularTest(double a, double b, double c){
        triangle = new Triangle(a,b,c);
        Assert.assertEquals(triangle.detectTriangle(), TR_ISOSCELES_RECTANGULAR);
    }
}
