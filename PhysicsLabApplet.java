import java.util.Random;
import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PhysicsLabApplet extends JApplet {
	public void init() {
		this.setSize(940,500);
		MyWorld world = new MyWorld();
		MyWorldView  worldView = new MyWorldView(world);
		world.setView(worldView);
		
		LabMenuListener menuListener = new LabMenuListener(world, this);
		setJMenuBar(createLabMenuBar(menuListener));
		
		setLayout(new GridLayout(2,1,10,0)); 
		
		Container contentPane = getContentPane();
		contentPane.add(new ChartPanel(crearChart()));
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
	private static XYDataset crearDataSet()
	{
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        XYSeries series = new XYSeries("Random");
        
        for (int i = 0; i < 8 * 8; i++) {
            double x = (new Random()).nextGaussian();
            double y = (new Random()).nextGaussian();
            series.add(x, y);
        }
        
        xySeriesCollection.addSeries(series);
        
        return xySeriesCollection;
	}
	private static JFreeChart crearChart()
	{
	    JFreeChart jfreechart = ChartFactory.createScatterPlot(
	        "Energy Plot", "X", "Y", crearDataSet(),
	        PlotOrientation.VERTICAL, true, true, false);
	    XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
	    xyPlot.setDomainCrosshairVisible(true);
	    xyPlot.setRangeCrosshairVisible(true);
	    
	    XYItemRenderer renderer = xyPlot.getRenderer();
	    renderer.setSeriesPaint(0, Color.blue);
	    
	    NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
	    domain.setVerticalTickLabels(true);
	    
	    return jfreechart;
	}
}
