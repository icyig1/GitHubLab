import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               for(int i=0;i<10;i++)
	               {
	            	   direction = carQueue.deleteQueue();
	            	   int degree = 20;
	            	   
	            	   /*
	            	    * 0 = up
	            	    * 1 = down
	            	    * 2 = right
	            	    * 3 = left
	            	    */ 
	            	   switch(direction) {
	            	   case 0:
	            		   y = y - degree;
	            		   System.out.println("direction: up");
	            		   break;
	            	   case 1:
	            		   y = y + degree;
	            		   System.out.println("direction: down");
	            		   break;
	            	   case 2:
	            		   x = x + degree;
	            		   System.out.println("direction: right");
	            		   break;
	            	   case 3:
	            		   x = x - degree;
	            		   System.out.println("direction: left");
	            		   break;
	            	   }
	            	   
	            	   /*
	            	    * Frame
	            	    * y: 0-400
	            	    * x: 0-300
	            	    * Car
	            	    * height: 70
	            	    * width: 80
	            	    */
	            	   if(y <= 0) {
	            		   y = 0;
	            		   System.out.println("hit top boundry");
	            		   repaint();
		            	   Thread.sleep(delay*1000);
	            		   y = y + degree;
	            	   }
	            	   if(y >= 330) {
	            		   y = 330; // 400-70
	            		   System.out.println("hit bottom boundry");
	            		   repaint();
		            	   Thread.sleep(delay*1000);
	            		   y = y - degree;
	            	   }
	            	   if(x <= 0) {
	            		   x = 0;
	            		   System.out.println("hit left boundry");
	            		   repaint();
		            	   Thread.sleep(delay*1000);
	            		   x = x + degree;
	            	   }
	            	   if(x >= 220) {
	            		   x = 220; // 300-80
	            		   System.out.println("hit right boundry");
	            		   repaint();
		            	   Thread.sleep(delay*1000);
	            		   x = x - degree;
	            	   }
	            	   
	            	   carQueue.addToQueue();
	            	   repaint();
	            	   Thread.sleep(delay*1000);
	            	   
	               }
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}
