import javax.swing.*;

import org.jfree.chart.ChartPanel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

public class PhysicsLab {
   public static void main(String[] args) {
      PhysicsLab_GUI lab_gui = new PhysicsLab_GUI();
      lab_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      lab_gui.setVisible(true);
   }
}

class PhysicsLab_GUI extends JFrame {
	
   public PhysicsLab_GUI() {
      setTitle("My Small and Nice Physics Laboratory");
      setSize(MyWorldView.WIDTH, MyWorldView.HEIGHT+50+300);  // height+50 to account for menu height +30 for
      
      EnergyPlot energyChart = new EnergyPlot();
      MyWorld world = new MyWorld();
      MyWorldView  worldView = new MyWorldView(world);
      world.associate(energyChart);
      world.setView(worldView);
      
      LabMenuListener menuListener = new LabMenuListener(world);
      setJMenuBar(createLabMenuBar(menuListener));
      
      setLayout(new GridLayout(1,2,0,50));

	    ChartPanel chartPanel = new ChartPanel(energyChart.getPlot());
	    chartPanel.setPreferredSize(new Dimension(300,200));
	    menuListener.associate(energyChart);
	    
	  Container contentPane = getContentPane();
		contentPane.add(worldView);
		contentPane.add(chartPanel);
   }

   public JMenuBar createLabMenuBar(LabMenuListener menu_l) {
      JMenuBar mb = new JMenuBar();
      
      JMenu menu = new JMenu ("Configuration");
      mb.add(menu);
      JMenu subMenu = new JMenu("Insert");  
      menu.add(subMenu);
      
      JMenuItem menuItem = new JMenuItem("Ball");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menuItem = new JMenuItem("Fixed Hook");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menuItem = new JMenuItem("Spring");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menuItem = new JMenuItem("Oscillator");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menuItem = new JMenuItem("My scenario");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
  
      menu = new JMenu("MyWorld");
      mb.add(menu);
      menuItem = new JMenuItem("Start");
      menuItem.addActionListener(menu_l);
      menu.add(menuItem);
      menuItem = new JMenuItem("Stop");
      menuItem.addActionListener(menu_l);
      menu.add(menuItem);
      subMenu = new JMenu("Simulator");
      menuItem = new JMenuItem("Delta time");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menuItem = new JMenuItem("View Refresh time");
      menuItem.addActionListener(menu_l);
      subMenu.add(menuItem);
      menu.add(subMenu);
      
      menu = new JMenu("Plot");
		mb.add(menu);
		menuItem = new JMenuItem("Clear Plot");
		menuItem.addActionListener(menu_l);
		menu.add(menuItem);
      
      return mb;          
   }   
}