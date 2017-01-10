package carSharing;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Main {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(581, 530);
		shell.setText("SWT Application");
		
		ArrayList<Auto> a1 = new ArrayList<Auto>(); 
		ArrayList<Soci> a2 = new ArrayList<Soci>(); 
		ArrayList<Noleggi> a3 = new ArrayList<Noleggi>(); 
		Database db = new Database();
		
		List list_auto = new List(shell, SWT.BORDER);
		list_auto.setBounds(10, 14, 71, 68);
		
		List list_soci = new List(shell, SWT.BORDER);
		list_soci.setBounds(10, 88, 71, 68);
		
		List list_noleggi = new List(shell, SWT.BORDER);
		list_noleggi.setBounds(10, 162, 71, 68);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list_auto.removeAll();
				list_soci.removeAll();
				list_noleggi.removeAll();
				db.getAuto(a1);
				System.out.println(a1);
				for(int i=0;i<a1.size();i++){
					list_auto.add(a1.get(i).getMarca() + " " + a1.get(i).getModello() );
				}
				db.getSoci(a2);
				for(int i=0;i<a2.size();i++){
					list_soci.add(a2.get(i).getCognome() + " " + a2.get(i).getNome() );
				}
				db.getNoleggi(a3);
				for(int i=0;i<a3.size();i++){
					list_noleggi.add(a3.get(i).getCodNoleggio());
				}
			}
		});
		btnNewButton.setBounds(349, 10, 75, 25);
		btnNewButton.setText("Refresh");
		
		List list_fill = new List(shell, SWT.BORDER);
		list_fill.setBounds(106, 11, 71, 216);

	}
}
