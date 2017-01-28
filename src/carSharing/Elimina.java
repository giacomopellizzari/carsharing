package carSharing;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Elimina extends Shell {
	
	static Database a = new Database();
	static ArrayList<Noleggi> lista = new ArrayList<Noleggi>();
	ArrayList<Auto> listaAuto = new ArrayList<Auto>();

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
		codice_noleggio.setBounds(10, 42, 354, 23);
		
		Button btnEliminaNol = new Button(this, SWT.NONE);
		btnEliminaNol.setFont(SWTResourceManager.getFont("Ebrima", 11, SWT.BOLD));
		btnEliminaNol.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int x = codice_noleggio.getSelectionIndex();
				String temp;
				temp = codice_noleggio.getText();
				
				
				if (x != -1){
					for(int y=0;y<lista.size();y++){
						String confronto =lista.get(y).getSocio()+ "  " + lista.get(y).getAuto()+ "  " + lista.get(y).dataInizio + "  " + lista.get(y).dataFine;
						
						//elimino
						if(temp.equals(confronto)){
							System.out.println(" temp == confronto");
							a.Elimina(lista,Integer.parseInt(lista.get(y).getCodNoleggio()));
							codice_noleggio.setText("");
							a.getNoleggi(lista);
							
							//pulisco la combo
							codice_noleggio.removeAll();
							//riscrivo i noleggi disponibili
							for(int i=0;i<lista.size();i++){
								codice_noleggio.add(lista.get(i).getSocio()+ "  " + lista.get(i).getAuto()+ "  " + lista.get(i).dataInizio + "  " + lista.get(i).dataFine);
							}
							getShell().close();
						}else{
							
						}
					}
					
				} else {
					//lanciare messaggio di errore
					MessageBox messageBox = new MessageBox(getShell());
					messageBox.setText("ERRORE");
					messageBox.setMessage("Inserire un opzione valida");
					messageBox.open();
				}
				
			}
		});
		btnEliminaNol.setBounds(370, 40, 75, 25);
		btnEliminaNol.setText("Elimina");
		
		
		
	
		a.getNoleggi(lista);
		for(int i=0;i<lista.size();i++){
			codice_noleggio.add(lista.get(i).getSocio()+ "  " + lista.get(i).getAuto()+ "  " + lista.get(i).dataInizio + "  " + lista.get(i).dataFine);
		}
		
		
		Label lblNoleggioDaEliminare = new Label(this, SWT.NONE);
		lblNoleggioDaEliminare.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblNoleggioDaEliminare.setBounds(24, 10, 163, 26);
		lblNoleggioDaEliminare.setText("Noleggio da eliminare");
		
		Label lblAutoDaEliminare = new Label(this, SWT.NONE);
		lblAutoDaEliminare.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblAutoDaEliminare.setBounds(24, 186, 227, 27);
		lblAutoDaEliminare.setText("Auto da eliminare:");
		
		Combo comboEliminiaAuto = new Combo(this, SWT.NONE);
		comboEliminiaAuto.setBounds(10, 219, 354, 23);
		
		Button btnElimina = new Button(this, SWT.NONE);
		btnElimina.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				a.getAuto(listaAuto);
				for(int i=0;i<listaAuto.size();i++){
					comboEliminiaAuto.add(listaAuto.get(i).getTarga());
					
				}
			}
		});
		btnElimina.setFont(SWTResourceManager.getFont("Ebrima", 11, SWT.BOLD));
		btnElimina.setBounds(370, 217, 75, 25);
		btnElimina.setText("Elimina");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Elimina");
		setSize(471, 417);
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public void Start(){
	}
}
