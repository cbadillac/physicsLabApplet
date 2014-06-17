import java.awt.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

public class PhysicsLabApplet extends JApplet {
	public void init() {
		this.setSize(940,300);
		MyWorld world = new MyWorld();
		MyWorldView  worldView = new MyWorldView(world);
		world.setView(worldView);
		
		LabMenuListener menuListener = new LabMenuListener(world, this);
		setJMenuBar(createLabMenuBar(menuListener));
		
		setLayout(new GridLayout(2,1,10,0)); 
		
		Container contentPane = getContentPane();
		contentPane.add(new ChartPanel(crearChart(crearDataSet())));
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
	private static PieDataset crearDataSet()
	{
	    DefaultPieDataset data=new DefaultPieDataset();
	    data.setValue("Uno",new Double(43.2));
	    data.setValue("Dos",new Double(10.0));
	    data.setValue("Tres",new Double(27.5));
	    data.setValue("Cuatro",new Double(17.5));
	    data.setValue("Cinco",new Double(11.0));
	    data.setValue("Seis",new Double(19.4));
	    return data;
	}
	private static JFreeChart crearChart(PieDataset data)
	{
	    JFreeChart chart = ChartFactory.createPieChart(
	            "Demo de PieChart",     //Nombre del gráfico
	            data,                   //data
	            true,                  //Leyenda
	            true,
	            false);       
	    //Color de la ventana
	    chart.setBackgroundPaint(Color.ORANGE);
	    PiePlot plot = (PiePlot)chart.getPlot();
	    //Color de las etiquetas
	    plot.setLabelBackgroundPaint(Color.ORANGE);
	    //Color de el fondo del gráfico
	    plot.setBackgroundPaint(Color.WHITE);
	    plot.setNoDataMessage("No hay data");
	 
	    return chart;
	}
}
