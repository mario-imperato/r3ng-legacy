package org.r3.system.math;

import java.awt.geom.Point2D;

public class lagrange_test
{
    public static double findPoint(double angle, double beatAngle, double beatVMG, double gybeAngle, double runVMG, Point2D[] points)
    {
    	int numberOfPoints = points.length;
    	
    	if (angle == 0)
    		return beatVMG;
    	
    	if (angle <= beatAngle)
    		return beatVMG*Math.cos(angle*Math.PI/180.0);
    	
    	if (angle >= gybeAngle)
    		return Math.abs(runVMG*Math.cos(angle*Math.PI/180.0));
    	
    	Point2D[] nearestPoints = null;
    	for(int i = 0; i < numberOfPoints; i++)
    	{
    		if (angle >= points[i].getX())
    		{
    			if ((numberOfPoints - i) == 2)
    			{
    				nearestPoints = new Point2D[3];
    				nearestPoints[0] = points[i - 1];
        			
    				nearestPoints[1] = points[i];
        			nearestPoints[2] = points[i + 1];
    			}
    			else
    			{
    				nearestPoints = new Point2D[3];
    			nearestPoints[0] = points[i];
    			nearestPoints[1] = points[i + 1];
    			nearestPoints[2] = points[i + 2];
    			}
    		}
    	}
    	
   		double v = lagrange(angle, nearestPoints);    		    
	    return v;    	
    }

	public static double lagrange(double angle, Point2D[] points)
    {
    	double v = 0;
    	
    	int numberOfPoints = points.length;
    	
	    for (int i = 0; i < numberOfPoints; i++) {
	        double mult = 1;
	        for (int j = 0; j < numberOfPoints; j++) {

	            if (j != i) {
	                mult *= (angle - points[j].getX()) / (points[i].getX() - points[j].getX());
	            }
	        }   
	            v += mult * points[i].getY();

	    }
	    
	    return v;    	
    }
    
	public static void main(String[] args) 
	{
		double[] kn6x = { 43.2, 52, 60, 75, 90, 110, 120, 135, /* 150, */ 143.90 };

		double[] kn6y = { 1048.90 * Math.cos(43.2 * Math.PI / 180), 685.00, 646.00, 615.80, 623.40, 634.40, 657.70, 738.90, /* 886.20, */
						1023.30 * Math.cos(143.90 * Math.PI / 180) };

		
		Point2D[] kn6 = {
						// new Point2D.Double(43.2    , 1048.90),  
						new Point2D.Double(43.2    , 1048.90 * Math.cos(43.2*Math.PI/180)),  
						new Point2D.Double(52      ,  685.00),   
						new Point2D.Double(60      ,  646.00),   
						new Point2D.Double(75      ,  615.80),   
						new Point2D.Double(90      ,  623.40),   
						new Point2D.Double(110     ,  634.40),   
						new Point2D.Double(120     ,  657.70),   
						new Point2D.Double(135     ,  738.90),   
						new Point2D.Double(150     ,  886.20),   
//						new Point2D.Double(143.90  , 1023.30)   
						};

		Point2D[] kn8 = {
						// new Point2D.Double(42.2   , 871.1 ),      
						new Point2D.Double(42.2   , 871.1 * Math.cos(42.2*Math.PI/180)), 
						new Point2D.Double(52     , 575.8 ),      
						new Point2D.Double(60     , 546   ),      
						new Point2D.Double(75     , 525.6 ),      
						new Point2D.Double(90     , 520.4 ),      
						new Point2D.Double(110    , 524.2 ),      
						new Point2D.Double(120    , 541.8 ),      
						new Point2D.Double(135    , 603.7 ),      
						new Point2D.Double(150    , 701.4 ),      
						// new Point2D.Double(149.5  , 809.9 )
						};
		
		Point2D[] kn10 = {
						// new Point2D.Double(41.9   , 62.3  ),   
						new Point2D.Double(41.9   , 62.3 * Math.cos(41.9*Math.PI/180) ),
						new Point2D.Double(52     , 513.4 ),      
						new Point2D.Double(60     , 497.6 ),      
						new Point2D.Double(75     , 487.4 ),      
						new Point2D.Double(90     , 481   ),      
						new Point2D.Double(110    , 480.9 ),      
						new Point2D.Double(120    , 489.2 ),      
						new Point2D.Double(135    , 523.2 ),      
						new Point2D.Double(150    , 592.9 ),      
						new Point2D.Double(154.3  , 683.1 )};

						Point2D[] kn12 = {
						// new Point2D.Double(40.1  , 708.2 ),    
						new Point2D.Double(40.1  , 708.2 * Math.cos(40.1*Math.PI/180) ),  
						new Point2D.Double(52    , 491   ),    
						new Point2D.Double(60    , 477.6 ),    
						new Point2D.Double(75    , 467.7 ),    
						new Point2D.Double(90    , 468.3 ),    
						new Point2D.Double(110   , 457.1 ),    
						new Point2D.Double(120   , 464.1 ),    
						new Point2D.Double(135   , 484.8 ),    
						new Point2D.Double(150   , 522.7 ),    
						new Point2D.Double(161.4 , 595.1 )} ;   


						Point2D[] kn14 = {     
						// new Point2D.Double(38.9   , 682.3  ),    
						new Point2D.Double(38.9   , 682.3 * Math.cos(38.9*Math.PI/180)  ),
						new Point2D.Double(52     , 482.8  ),    
						new Point2D.Double(60     , 470    ),    
						new Point2D.Double(75     , 453.6  ),    
						new Point2D.Double(90     , 454.2  ),    
						new Point2D.Double(110    , 435.6  ),    
						new Point2D.Double(120    , 443.1  ),    
						new Point2D.Double(135    , 462.4  ),    
						new Point2D.Double(150    , 486    ),    
						new Point2D.Double(173.6  , 530.8  )};    

						Point2D[] kn16 = {
						// new Point2D.Double(38      ,                                            667.5 ),    
						new Point2D.Double(38      ,                                            667.5 * Math.cos(38*Math.PI/180)),
						new Point2D.Double(52      ,                                            478.1 ),     
						new Point2D.Double(60      ,                                            465.5 ),     
						new Point2D.Double(75      ,                                            445.6 ),     
						new Point2D.Double(90      ,                                            439.5 ),     
						new Point2D.Double(110     ,                                            420.8 ),     
						new Point2D.Double(120     ,                                            421.3 ),     
						new Point2D.Double(135     ,                                            441.6 ),     
						new Point2D.Double(150     ,                                            463.9 ),     
						new Point2D.Double(178.1   ,                                         491.9    )};  

						Point2D[] kn20 = {                           
						// new Point2D.Double(38.4    ,                                          662.3      ),
						new Point2D.Double(38.4    ,                                          662.3 *  Math.cos(38.4*Math.PI/180)),
						new Point2D.Double(52      ,                                              473.7  ),
						new Point2D.Double(60      ,                                              461.4  ),
						new Point2D.Double(75      ,                                              438.7  ),
						new Point2D.Double(90      ,                                              416.9  ),
						new Point2D.Double(110     ,                                              403.3  ),
						new Point2D.Double(120     ,                                              390.1  ),
						new Point2D.Double(135     ,                                              400    ),
						new Point2D.Double(150     ,                                              423.5  ),
						new Point2D.Double(179     ,                                            448.8    )};
		
                       double angle = 44;
//					   System.out.printf("Interpolate for 6Knots %f, %f\n", angle, lagrange(angle, kn6));
//					   System.out.printf("Interpolate for 8Knots %f, %f\n", angle, lagrange(angle, kn8));
//					   System.out.printf("Interpolate for 10Knots %f, %f\n", angle, lagrange(angle, kn10));
//					   System.out.printf("Interpolate for 12Knots %f, %f\n", angle, lagrange(angle, kn12));
//					   System.out.printf("Interpolate for 14Knots %f, %f\n", angle, lagrange(angle, kn14));
//					   System.out.printf("Interpolate for 16Knots %f, %f\n", angle, lagrange(angle, kn16));
//					   System.out.printf("Interpolate for 20Knots %f, %f\n", angle, lagrange(angle, kn20));

                       System.out.printf("Interpolate for 6Knots %f, %f\n", 135.0, findPoint(135, 43.2, 1048.90, 143.9, 1023.3, kn6));  
                       
					   for(int i = 44; i < 150; i++)
						   System.out.printf("Interpolate for 6Knots %d, %f\n", i, findPoint(i, 43.2, 1048.90, 143.9, 1023.3, kn6));  

//					   SplineInterpolator spline = new SplineInterpolator();
//					   PolynomialSplineFunction function = spline.interpolate(kn6x, kn6y);
//					   for(int i = 44; i < 60; i++)
//						   System.out.printf("Spline Interpolate for 6Knots %d, %f\n", i, function.value(i));   
	}

//	Beat Angle                         43,2					42,2          41,9          40,1        38,9         38               38,4 
//	Beat VMG                           1048,90       871,1         762,3         708,2       682,3        667,5            662,3
//	52                                 685,00        575,8         513,4         491         482,8        478,1            473,7
//	60                                 646,00        546           497,6         477,6       470          465,5            461,4
//	75                                 615,80        525,6         487,4         467,7       453,6        445,6            438,7
//	90                                 623,40        520,4         481           468,3       454,2        439,5            416,9
//	110                                634,40        524,2         480,9         457,1       435,6        420,8            403,3
//	120                                657,70        541,8         489,2         464,1       443,1        421,3            390,1
//	135                                738,90        603,7         523,2         484,8       462,4        441,6            400  
//	150                                886,20        701,4         592,9         522,7       486          463,9            423,5
//	Run VMG                            1023,30       809,9         683,1         595,1       530,8        491,9            448,8
//	Gybe Angle                         143,90        149,5         154,3         161,4       173,6        178,1            179  

}
