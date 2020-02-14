import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
class Proyect1 {

	public static void main(String[] args) throws Exception {
		PILACOL p =new PILACOL();
		p.setVisible(true);

	}

}

class PILACOL extends JFrame implements ActionListener{
	JButton Press,Press2,Press3,Press4;
	PILACOL() throws Exception {
		this.setBounds(100, 200, 500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pilas y Cola");
		IniciarComponentes();
	}
	private void IniciarComponentes() throws Exception {
		JPanel panel = new JPanel();
		panel.setBackground(Color.orange);
		panel.setLayout(null);
		getContentPane().add(panel);
		ColocarTexto(panel);
	}
	private void ColocarTexto(JPanel panel) throws Exception{
		Font funete = new Font("TOhoma",Font.BOLD,25);
		
		JLabel titulo = new JLabel("Menu Principal");
		titulo.setBounds(150, 20, 200, 100);
		titulo.setForeground(Color.BLUE);
		titulo.setFont(funete);
		panel.add(titulo);
		
		 Press = new JButton("Presentacion");
		Press.setBounds(140, 100, 200, 25);
		panel.add(Press);
		Press.addActionListener((ActionListener) this);
		
		 Press2 = new JButton("Operacion con Pila");
		Press2.setBounds(140, 140, 200, 25);
		panel.add(Press2);
		Press2.addActionListener((ActionListener) this);
		
		 Press3 = new JButton("Operacion con Cola");
		Press3.setBounds(140, 180, 200, 25);
		panel.add(Press3);
		Press3.addActionListener((ActionListener) this);
		
		 Press4 = new JButton("Salir");
		Press4.setBounds(140, 220, 200, 25);
		panel.add(Press4);
		Press4.addActionListener((ActionListener) this);
	
	}
	public void actionPerformed(ActionEvent evento){
		 if(evento.getSource() == Press) {
			 try {
				Presentacion();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 }else if(evento.getSource()==Press2) {
			 try {
				 PilaMenu pila = new PilaMenu();
				pila.setVisible(true);
				this.setVisible(false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else if(evento.getSource()==Press3) {
			 int op;
			 try {
				 
				 String obj[] = {"Cola simple","Cola circular","Retornar"};
				 op = JOptionPane.showOptionDialog(null, "Escoja una Opcion", "Colas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, null, obj, obj[2]);
				 
				 if(op==2) {
					 JOptionPane.showMessageDialog(null, "Vuelva Pronto");
				 }else {
					 ColaMenu cola = new ColaMenu(op);
					 cola.setVisible(true);
					 this.setVisible(false);
				 }
				 
				 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else {
			 JOptionPane.showMessageDialog(null, "Muchas gracias por su visita vuelva pronto");
			 this.setVisible(false);
		 }
		
	}
	private void Presentacion() {
		JOptionPane.showMessageDialog(null, "Proyecto #1\n\n"
										+"Tema:APLICACIONES DE LAS ESTRUCTURAS LINEALES (PILAS/COLAS)\n\n"
										+"Nombre: Kevin Santamaria\n\n"
										+"Grupo: 1ls111\n\n"
										+"Profesora: Yolanda de Miguelena\n\n"
										+"Año: 2019");
	}
	

}

//CLASE MENU PILA
class PilaMenu extends JFrame implements ActionListener{
	
	boolean confirmare;
	JButton Press,Press2,Press3,Press4,Press5;
	Pila pila;
 	PilaMenu() throws Exception {
		
		this.setBounds(100, 200, 500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pilas y Cola");
		IniciarComponentes();
	}
	
	//FUNCION QUE INICIA LOS COMPONENTES EN EL PANEL
	private void IniciarComponentes() throws Exception {
		confirmare = false;
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setLayout(null);
		getContentPane().add(panel);
		ColocarTexto(panel);
		Habilitar(confirmare);
	}
	
	//FUNCION QUE REALIZA LA FUNCION DE PILA
	private void ColocarTexto(JPanel panel) throws Exception{
		
		Font funete = new Font("TOhoma",Font.BOLD,25);
		
		JLabel titulo = new JLabel("Menu Opcion 1");
		titulo.setBounds(150, 20, 200, 100);
		titulo.setForeground(Color.BLUE);
		titulo.setFont(funete);
		panel.add(titulo);
		
		 Press = new JButton("Crear Pila");
		Press.setBounds(140, 100, 200, 25);
		panel.add(Press);
		Press.addActionListener((ActionListener) this);
		
		 Press2 = new JButton("Insertar Dato");
		Press2.setBounds(140, 140, 200, 25);
		panel.add(Press2);
		Press2.addActionListener((ActionListener) this);
		
		 Press3 = new JButton("Eliminar Dato");
		Press3.setBounds(140, 180, 200, 25);
		panel.add(Press3);
		Press3.addActionListener((ActionListener) this);
		
		 Press4 = new JButton("Retornar");
		Press4.setBounds(140, 220, 200, 25);
		panel.add(Press4);
		Press4.addActionListener((ActionListener) this);
		
		 Press5 = new JButton("Regresar");
		Press5.setBounds(140, 260, 200, 25);
		panel.add(Press5);
		Press5.addActionListener((ActionListener) this);
		
	
	}
	//FUNCION PARA HABILITAR Y DESABILITAR LOS BOTONES
	public void Habilitar(boolean confirmar) {
		if(confirmar == false) {
			Press2.setEnabled(false);
			Press3.setEnabled(false);
			Press4.setEnabled(false);
		}else {
			Press2.setEnabled(true);
			Press3.setEnabled(true);
			Press4.setEnabled(true);
		}
	}
	
	//Funcion de ACTION BUTTON
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == Press5) {
			 try {
				 PILACOL pc = new PILACOL();
				 pc.setVisible(true);
				 this.setVisible(false);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		 }else if(evento.getSource() == Press) {
			int tam = 0,i=0;
			while(i==0) {
				try {
					tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Inserte el tamano de la PILA"));
					i+=1;
					pila = new Pila(tam);
					JOptionPane.showMessageDialog(null, "El tamano de la pila es:"+pila.MAX);
					if(tam > 0) {
						Habilitar(true);
					}else {
						JOptionPane.showMessageDialog(null, "La pila no fue creada"+pila.MAX);
					}
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"error en:"+e);
					i=0;
				}
				
			}
			
			
		}else if(evento.getSource() == Press2) {
			String dato = JOptionPane.showInputDialog(null,"Inserte un dato a la Pila");
			pila.PUSH(dato);
		}else if(evento.getSource() == Press4) {
			JOptionPane.showMessageDialog(null, "La PILA es la siguiente\n"+pila.RETORNAR());
		}else if(evento.getSource() == Press3) {
			String temp = pila.POP();
			if(temp != null) {
				JOptionPane.showMessageDialog(null, "El elemento ["+temp+"] Fue eliminado con Exito");
			}	
			
		}
		
	}
	
	
	
}

//CLASE IMPLEMENTACION DE LA PILA
class Pila {
	
	int TOPE,MAX;
	String PILA[];
	public Pila(int n) {
		TOPE=0;
		MAX=n;
		PILA = new String[MAX];
	}
	//FUNCION PARA INSERTAR 
		public void PUSH(String dato) {
			if(FULL()==true) {
				JOptionPane.showMessageDialog(null, "Desbordamiento de PILA");
			}else {
				JOptionPane.showMessageDialog(null,"Elemento insertado");
				TOPE = TOPE + 1;
				PILA[TOPE-1] = dato;
			}
		}
		
		//FUNCION PARA ELIMINAR 
		public String POP() {
			String temp=null;
				if(EMPTY() == true) {
					JOptionPane.showMessageDialog(null, "La pila esta vacia");
					return null;
				}else {
					temp = PILA[TOPE-1];
					PILA[TOPE-1] = null;
					TOPE -= 1;
					return temp;
				}
				
		}
		
		//FUNCION PARA MOSTRAR EL ULTIMO ELEMENTO DE LA PILA 
		public String PEEK() {
				if(EMPTY()!=true) {
					JOptionPane.showMessageDialog(null, "La pila esta vacia");
					return null;
				}else {
					return PILA[TOPE];
				}
				
		}
		
		//FUNCION PARA SABER SI LA PILA ESTA VACIA 
			public boolean EMPTY() {
				if(TOPE == 0) {
					return true;
				}else {
					return false;
				}
				
		}
		
		//FUNCION PARA SABER SI LA PILA ESTA LLENA 
		public boolean FULL() {
				if(TOPE == MAX) {
					return true;
				}
				else {
					return false;
				}
		}
		
		//FUNCION PARA RETORNAR LOS DATOS
		public String RETORNAR() {
			String concat = " ";
			for(int i = 0; i<MAX;i++) {
				concat = concat + PILA[i];
				concat = concat + "\n";
			}
			return concat;
		}
}


//CLASE PARA MOSTRAR EL MENU DE COLA
class ColaMenu extends JFrame implements ActionListener{
	
	boolean confirmare;
	int op;
	Cola cola;
	ColaCircular colacircular;
	JButton Press,Press2,Press3,Press4,Press5;
	ColaMenu(int op) throws Exception {
		this.op = op;
		this.setBounds(100, 200, 500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pilas y Cola");
		IniciarComponentes();
	}
	private void IniciarComponentes() throws Exception {
		confirmare = false;
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setLayout(null);
		getContentPane().add(panel);
		ColocarTexto(panel);
		Habilitar(confirmare);
	}
	private void ColocarTexto(JPanel panel) throws Exception{
		String tituloVentana;
		Font funete = new Font("TOhoma",Font.BOLD,25);
		
		if(op == 0) {
			tituloVentana = "Menu Opcion 2 Colas Simples";
		}else {
			tituloVentana = "Menu Opcion 2 Colas Circular";
		}
		JLabel titulo = new JLabel(tituloVentana);
		titulo.setBounds(80, 20, 400, 100);
		titulo.setForeground(Color.BLUE);
		titulo.setFont(funete);
		panel.add(titulo);
		
		 Press = new JButton("Crear Cola");
		Press.setBounds(140, 100, 200, 25);
		panel.add(Press);
		Press.addActionListener((ActionListener) this);
		
		 Press2 = new JButton("Insertar Dato");
		Press2.setBounds(140, 140, 200, 25);
		panel.add(Press2);
		Press2.addActionListener((ActionListener) this);
		
		 Press3 = new JButton("Eliminar Dato");
		Press3.setBounds(140, 180, 200, 25);
		panel.add(Press3);
		Press3.addActionListener((ActionListener) this);
		
		 Press4 = new JButton("Retornar");
		Press4.setBounds(140, 220, 200, 25);
		panel.add(Press4);
		Press4.addActionListener((ActionListener) this);
		
		Press5 = new JButton("Regresar");
		Press5.setBounds(140, 260, 200, 25);
		panel.add(Press5);
		Press5.addActionListener((ActionListener) this);
	
	}
	//FUNCION PARA HABILITAR Y DESABILITAR LOS BOTONES
		public void Habilitar(boolean confirmar) {
			if(confirmar == false) {
				Press2.setEnabled(false);
				Press3.setEnabled(false);
				Press4.setEnabled(false);
			}else {
				Press2.setEnabled(true);
				Press3.setEnabled(true);
				Press4.setEnabled(true);
			}
		}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(op == 0) {
			if(evento.getSource() == Press5) {
				 try {
					 PILACOL pc = new PILACOL();
					 pc.setVisible(true);
					 this.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			 }else if(evento.getSource() == Press) {
				 int tam = 0, i = 0;
				 while(i==0) {
					 try {
						 tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Inserte el tamano de la COLA"));
						 cola = new Cola(tam);
						 i += 1;
						 JOptionPane.showMessageDialog(null, "El tamano de la pila es:"+cola.Max);
							if(tam > 0) {
								Habilitar(true);
							}else {
								JOptionPane.showMessageDialog(null, "La pila no fue creada"+cola.Max);
							}
					 }catch(Exception e) {
						 JOptionPane.showMessageDialog(null, "Error"+e+" SOLO SE PERMITE VALORES NUMERICOS");
						 i=0;
					 }
				 }
			 }else if(evento.getSource() == Press2) {
				 String dato = JOptionPane.showInputDialog(null,"Inserte un dato a la cola");
				 cola.PUSH(dato);
			 }else if(evento.getSource() == Press3) {
				 String tem = cola.POP();
				 if(tem != null) {
					 JOptionPane.showMessageDialog(null,"El elemento ["+tem+"] fue eliminado correctamente");
				 }
			 }else if(evento.getSource() == Press4) {
				 JOptionPane.showMessageDialog(null,"La COLA es la siguiente:\n"+cola.RETORNAR());
			 }
		}else {
			if(evento.getSource() == Press5) {
				 try {
					 PILACOL pc = new PILACOL();
					 pc.setVisible(true);
					 this.setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			 }else if(evento.getSource() == Press) {
				 int tam = 0, i = 0;
				 while(i==0) {
					 try {
						 tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Inserte el tamano de la COLA"));
						 colacircular = new ColaCircular(tam);
						 i += 1;
						 JOptionPane.showMessageDialog(null, "El tamano de la pila es:"+colacircular.Max);
							if(tam > 0) {
								Habilitar(true);
							}else {
								JOptionPane.showMessageDialog(null, "La pila no fue creada"+colacircular.Max);
							}
					 }catch(Exception e) {
						 JOptionPane.showMessageDialog(null, "Error"+e+" SOLO SE PERMITE VALORES NUMERICOS");
						 i=0;
					 }
				 }
			 }else if(evento.getSource() == Press2) {
				 String dato = JOptionPane.showInputDialog(null,"Inserte un dato a la cola");
				 colacircular.PUSH(dato);
			 }else if(evento.getSource() == Press3) {
				 String tem = colacircular.POP();
				 if(tem != null) {
					 JOptionPane.showMessageDialog(null,"El elemento ["+tem+"] fue eliminado correctamente");
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"El elemento No se elimino");
				 }
			 }else if(evento.getSource() == Press4) {
				 JOptionPane.showMessageDialog(null,"La COLA es la siguiente:\n"+colacircular.RETORNAR());
			 }
		}
		
		
		
	}
	
}

//CLASE PARA IMEPLENTAR LA COLA

class Cola{
	String cola[];
	int Max,frente,fin;
	
	Cola(int dato){
		Max = dato;
		frente = 0;
		fin = 0;
		cola = new String[Max];
	}
	
	//FUNCION PARA INSERTAR ELEMENTOS A LA COLA
	
	//FUNCION PARA ELIMINAR ELEMENTOS DE LA PILA
	public void PUSH(String dato) {
		if(FULL() != true) {
			fin += 1;
			cola[fin-1] = dato;
			if(fin == 1) {
				frente = 1;
			}
			JOptionPane.showMessageDialog(null,"Elemento insertado correctamente");
		}else {
			JOptionPane.showMessageDialog(null,"Desbordamiento la cola esta llena");
		}
	}
	
	//FUNCION PARA ELIMINAR ELEMENTOS DE LA COLA
	public String POP() {
		int i=0,desde=0;
		String dato = null, concat=" ";
			if(EMPTY() != true) {
				dato = cola[frente-1];
				desde = frente +1;
				for(i = 0; i<Max; i++) {
					concat = concat + cola[i];
				}
					JOptionPane.showMessageDialog(null, "Los elementos son\n"+concat);
					concat = concat.substring((desde), (fin+1));
					JOptionPane.showMessageDialog(null, "Los elementos son"+concat);
					cola[fin-1] = null;
				for(i=0;i<Max;i++) {
					if(i<concat.length()) {
						cola[i] = Character.toString(concat.charAt(i));
					}
					
				}
					fin -= 1;
				if(fin == 0) {
					frente = 0;
				}
				return dato;
			}else {
				JOptionPane.showMessageDialog(null, "La cola esta vacia");
				return null;
			}
	}
	//FUNCION PARA MOSTRAR LA PILA
	
	//FUNCION PARA MOSTRAR ELEMENTOS DE LA COLA
	public String RETORNAR() {
			String concat = "";
			for(int i = 0; i<Max; i++) {
				concat = concat + cola[i];
				concat += "\n";
			}
			return concat;
	}
	//FUNCION PARA VERIFICAR SI LA COLA ESTA VACIA
	
	//FUNCION PARA VERIFICAR SI LA COLA ESTA VACIA
	public boolean EMPTY() {
		if(frente == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//FUNCION PARA VERIFICAR SI LA COLA ESTA LLENA
	public boolean FULL() {
		if(fin == Max) {
			return true;
		}else {
			return false;
		}
	}
	
}

//CLASE PARA IMPLEMENTAR COLACIRCULAR
class ColaCircular{
	String cola[];
	int Max,frente,fin,n;
	ColaCircular(int dato){
		Max = dato;
		frente = 0;
		fin = 0;
		n = 0;
		cola = new String[Max];
	}
	
	//FUNCION PARA INSERTAR ELEMENTOS A LA COLA
	public void PUSH(String dato) {
		if(FULL() != true) {
			fin = (frente+n)%Max;
			cola[fin] = dato;
			n++;
			JOptionPane.showMessageDialog(null,"Elemento insertado correctamente");
		}else {
			JOptionPane.showMessageDialog(null,"Desbordamiento la cola esta llena");
		}
	}
	
	//FUNCION PARA ELIMINAR UN ELEMENTO DE LA COLA
		public String POP() {
			String axu = null;
			if(EMPTY() != true) {
				axu = cola[frente];
				cola[frente]=null;
				frente = (frente+1)%Max;
				n--;
				if(frente>fin) {
					frente = 0;
					fin = 0;
					n = 0;
				}
				return axu;
			}else {
				return null;
			}
			
		}
		//FUNCION PARA MOSTRAR ELEMENTOS DE LA COLA
		public String RETORNAR() {
				String concat = "";
				for(int i = 0; i<Max; i++) {
					concat = concat + cola[i];
					concat += "\n";
				}
				return concat;
		}
		
		//FUNCION PARA VERIFICAR SI LA COLA ESTA VACIA
		public boolean EMPTY() {
			if(n == 0) {
				return true;
			}else {
				return false;
			}
		}
		
		//FUNCION PARA VERIFICAR SI LA COLA ESTA LLENA
		public boolean FULL() {
			if(n == Max) {
				return true;
			}else {
				return false;
			}
		}
}
