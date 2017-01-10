package carSharing;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;

public class Noleggio extends Shell {
	private Text text;
	private Text text_1;

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
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(98, 23, 133, 21);
		
		Label lblAuto = new Label(this, SWT.NONE);
		lblAuto.setBounds(10, 29, 55, 15);
		lblAuto.setText("Auto");
		
		Label lblSocio = new Label(this, SWT.NONE);
		lblSocio.setBounds(10, 64, 55, 15);
		lblSocio.setText("Socio");
		
		Label lblInizio = new Label(this, SWT.NONE);
		lblInizio.setBounds(10, 97, 55, 15);
		lblInizio.setText("Inizio");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(10, 129, 55, 15);
		lblNewLabel.setText("Fine");
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(98, 58, 133, 21);
		
		DateTime dateTime = new DateTime(this, SWT.BORDER);
		dateTime.setBounds(98, 97, 80, 24);
		
		DateTime dateTime_1 = new DateTime(this, SWT.BORDER);
		dateTime_1.setBounds(98, 129, 80, 24);
		
		Button btnNoleggia = new Button(this, SWT.NONE);
		btnNoleggia.setBounds(349, 201, 75, 25);
		btnNoleggia.setText("Noleggia");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Noleggio");
		setSize(450, 271);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
