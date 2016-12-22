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
		shell.setSize(450, 300);
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
				db.getAuto(a1);
				System.out.println(a1);
				db.getSoci(a2);
				System.out.println(a2);
			}
		});
		btnNewButton.setBounds(349, 10, 75, 25);
		btnNewButton.setText("Refresh");

	}
}
