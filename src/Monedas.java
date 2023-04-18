import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.text.DecimalFormat;
public class Monedas extends JFrame{
	
	JLabel tituloMon,signo;
	JTextField a1,a2;
	JComboBox espacio1, espacio2;
	JButton btnAtras,btnConvertir;
	double valor;
	
	public Monedas() {
		
		setTitle("MONEDAS");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,260);
		setLayout(null);
		setLocationRelativeTo(null);
		inicioComp();
	}


	public void inicioComp() {
		
		tituloMon=new JLabel("CONVERSOR DE DIVISAS");
		tituloMon.setBounds(180,0,200,70);
		add(tituloMon);
		
		
		a1=new JTextField();
		a1.setBounds(40, 80, 150, 30);
		add(a1);
		
		a2=new JTextField();
		a2.setBounds(290, 80, 150, 30);
		add(a2);
		
		String[]mon= {"Soles","Dolares","Euros","Lb-Ester","Yen-Jap","Won-SulCor"};
		
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
		
		//boton convertir
		btnConvertir = new JButton("Convertir"); // Agregar botón "Convertir"
		btnConvertir.setBounds(195, 100,90, 30);
		btnConvertir.setBackground(Color.orange);// Posiciónar el botón
		add(btnConvertir); 
		
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
		
		valor = Double.parseDouble(a1.getText());
		String unidadOrigen = (String) espacio1.getSelectedItem();
		String unidadDestino = (String) espacio2.getSelectedItem();

		double resultado = 0.0;
		
		switch (unidadOrigen) {
		
	     case "Soles":
	        switch (unidadDestino) {
	            case "Dolares":
	                resultado = valor* 0.26;
	                break;
	            case "Euros":
	                resultado = valor *0.21;
	                break;
	            case "Lb-Ester":
	                resultado = valor *0.19;
	                break;
	            case "Yen-Jap":
	                resultado = valor *24.69 ;
	                break;
	            case "Won-SulCor":
	                resultado = valor * 274.98;
	                break;
	        }
	        break;
	        
	    case "Dolares":
	        switch (unidadDestino) {
	            case "Soles":
	                resultado = valor/3.78;
	                break;
	            case "Euros":
	                resultado = valor *0.91;
	                break;
	            case "Lb-Ester":
	                resultado = valor *0.80;
	                break;
	            case "Yen-Jap":
	                resultado = valor *133.99 ;
	                break;
	            case "Won-SulCor":
	                resultado = valor * 1319.75;
	                break;
	        }
	        break;
	        
	    case "Euros":
	        switch (unidadDestino) {
	            case "Soles":
	                resultado = valor*4.15;
	                break;
	            case "dolares":
	                resultado = valor *1.10;
	                break;
	            case "Lb-Ester":
	                resultado = valor *0.88;
	                break;
	            case "Yen-Jap":
	                resultado = valor *146.95;
	                break;
	            case "Won-SulCor":
	                resultado = valor *1445.83;
	                break;
	        }
	        break;
	        
	    case "Lb-Ester":
	        switch (unidadDestino) {
	            case "Soles":
	                resultado = valor*4.69;
	                break;
	            case "dolares":
	                resultado = valor *1.24;
	                break;
	            case "Euros":
	                resultado = valor *1.13;
	                break;
	            case "Yen-Jap":
	                resultado = valor *166.56;
	                break;
	            case "Won-SulCor":
	                resultado = valor *1638.26;
	                break;
	        }
	        break;
	        
	    case "Yen-Jap":
	        switch (unidadDestino) {
	            case "Soles":
	                resultado = valor*0.028;
	                break;
	            case "dolares":
	                resultado = valor *0.0075;
	                break;
	            case "Euros":
	                resultado = valor *0.0068;
	                break;
	            case "Lb-Esterlinas":
	                resultado = valor *0.0060;
	                break;
	            case "Won-SulCor":
	                resultado = valor *9.83;
	                break;
	        }
	        break;
	        
	    case "Won-SulCor":
	        switch (unidadDestino) {
	            case "Soles":
	                resultado = valor*0.0029;
	                break;
	            case "dolares":
	                resultado = valor *0.00076;
	                break;
	            case "Euros":
	                resultado = valor *0.00069;
	                break;
	            case "Lb-Esterlinas":
	                resultado = valor *0.0000061;
	                break;
	            case "Yen-Jap":
	                resultado = valor *0.10;
	                break;
	        }
	        break;
  
		}

		// Mostrar el resultado en el segundo campo de texto
		
		a2.setText(String.valueOf(resultado));
		
	}

}
