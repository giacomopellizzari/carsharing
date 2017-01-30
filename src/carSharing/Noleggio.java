package carSharing;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.crypto.Data;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;


public class Noleggio extends Shell {
	String auto,socio;
	static Database a = new Database();
	static ArrayList<Noleggi> lista = new ArrayList<Noleggi>();
	static ArrayList<Auto> listauto = new ArrayList<Auto>();
	static ArrayList<Soci> listasoci = new ArrayList<Soci>();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Noleggio shell = new Noleggio(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Noleggio(Display display) {
		
		
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(Noleggio.class, "/resource/carsharing.png"));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		
		Label lblAuto = new Label(this, SWT.NONE);
		lblAuto.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		lblAuto.setForeground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		lblAuto.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblAuto.setBounds(10, 29, 55, 15);
		lblAuto.setText("AUTO");
		
		Label lblSocio = new Label(this, SWT.NONE);
		lblSocio.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		lblSocio.setForeground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		lblSocio.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblSocio.setBounds(10, 104, 55, 15);
		lblSocio.setText("SOCIO");
		
		Label lblInizio = new Label(this, SWT.NONE);
		lblInizio.setForeground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		lblInizio.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		lblInizio.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblInizio.setBounds(10, 188, 55, 15);
		lblInizio.setText("INIZIO");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		lblNewLabel.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblNewLabel.setBounds(10, 244, 55, 15);
		lblNewLabel.setText("FINE");
		
		Combo comboAuto = new Combo(this, SWT.NONE);
		comboAuto.setBounds(71, 29, 217, 23);
		
		Combo comboSocio = new Combo(this, SWT.NONE);
		comboSocio.setBounds(71, 96, 217, 23);
		
		DateTime StringTimeInizio = new DateTime(this, SWT.BORDER);
		StringTimeInizio.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		StringTimeInizio.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		StringTimeInizio.setBounds(98, 179, 80, 24);
		
		DateTime StringTimeFine = new DateTime(this, SWT.BORDER);
		StringTimeFine.setBounds(98, 235, 80, 24);
		
		a.getNoleggi(lista);
		a.getAuto(listauto);
		a.getSoci(listasoci);
		for(int i=0;i<listauto.size();i++){
			comboAuto.add(listauto.get(i).getTarga());
		}
		for(int i=0;i<listasoci.size();i++){
			comboSocio.add(listasoci.get(i).getCognome());
		}
		
		
		Button btnNoleggia = new Button(this, SWT.NONE);
		btnNoleggia.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		btnNoleggia.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//inserisco sui combo gli elementi
				String auto;
				String Socio = "";
				String confronto;
				String dataInizio;
				String dataFine;
				a.getNoleggi(lista);
				
			
				dataInizio = StringTimeInizio.getYear() + "/" + (StringTimeInizio.getMonth()+1) + "/" + StringTimeInizio.getDay();
				dataFine = StringTimeFine.getYear() + "/" + (StringTimeFine.getMonth()+1) + "/" + StringTimeFine.getDay();
				
				//lista = a.getRicercaAuto(auto);
				int x = comboAuto.getSelectionIndex();
				int v = comboSocio.getSelectionIndex();
				
				if(x!=-1 && v!=-1){
					auto = comboAuto.getText();
					
					String temp = comboSocio.getText();
					for(int y=0;y<listasoci.size();y++){
						confronto = listasoci.get(y).getCognome();
						System.out.println("temp "+ temp +" confronto "+ confronto);
						//aggiungo
						if(temp.equals(confronto)){
							Socio = listasoci.get(y).getCf();
							System.out.println("entro nel IF");
						}
					}
					Noleggi nol = new Noleggi(auto, Socio, dataInizio, dataFine, false);
					a.Aggiungi(nol);
					
					//pulisco ed aggiorno le combo
					comboAuto.removeAll();
					comboSocio.removeAll();
					for(int i=0;i<listauto.size();i++){
						comboAuto.add(listauto.get(i).getTarga());
					}
					for(int i=0;i<listasoci.size();i++){
						comboSocio.add(listasoci.get(i).getCognome());
					}
				}else{
					//lanciare messaggio di errore
					MessageBox messageBox = new MessageBox(getShell());
					messageBox.setText("ERRORE");
					messageBox.setMessage("Inserire un opzione valida");
					messageBox.open();
				}


			}
		});
		btnNoleggia.setBounds(213, 179, 75, 80);
		btnNoleggia.setText("INSERISCI");
		
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("CARSHARING JACK&ALE&TORRE");
		setSize(327, 319);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	

}
