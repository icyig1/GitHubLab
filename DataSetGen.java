/*
 * 		Ian Green
 * 		Professor Kuijt
 * 		CMSC 204 CRNN 31209
 * 		Generics Lab
 */
public class DataSetGen<T extends Measurable> // 'T' represents the type parameter; where T must be a class that extends Measurable
//
{
	   private double sum;
	   private T maximum; //Change 'Measurable maximum to 'T maximum' to hold the type passed in from any of the clases implementing Measurable
	   private int count;

	   /**
	      Constructs an empty data set.
	   */
	   public DataSetGen()
	   {
	      sum = 0;
	      count = 0;
	      maximum = null;
	   }

	   /**
	      Adds a data value to the data set.
	      @param x a data value
	   */
	   public void add(T x) // Change 'Measurable x' to 'T x' so that the objects 'x' will be able to be used instead of just Measurable
	   {
	      sum = sum + x.getMeasure();
	      if (count == 0 || maximum.getMeasure() < x.getMeasure())
	         maximum = x;
	      count++;
	   }

	   /**
	      Gets the average of the added data.
	      @return the average or 0 if no data has been added
	   */
	   public double getAverage()
	   {
	      if (count == 0) return 0;
	      else return sum / count;
	   }

	   /**
	      Gets the largest of the added data.
	      @return the maximum or 0 if no data has been added
	   */
	   public T getMaximum() // Replace 'Measurable getMaximum' to 'T getMaximum' to allow the method to work with any class that implements Measurable
	   {
	      return maximum; 
	   }
	}
