package carSharing;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Elimina extends Shell {
	
	static Database a = new Database();
	static ArrayList<Noleggi> lista = new ArrayList<Noleggi>();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		
		try {
			Display display = Display.getDefault();
			Elimina shell = new Elimina(display);
			shell.open();
			shell.layout();
			a.getNoleggi(lista);
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
	public Elimina(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Combo codice_noleggio = new Combo(this, SWT.NONE);
		codice_noleggio.setBounds(10, 31, 354, 23);
		
		Button btnEliminaNol = new Button(this, SWT.NONE);
		btnEliminaNol.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int x = codice_noleggio.getSelectionIndex();
				String temp;
				temp = codice_noleggio.getText();
				if (x != -1){
					System.out.println("il numero selezionato è " + x);
					a.Elimina(lista, x);
				} else {
					//lanciare messaggio di errore
				}
				
			}
		});
		btnEliminaNol.setBounds(370, 29, 75, 25);
		btnEliminaNol.setText("Elimina");
		
		
		a.getNoleggi(lista);
		for(int i=0;i<lista.size();i++){
			codice_noleggio.add(lista.get(i).getSocio()+ "  " + lista.get(i).getAuto()+ "  " + lista.get(i).dataInizio + "  " + lista.get(i).dataFine);
			
		}
		
		
		Label lblNoleggioDaEliminare = new Label(this, SWT.NONE);
		lblNoleggioDaEliminare.setBounds(24, 10, 163, 15);
		lblNoleggioDaEliminare.setText("Noleggio da eliminare");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Elimina");
		setSize(471, 200);
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public void Start(){
	}
}
