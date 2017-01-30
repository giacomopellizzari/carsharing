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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.DateTime;

public class Main {

	protected Shell shlCarsharing;
	private DateTime dateTime_1;
	private DateTime dateTime;
	private Database db;
	private List list_fill;
	
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
		shlCarsharing.setImage(SWTResourceManager.getImage(Main.class, "/resource/carsharing.png"));
		shlCarsharing.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		shlCarsharing.setSize(818, 530);
		shlCarsharing.setText("CARSHARING JACK&ALE&TORRE");
		
		ArrayList<Auto> a1 = new ArrayList<Auto>(); 
		ArrayList<Soci> a2 = new ArrayList<Soci>(); 
		ArrayList<Noleggi> a3 = new ArrayList<Noleggi>(); 
		db = new Database();
		
		Label lblNewLabel_1 = new Label(shlCarsharing, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Main.class, "/resource/carsharing.png"));
		lblNewLabel_1.setBounds(406, 180, 168, 211);
		
		list_fill = new List(shlCarsharing, SWT.BORDER);
		list_fill.setBounds(237, 39, 337, 373);
		
		List list_auto = new List(shlCarsharing, SWT.BORDER);
		list_auto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				list_fill.removeAll();
				list_fill.add(a1.get(list_auto.getSelectionIndex()).getMarca() + " " +  a1.get(list_auto.getSelectionIndex()).getModello() + " " + a1.get(list_auto.getSelectionIndex()).getTarga() + " " + a1.get(list_auto.getSelectionIndex()).getCosto_giornaliero());
			}
		});
		list_auto.setBounds(10, 39, 207, 68);
		
		List list_soci = new List(shlCarsharing, SWT.BORDER);
		list_soci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				list_fill.removeAll();
				list_fill.add(a2.get(list_soci.getSelectionIndex()).getNome() + " " +  a2.get(list_soci.getSelectionIndex()).getCognome() + " " + a2.get(list_soci.getSelectionIndex()).getCf() + " " + a2.get(list_soci.getSelectionIndex()).getIndirizzo());
			}
		});
		list_soci.setBounds(10, 145, 207, 82);
		
		List list_noleggi = new List(shlCarsharing, SWT.BORDER);
		list_noleggi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				list_fill.removeAll();
				list_fill.add(a3.get(list_noleggi.getSelectionIndex()).getAuto() + " " +  a3.get(list_noleggi.getSelectionIndex()).getCodNoleggio() + " " + a3.get(list_noleggi.getSelectionIndex()).getDataInizio() + " " + a3.get(list_noleggi.getSelectionIndex()).getDataFine() + " " + a3.get(list_noleggi.getSelectionIndex()).getSocio() );
			}
		});
		list_noleggi.setBounds(10, 263, 207, 149);
		
		Button btnNewButton = new Button(shlCarsharing, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
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
		
		Label lblNewLabel = new Label(shlCarsharing, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblNewLabel.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblNewLabel.setBounds(69, 18, 55, 15);
		lblNewLabel.setText("AUTO");
		
		Label lblSoci = new Label(shlCarsharing, SWT.NONE);
		lblSoci.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblSoci.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSoci.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblSoci.setBounds(69, 124, 55, 15);
		lblSoci.setText("SOCI");
		
		Label lblNoleggi = new Label(shlCarsharing, SWT.NONE);
		lblNoleggi.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNoleggi.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblNoleggi.setFont(SWTResourceManager.getFont("Ebrima", 10, SWT.BOLD));
		lblNoleggi.setBounds(69, 242, 55, 15);
		lblNoleggi.setText("NOLEGGI");
		
		Label lblInformazioni = new Label(shlCarsharing, SWT.NONE);
		lblInformazioni.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblInformazioni.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
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
		
		dateTime = new DateTime(shlCarsharing, SWT.BORDER);
		dateTime.setBounds(628, 83, 80, 24);
		
		dateTime_1 = new DateTime(shlCarsharing, SWT.BORDER);
		dateTime_1.setBounds(628, 145, 80, 24);
		
		Button btnMostraINoleggi = new Button(shlCarsharing, SWT.NONE);
		btnMostraINoleggi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				list_fill.removeAll();
				fai();
			}
		});
		btnMostraINoleggi.setBounds(607, 39, 185, 25);
		btnMostraINoleggi.setText("Mostra i noleggi");
		
		Label lblDa = new Label(shlCarsharing, SWT.NONE);
		lblDa.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblDa.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblDa.setBounds(607, 86, 19, 15);
		lblDa.setText("da");
		
		Label lblA = new Label(shlCarsharing, SWT.NONE);
		lblA.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblA.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		lblA.setBounds(612, 148, 10, 15);
		lblA.setText("a");
		
		Button btnRestituisci = new Button(shlCarsharing, SWT.BORDER | SWT.FLAT);
		btnRestituisci.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Restituisci restituisci = new Restituisci(Display.getDefault());
				restituisci.open();
			}
		});
		btnRestituisci.setFont(SWTResourceManager.getFont("Ebrima", 15, SWT.BOLD | SWT.ITALIC));
		btnRestituisci.setBounds(592, 332, 200, 149);
		btnRestituisci.setText("RESTITUISCI AUTO");

	}
		private void fai(){
			String dataInizio,dataFine;
			dataInizio = dateTime.getYear() + "/" + (dateTime.getMonth()+1) + "/" + dateTime.getDay();
			dataFine = dateTime_1.getYear() + "/" + (dateTime_1.getMonth()+1) + "/" + dateTime_1.getDay();
			db.cercaNoleggi(dataInizio, dataFine, this);
	}
		public void nol(String s){
			Display.getDefault().asyncExec(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					list_fill.add(s);
					
				}
				
			});
		}
}
