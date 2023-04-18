import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;

public class Temperatura extends JFrame {
	
	JLabel tituloTem,signo;
	JTextField area1,area2;
	JComboBox espacio1, espacio2;
	JButton btnAtras ,btnConvertir;
	String datos;
	double cantidad;
	
	public Temperatura() {
		
		setTitle("CONVERSOR");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,260);
		setLayout(null);
		setLocationRelativeTo(null);
		inicioComp();
		
	}

	
	public void inicioComp() {
		
		tituloTem=new JLabel("CONVERSOR DE TEMPERATURA");
		tituloTem.setBounds(150,0,200,70);
		add(tituloTem);
		
		
		area1=new JTextField();
		area1.setBounds(40, 80, 150, 30);
		add(area1);
		
		area2=new JTextField();
		area2.setBounds(290, 80, 150, 30);
		add(area2);
		
		String[]mon= {"°C","°F","°K","°R","°Re"};
		
		espacio1=new JComboBox(mon);
		espacio1.setBounds(40, 120,150,30);
		add(espacio1);
		
		espacio2=new JComboBox(mon);
		espacio2.setBounds(290, 120,150,30);
		add(espacio2);
		
		
		btnAtras=new JButton("volver");
		btnAtras.setBounds(170, 170, 150, 30);
		btnAtras.setBackground(Color.CYAN);
		add(btnAtras);
		
		btnConvertir = new JButton("Convertir"); // Agregar botón "Convertir"
		btnConvertir.setBounds(195, 100,90, 30);
		btnConvertir.setBackground(Color.orange);// Posiciónar el botón
		add(btnConvertir); // Agregar el botón al JFrame
		
		ActionListener btAt=new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAtras) {
					MenuPrincipal mp=new MenuPrincipal();
						mp.setVisible(true);
						setVisible(false);
				}else if(e.getSource()==btnConvertir) {
					
					conversiones();
				}
			}
			
		};
		btnAtras.addActionListener(btAt);
		btnConvertir.addActionListener(btAt);
	}
	
	public void conversiones() {
		
		// Obtener los valores ingresados por el usuario
		
		double valor = Double.parseDouble(area1.getText());
		String unidadOrigen = (String) espacio1.getSelectedItem();
		String unidadDestino = (String) espacio2.getSelectedItem();

		double resultado = 0.0;
		
		switch (unidadOrigen) {
		
	     case "°C":
	        switch (unidadDestino) {
	            case "°F":
	                resultado = (valor * 1.8) + 32;
	                break;
	            case "°K":
	                resultado = valor + 273.15;
	                break;
	            case "°R":
	                resultado = (valor + 273.15) * 1.8;
	                break;
	            case "°Re":
	                resultado = valor * 0.8;
	                break;
	        }
	        break;
	        
	    case "°F":
	        switch (unidadDestino) {
	            case "°C":
	                resultado = (valor - 32) / 1.8;
	                break;
	            case "°K":
	                resultado = (valor + 459.67) / 1.8;
	                break;
	            case "°R":
	                resultado = valor + 459.67;
	                break;
	            case "Re":
	                resultado = (valor - 32) / 2.25;
	                break;
	        }
	        break;
	        
	    case "°K":
	        switch (unidadDestino) {
	            case "°C":
	                resultado = valor - 273.15;
	                break;
	            case "°F":
	                resultado = (valor * 1.8) - 459.67;
	                break;
	            case "°R":
	                resultado = valor * 1.8;
	                break;
	            case "°Re":
	                resultado = (valor - 273.15) * 0.8;
	                break;
	        }
	        break;
	    case "°R":
	        switch (unidadDestino) {
	            case "°C":
	                resultado = (valor / 1.8) - 273.15;
	                break;
	            case "°F":
	                resultado = valor - 459.67;
	                break;
	            case "°K":
	                resultado = valor / 1.8;
	                break;
	            case "°Re":
	                resultado = ((valor / 1.8) - 273.15) * 0.8;
	                break;
	        }
	        break;
	    case "°Re":
	        switch (unidadDestino) {
	            case "°C":
	                resultado = valor / 0.8;
	                break;
	            case "°F":
	                resultado = (valor * 2.25) + 32;
	                break;
	            case "°K":
	                resultado = (valor / 0.8) + 273.15;
	                break;
	            case "°R":
	                resultado = ((valor / 0.8) + 273.15) * 1.8;
	                break;
	        }
	        break;
		}

		// Mostrar el resultado en el segundo campo de texto
		
	
		
		area2.setText(String.valueOf(Math.round((resultado)*100)));

	}

}
