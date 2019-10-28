package by.bsu.anasem.labUnitTesting;

import by.bsu.anasem.labUnitTesting.exception.TriangleException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class CheckTriangleTest {

    @DataProvider
    Object[][] zeroSides() {
        return new Double[][] { { 0.0, 1.0, 1.0 }, { 1.0, 0.0, 1.0 }, { 1.0, 1.0, 0.0 }, { 0.0, 0.0, 1.0 },
                { 0.0, 1.0, 0.0 }, { 1.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } };
    }

    @DataProvider
    Object[][] negativeSides() {
        return new Double[][] { { -7.0, 7.0, 7.0 }, { 7.0, -7.0, 7.0 }, { 7.0, 7.0, -7.0 }, { -7.0, -7.0, 7.0 },
                { -7.0, 7.0, -7.0 }, { 7.0, 7.0, -7.0 }, { -7.0, -7.0, -7.0 } };
    }

    @DataProvider
    Object[][] naNSides() {
        return new Double[][] { { Double.NaN, 1.0, 1.0 }, { 1.0, Double.NaN, 1.0 }, { 1.0, 1.0, Double.NaN },
                { Double.NaN, Double.NaN, 1.0 }, { Double.NaN, 1.0, Double.NaN }, { 1.0, Double.NaN, Double.NaN },
                {Double.NaN, Double.NaN, Double.NaN } };
    }

    @DataProvider
    Object[][] negativeInfinitySides() {
        return new Double[][] { { Double.NEGATIVE_INFINITY, 1.0, 1.0 }, { 1.0, Double.NEGATIVE_INFINITY, 1.0 },
                { 1.0, 1.0, Double.NEGATIVE_INFINITY }, { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 1.0 },
                { Double.NEGATIVE_INFINITY, 1.0, Double.NEGATIVE_INFINITY }, { 1.0, 1.0, Double.NEGATIVE_INFINITY },
                { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY } };
    }

    @Test
    public void sumOfTwoSidesGreaterThird() {
        Assert.assertTrue(CheckTriangle.checkTriangleFormed(5.0, 4.0, 3.0));
    }

    @Test
    public void sumOfTwoSidesLessThird() {
        Assert.assertFalse(CheckTriangle.checkTriangleFormed(5.0, 1.0, 3.0));
    }

    @Test
    public void sumOfTwoSidesEqualsThird() { Assert.assertFalse(CheckTriangle.checkTriangleFormed(7.0, 4.0, 3.0)); }

    @Test
    public void isoscelesTriangle() { Assert.assertTrue(CheckTriangle.checkTriangleFormed(10.0, 10.0, 2)); }

    @Test
    public void allSidesAreMaxDouble() { Assert.assertTrue(CheckTriangle.checkTriangleFormed(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)); }

    @Test
    public void negativeScenarioForIsoscelesTriangle() { Assert.assertFalse(CheckTriangle.checkTriangleFormed(2.0, 2.0, 5.0)); }

    @Test(dataProvider = "zeroSides", expectedExceptions = { TriangleException.class })
    public void isDeflectZeroSides(Double a, Double b, Double c) {
        Assert.assertFalse(CheckTriangle.checkTriangleFormed(a, b, c));
    }

    @Test(dataProvider = "negativeSides", expectedExceptions = { TriangleException.class })
    public void isDeflectNegativeSides(Double a, Double b, Double c) {
        Assert.assertFalse(CheckTriangle.checkTriangleFormed(a, b, c));
    }

    @Test(dataProvider = "naNSides", expectedExceptions = { TriangleException.class })
    public void isDeflectNaNSides(Double a, Double b, Double c) {
        Assert.assertFalse(CheckTriangle.checkTriangleFormed(a, b, c));
    }

    @Test(dataProvider = "negativeInfinitySides", expectedExceptions = { TriangleException.class })
    public void isDeflectNegativeInfinitySides(Double a, Double b, Double c) {
        Assert.assertFalse(CheckTriangle.checkTriangleFormed(a, b, c));
    }
}