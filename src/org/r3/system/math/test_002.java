package org.r3.system.math;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

public class test_002
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		double[] kn6y = { 16, 20, 14, 12, 10, 8 ,6 };

		double[] kn6x = { 663.6, 665.3, 674.9, 694.3, 734.8, 835.8, 1005.4 };
		// double[] kn6x = { 673.8, 678.4, 691.3, 715.2, 767.1, 870.1, 1042.2 };
		
	   SplineInterpolator spline = new SplineInterpolator();
	   PolynomialSplineFunction function = spline.interpolate(kn6x, kn6y);
	   	
	   double xCursor = 663.6;
	   while(xCursor <= 1005.4)
	   {
		   System.out.printf("Spline Interpolate for 6Knots %f \t %f\n", xCursor, function.value(xCursor));
		   xCursor += 0.5;
	   }
		    

	}

}
