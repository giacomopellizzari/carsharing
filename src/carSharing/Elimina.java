package carSharing;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

public class Elimina extends Shell {

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
		
		Button btnEliminaNol = new Button(this, SWT.NONE);
		btnEliminaNol.setBounds(272, 29, 75, 25);
		btnEliminaNol.setText("Elimina");
		
		Combo codice_noleggio = new Combo(this, SWT.NONE);
		codice_noleggio.setBounds(10, 31, 163, 23);
		
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
		setSize(369, 200);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
