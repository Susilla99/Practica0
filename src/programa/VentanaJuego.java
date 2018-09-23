package programa;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaJuego extends JFrame {

	private JButton bAcelera;
	private JButton bFrena;
	private JButton bGiraIzq;
	private JButton bGiraDch;
	private JPanel pInferior;
	private JPanel panel;
	private JLabelGrafico lcoche;
	private Boolean seguir;
	private static Thread movimiento;
	
	
	public VentanaJuego() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800,600);
		
		
        
	lcoche= new JLabelGrafico("src/coche.png",90,90);
		
		

		
		
		seguir=true;	
		pInferior= new JPanel();
		panel=new JPanel();
		bAcelera=new JButton("Acelera");
		bFrena=new JButton("Frena");
		bGiraIzq=new JButton("GiraIzquierda");
		bGiraDch=new JButton("GiraDerecha");
		
	
		
		pInferior.add(bAcelera);
		pInferior.add(bFrena);
		pInferior.add(bGiraIzq);
		pInferior.add(bGiraDch);
		panel.add(lcoche);
		
		this.getContentPane().add(pInferior, "South");
		this.getContentPane().add(panel, "Center");
		
		
		Coche coche= new Coche(0,0,200,200,"Aitor");
		lcoche.setLocation(coche.getPosX(),coche.getPosY());
		
		
		
		
		
		bAcelera.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				coche.acelera(-0.00005);				
				System.out.println(coche);
			
			
			}
		
		});
		bFrena.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				coche.acelera(0.00005);				
				System.out.println(coche);
			
			
			}
		
		});
		
		bGiraDch.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				coche.gira(0.1);				
				lcoche.setRotacion(coche.miDireccionActual);
				panel.repaint();
				System.out.println(coche);
			
			
			}
			
		
		});
		bGiraIzq.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {			
				coche.gira(-0.1);				
				lcoche.setRotacion(coche.miDireccionActual);
				panel.repaint();
				System.out.println(coche);
			
			
			}
			
		
		});
		
		
		movimiento=new Thread() {
			
			public void run() {
			
				try {
					while(seguir) {
						
						coche.mueve();
						lcoche.setLocation(coche.getPosX(),coche.getPosY());
						panel.repaint();
					}
				}catch (Exception e) {
					// TODO: handle exception
					
				}
			}
		
		
		
		};
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaJuego vJ= new VentanaJuego();
		
		vJ.setVisible(true);
		movimiento.start();
	}

}