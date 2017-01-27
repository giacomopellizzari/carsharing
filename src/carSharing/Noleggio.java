package carSharing;

import java.util.ArrayList;

import javax.xml.crypto.Data;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;


public class Noleggio extends Shell {
	String auto,socio;
	static Database a = new Database();
	static ArrayList<Noleggi> lista = new ArrayList<Noleggi>();

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
		
		Label lblAuto = new Label(this, SWT.NONE);
		lblAuto.setBounds(10, 29, 55, 15);
		lblAuto.setText("Auto");
		
		Label lblSocio = new Label(this, SWT.NONE);
		lblSocio.setBounds(10, 104, 55, 15);
		lblSocio.setText("Socio");
		
		Label lblInizio = new Label(this, SWT.NONE);
		lblInizio.setBounds(10, 188, 55, 15);
		lblInizio.setText("Inizio");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(10, 244, 55, 15);
		lblNewLabel.setText("Fine");
		
		Combo comboAuto = new Combo(this, SWT.NONE);
		comboAuto.setBounds(71, 29, 217, 23);
		
		Combo comboSocio = new Combo(this, SWT.NONE);
		comboSocio.setBounds(71, 96, 217, 23);
		
		DateTime StringTimeInizio = new DateTime(this, SWT.BORDER);
		StringTimeInizio.setBounds(98, 179, 80, 24);
		
		DateTime StringTimeFine = new DateTime(this, SWT.BORDER);
		StringTimeFine.setBounds(98, 235, 80, 24);
		
		a.getNoleggi(lista);
		for(int i=0;i<lista.size();i++){
			comboAuto.add(lista.get(i).getAuto());
			comboSocio.add(lista.get(i).getSocio());
		}
		
		Button btnNoleggia = new Button(this, SWT.NONE);
		btnNoleggia.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//inserisco sui combo gli elementi
				String auto;
				String Socio;
				String dataInizio;
				String dataFine;
				a.getNoleggi(lista);
				
				auto = comboAuto.getText();
				Socio = comboAuto.getText();
				dataInizio = (String) StringTimeInizio.getData();
				dataFine = (String) StringTimeFine.getData();
				
				Noleggi nol = new Noleggi(auto, Socio, dataInizio, dataFine, false);
				a.Aggiungi(nol);
				
				//pulisco ed aggiorno le combo
				comboAuto.removeAll();
				comboSocio.removeAll();
				for(int i=0;i<lista.size();i++){
					comboAuto.add(lista.get(i).getAuto());
					comboSocio.add(lista.get(i).getSocio());
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
		setText("Noleggio");
		setSize(327, 319);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	

}
