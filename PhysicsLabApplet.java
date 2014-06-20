import java.awt.*;

import javax.swing.*;
import org.jfree.chart.ChartPanel;

public class PhysicsLabApplet extends JApplet {
	public void init() {
		this.setSize(940,500);
		EnergyPlot energyChart = new EnergyPlot();
		MyWorld world = new MyWorld(true);
		world.associate(energyChart);
		MyWorldView  worldView = new MyWorldView(world);
		world.setView(worldView);
		
		LabMenuListener menuListener = new LabMenuListener(world, this);
		setJMenuBar(createLabMenuBar(menuListener));
		
		setLayout(new GridLayout(2,1,0,50));

	    ChartPanel chartPanel = new ChartPanel(energyChart.getPlot());
	    chartPanel.setPreferredSize(new Dimension(300,200));
		
		Container contentPane = getContentPane();
		contentPane.add(chartPanel);
		contentPane.add(worldView);
		
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
		
		return mb;
	}
}
