import java.awt.event.*; 
import java.awt.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;

public class LabMenuListener implements ActionListener {
   private MyWorld  world;
   private EnergyPlot plot;
   private boolean isApplet = false;
   private PhysicsLabApplet phyla;
   
   public LabMenuListener (MyWorld  w){
      world = w;
      
   }
   public LabMenuListener(MyWorld w, PhysicsLabApplet phyla){
	   world = w;
	   this.setPhyla(phyla);
	   this.setIsApplet(true);
   }
   public void actionPerformed(ActionEvent e) {
      JMenuItem menuItem = (JMenuItem)(e.getSource());
      String text = menuItem.getText();
      
      // Actions associated to main manu options
      if ( (text.equals("My scenario")) && !isApplet) {  // here you define Etapa2's configuration
       // to be coded
    	     	 
         double mass = 1.0;      // 1 [kg] 
         double radius = 0.1;    // 10 [cm] 
         double position = 1.0;  // 1 [m] 
         double speed = 0.0;     // 0.5 [m/s]
         Ball b = new Ball(mass, radius, position, speed);
         FixedHook h = new FixedHook(0.2);
         Spring s = new Spring (0.5, 5);
         s.attachAend(h);
         s.attachBend(b);
         world.addElement(b);
         world.addElement(h);
         world.addElement(s);
      }
      if (isApplet && (text.equals("My scenario"))) {
    	  double mass = 1.0;      // 1 [kg] 
    	  double radius = 0.1;    // 10 [cm] 
    	  double position = 1.0;  // 1 [m] 
    	  double speed = 0.0;     // 0.5 [m/s]
    	  double frequency = 0;
    	  double amplitude = 0;
    	  for (int i = 0; i < Integer.parseInt(phyla.getParameter("ballNum")); i++) {
    		  
    		  speed    = Float.parseFloat(phyla.getParameter("ball." + (i+1)).split("[;]")[0]);
    		  mass     = Float.parseFloat(phyla.getParameter("ball." + (i+1)).split("[;]")[1]);
    		  position = Float.parseFloat(phyla.getParameter("ball." + (i+1)).split("[;]")[2]);
    		  radius   = Float.parseFloat(phyla.getParameter("ball." + (i+1)).split("[;]")[3]);
    		  
    		  world.addElement(new Ball(mass, radius, position, speed));
    		  
    	  }
    	  
    	  for (int i = 0; i < Integer.parseInt(phyla.getParameter("fixedHookNum")); i++) {
    		  position = Float.parseFloat(phyla.getParameter("fixedHook." + (i+1)));
    		  
    		  world.addElement(new FixedHook(position));
		}
    	  for (int i = 0; i < Integer.parseInt(phyla.getParameter("oscillatorNum")); i++) {

    		  amplitude= Float.parseFloat(phyla.getParameter("oscillator." + (i+1)).split("[;]")[0]);
    		  frequency= Float.parseFloat(phyla.getParameter("oscillator." + (i+1)).split("[;]")[1]);
    		  position = Float.parseFloat(phyla.getParameter("oscillator." + (i+1)).split("[;]")[2]);
    		  
    		  world.addElement(new Oscillator(position, amplitude, frequency));
    		  
    	  }
    	  
    	  world.setDelta_t(Float.parseFloat(phyla.getParameter("deltaTime")));
    	  world.setRefreshPeriod(Float.parseFloat(phyla.getParameter("refreshTime")));
      }
      if (text.equals("Clear Plot"))
          plot.clear();
      
      if (text.equals("Ball")) 
        world.addElement(new Ball(1.0, 0.1, 1.2, 0));
      if (text.equals("Fixed Hook"))  
        world.addElement(new FixedHook(0.5));
      if (text.equals("Spring")) 
        world.addElement(new Spring(0.5, 5));
      if (text.equals("Oscillator")) 
        world.addElement(new Oscillator(0.5,0.1,0.5));
      

      // Actions associated to MyWorld submenu
      if (text.equals("Start"))   /* to be coded */
        world.start();
      
      if (text.equals("Stop"))    /* to be coded */
        world.stop();
        
      if (text.equals("Delta time")) {
    	  
    	  String data = JOptionPane.showInputDialog("Enter delta t [s]");
         world.setDelta_t(Double.parseDouble(data));
      }
      if (text.equals("View Refresh time")) {
         // to be coded
         String data = JOptionPane.showInputDialog("Enter view refresh time [s]");
         world.setRefreshPeriod(Double.parseDouble(data));
      }
   }
   public void associate(EnergyPlot p) {
	   this.plot = p;
   }
   public boolean isApplet() {
	   return isApplet;
   }
   public void setIsApplet(boolean isApplet) {
	   this.isApplet = isApplet;
   }
   public PhysicsLabApplet getPhyla() {
	   return phyla;
   }
   public void setPhyla(PhysicsLabApplet phyla) {
	   this.phyla = phyla;
   }
    
   
}