package by.bsu.anasem.lab_unit_testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckTriangleTest {

    @Test
    public void sumOfTwoSidesGreaterThird() {
        Assert.assertTrue(CheckTriangle.checkTriangleFormed(5.0, 4.0, 3.0));
    }

    @Test
    public void oneNegativeSide() {
        Assert.assertFalse(CheckTriangle.checkTriangleFormed(-4.0, 10.0, 15.0));
    }

    @Test
    public void sumOfTwoSidesEqualsThird() { Assert.assertFalse(CheckTriangle.checkTriangleFormed(7.0, 4.0, 3.0)); }

    @Test
    public void sumOfTwoSidesLessThird() {
        Assert.assertFalse(CheckTriangle.checkTriangleFormed(5.0, 1.0, 3.0));
    }

    @Test
    public void oneZeroSide() { Assert.assertFalse(CheckTriangle.checkTriangleFormed(0.0, 4.0, 3.0)); }

    @Test
    public void allSidesAreNegative() {
        Assert.assertFalse(CheckTriangle.checkTriangleFormed(-0.6, -0.4, -0.3));
    }

    @Test
    public void obtuseTriangle() { Assert.assertTrue(CheckTriangle.checkTriangleFormed(9, 5, 6)); }

    @Test
    public void allZeroSides() {
        Assert.assertFalse(CheckTriangle.checkTriangleFormed(0.0, 0.0, 0.0));
    }

    @Test
    public void isoscelesTriangle() { Assert.assertTrue(CheckTriangle.checkTriangleFormed(10.0, 10.0, 2));    }

    @Test
    public void equilateralTriangle() {
        Assert.assertTrue(CheckTriangle.checkTriangleFormed(5.0, 5.0, 5.0));
    }
}