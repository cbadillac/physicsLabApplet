import java.awt.Color;

import java.util.Random;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class EnergyPlot{
	private String titulo;
	private String nombreEjeX;
	private String nombreEjeY;
	
	private XYSeries cinetica, potencial, mecanica;
	private JFreeChart plot;
	
	public EnergyPlot() {
		this.titulo = "Energía Cinética y Energía Potencial en el Sistema";
		this.nombreEjeX = "Tiempo";
		this.nombreEjeY = "Energía";
		this.cinetica = new XYSeries("Energía Cinética");
		this.potencial = new XYSeries("Energía Potencial");
		this.mecanica = new XYSeries("Energía Mecánica");
		this.plot = crearChart();
	}

	public JFreeChart crearChart() {
		XYSeriesCollection collection = new XYSeriesCollection();
		collection.addSeries(cinetica);
		collection.addSeries(potencial);
		collection.addSeries(mecanica);
		
	    JFreeChart jfreechart = ChartFactory.createXYLineChart(
	        titulo, nombreEjeX, nombreEjeY, collection,
	        PlotOrientation.VERTICAL, true, true, false);
	    
	    XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
	    xyPlot.setDomainCrosshairVisible(true);
	    xyPlot.setRangeCrosshairVisible(true);

	    NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
	    domain.setVerticalTickLabels(true);
	    domain.setFixedAutoRange(30.0);
	    
	    return jfreechart;
	}
	public void clear() {
		this.cinetica.clear();
		this.mecanica.clear();
		this.potencial.clear();
	}
	public void add(double cx, double cy, double px, double py) {
		cinetica.add(cx, cy);
		potencial.add(px, py);
		mecanica.add(cx, cy+py);
	}
	public JFreeChart getPlot() {
		return this.plot;
	}
}
