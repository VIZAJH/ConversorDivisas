import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame{
	
	JLabel titulo;
	JButton botonTem, botonMon;
	JPanel temperatura, monedas;
	
	
	public MenuPrincipal() {
		
		setTitle("CONVERSOR");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500,260);
		setLocationRelativeTo(null);
		setLayout(null);
		iniciandoComponentes();
		
		
	}

	public void iniciandoComponentes() {
		
		titulo=new JLabel("CONVERSOR DE UNIDADES");
		titulo.setBounds(150,0, 200, 50);
		add(titulo);
		
		
		
		//BOTON TEMPERATURA
		botonTem=new JButton("TEMPERATURA");
		botonTem.setBounds(50,100,150,50);
		add(botonTem);
		
		ActionListener btTem=new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==botonTem) {
					Temperatura tem=new Temperatura();
						tem.setVisible(true);
						setVisible(false);
				}
			}
			
		};
		botonTem.addActionListener(btTem);
		
		//BOTON MONEDAS
		botonMon=new JButton("MONEDAS");
		botonMon.setBounds(280,100,150,50);
		add(botonMon);
		
		ActionListener btMon=new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==botonMon) {
					Monedas divisas=new Monedas();
						divisas.setVisible(true);
						setVisible(false);
				}
			}
			
		};
		botonMon.addActionListener(btMon);
		
	}	

}
