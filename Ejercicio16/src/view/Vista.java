package view;

import model.Vuelo;
import static java.time.temporal.ChronoUnit.DAYS;

import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Vista {
	
	private JFrame frame;
	private JTable tabla;


	public void mostrarInfo(Vuelo vuelo)
	{

		System.out.println("Vuelo '"+vuelo.getNombre()+"' con origen a "+vuelo.getOrigen() + " y destino "+vuelo.getDestino());
		
	}
	
	public void abrirVista(List<Vuelo> vuelos) {
		frame = new JFrame("Vuelos");
		
        String[] columnNames = {"Nombre", "Origen", "Destino","Salida","Llegada","Duracion",};
        Object[][] datos = {};
        
        DefaultTableModel dtm = new DefaultTableModel(datos, columnNames);
        tabla = new JTable(dtm);
        
        for(Vuelo v: vuelos) {
        	Object[] newRow = {v.getNombre(), v.getOrigen(), v.getDestino(), v.getFechaSalida(), v.getFechaLlegada(), v.duracionDias()};
            dtm.addRow(newRow);
        }
        
        tabla.getColumn("Destino").setCellRenderer(new DefaultTableCellRenderer(){
        	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
        		Component comp=super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        		JLabel label=(JLabel)comp;
        		label.setBackground(Color.green);

        		return label;
        		}});
        
        tabla.getColumn("Origen").setCellRenderer(new DefaultTableCellRenderer(){
        	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
        		Component comp=super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        		JLabel label=(JLabel)comp;
        		label.setBackground(Color.green);

        		return label;
        		}});
        
        JScrollPane scrollPane = new JScrollPane(tabla);
        frame.setSize(1200,130);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);	
	}
}
