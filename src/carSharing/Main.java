package carSharing;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Main {

	protected Shell shlCarsharing;

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
		
		shlCarsharing.open();
		shlCarsharing.layout();
		while (!shlCarsharing.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCarsharing = new Shell();
		shlCarsharing.setSize(600, 530);
		shlCarsharing.setText("Carsharing");
		
		ArrayList<Auto> a1 = new ArrayList<Auto>(); 
		ArrayList<Soci> a2 = new ArrayList<Soci>(); 
		ArrayList<Noleggi> a3 = new ArrayList<Noleggi>(); 
		Database db = new Database();
		
		Label lblNewLabel_1 = new Label(shlCarsharing, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Main.class, "/resource/carsharing.png"));
		lblNewLabel_1.setBounds(406, 180, 168, 211);
		
		List list_auto = new List(shlCarsharing, SWT.BORDER);
		list_auto.setBounds(10, 39, 207, 68);
		
		List list_soci = new List(shlCarsharing, SWT.BORDER);
		list_soci.setBounds(10, 145, 207, 82);
		
		List list_noleggi = new List(shlCarsharing, SWT.BORDER);
		list_noleggi.setBounds(10, 263, 207, 149);
		
		Button btnNewButton = new Button(shlCarsharing, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Ebrima", 14, SWT.BOLD | SWT.ITALIC));
		btnNewButton.setSelection(true);
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
		btnNewButton.setBounds(10, 441, 109, 40);
		btnNewButton.setText("Refresh");
		
		List list_fill = new List(shlCarsharing, SWT.BORDER);
		list_fill.setBounds(237, 39, 337, 373);
		
		Label lblNewLabel = new Label(shlCarsharing, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblNewLabel.setBounds(69, 18, 55, 15);
		lblNewLabel.setText("AUTO");
		
		Label lblSoci = new Label(shlCarsharing, SWT.NONE);
		lblSoci.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblSoci.setBounds(69, 124, 55, 15);
		lblSoci.setText("SOCI");
		
		Label lblNoleggi = new Label(shlCarsharing, SWT.NONE);
		lblNoleggi.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblNoleggi.setBounds(69, 242, 55, 15);
		lblNoleggi.setText("NOLEGGI");
		
		Label lblInformazioni = new Label(shlCarsharing, SWT.NONE);
		lblInformazioni.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblInformazioni.setBounds(274, 18, 109, 15);
		lblInformazioni.setText("INFORMAZIONI:");
		
		Button btnNoleggio = new Button(shlCarsharing, SWT.NONE);
		btnNoleggio.setFont(SWTResourceManager.getFont("Ebrima", 14, SWT.BOLD | SWT.ITALIC));
		btnNoleggio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Noleggio noleggio = new Noleggio(Display.getDefault());
				noleggio.open();
				
			}
		});
		btnNoleggio.setBounds(331, 441, 243, 40);
		btnNoleggio.setText("NUOVO NOLEGGIO");
		
		Button btnElimina = new Button(shlCarsharing, SWT.NONE);
		btnElimina.setFont(SWTResourceManager.getFont("Ebrima", 14, SWT.BOLD | SWT.ITALIC));
		btnElimina.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Elimina elimina = new Elimina(Display.getDefault());
				elimina.open();
			}
		});
		btnElimina.setBounds(125, 441, 200, 40);
		btnElimina.setText("ELIMINA NOLEGGIO");

	}
}
