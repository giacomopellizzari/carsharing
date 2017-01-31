package carSharing;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Restituisci extends Shell {
	
	static Database a = new Database();
	static ArrayList<Noleggi> lista = new ArrayList<Noleggi>();
	String temp;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Restituisci shell = new Restituisci(display);
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
	public Restituisci(Display display) {
		super(display, SWT.SHELL_TRIM);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setImage(SWTResourceManager.getImage(Restituisci.class, "/resource/carsharing.png"));
		
		Label lblImportoDovuto = new Label(this, SWT.NONE);
		lblImportoDovuto.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblImportoDovuto.setFont(SWTResourceManager.getFont("Ebrima", 9, SWT.BOLD));
		lblImportoDovuto.setBounds(10, 242, 159, 15);
		lblImportoDovuto.setText("IMPORTO DOVUTO:");
		
		Label lblImporto = new Label(this, SWT.NONE);
		lblImporto.setAlignment(SWT.CENTER);
		lblImporto.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblImporto.setFont(SWTResourceManager.getFont("Ebrima", 9, SWT.BOLD));
		lblImporto.setBounds(251, 242, 81, 15);
		lblImporto.setText("importo");
		
		Label lblPenaleDovuta = new Label(this, SWT.NONE);
		lblPenaleDovuta.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPenaleDovuta.setFont(SWTResourceManager.getFont("Ebrima", 9, SWT.BOLD));
		lblPenaleDovuta.setBounds(10, 263, 159, 15);
		lblPenaleDovuta.setText("PENALE DOVUTA:");
		
		Label lblPenale = new Label(this, SWT.NONE);
		lblPenale.setAlignment(SWT.CENTER);
		lblPenale.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblPenale.setFont(SWTResourceManager.getFont("Ebrima", 9, SWT.BOLD));
		lblPenale.setBounds(251, 263, 81, 15);
		lblPenale.setText("penale");
		
		Button btnChiudi = new Button(this, SWT.NONE);
		btnChiudi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getShell().close();
			}
		});
		btnChiudi.setFont(SWTResourceManager.getFont("Ebrima", 11, SWT.BOLD));
		btnChiudi.setBounds(10, 284, 322, 25);
		btnChiudi.setText("CHIUDI");
		
		Label lblGiorniTotali = new Label(this, SWT.NONE);
		lblGiorniTotali.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGiorniTotali.setFont(SWTResourceManager.getFont("Ebrima", 9, SWT.BOLD));
		lblGiorniTotali.setBounds(10, 200, 159, 15);
		lblGiorniTotali.setText("GIORNI TOTALI:");
		
		Label lblGiorniRitardo = new Label(this, SWT.NONE);
		lblGiorniRitardo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblGiorniRitardo.setFont(SWTResourceManager.getFont("Ebrima", 9, SWT.BOLD));
		lblGiorniRitardo.setBounds(10, 221, 159, 15);
		lblGiorniRitardo.setText("GIORNI RITARDO:");
		
		Label lblTotali = new Label(this, SWT.NONE);
		lblTotali.setAlignment(SWT.CENTER);
		lblTotali.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblTotali.setFont(SWTResourceManager.getFont("Ebrima", 9, SWT.BOLD));
		lblTotali.setBounds(251, 200, 81, 15);
		lblTotali.setText("totali");
		
		Label lblRitardo = new Label(this, SWT.NONE);
		lblRitardo.setAlignment(SWT.CENTER);
		lblRitardo.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblRitardo.setFont(SWTResourceManager.getFont("Ebrima", 9, SWT.BOLD));
		lblRitardo.setBounds(251, 221, 81, 15);
		lblRitardo.setText("Ritardo");
		
		List list = new List(this, SWT.BORDER | SWT.V_SCROLL);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				temp = list.getItem(list.getSelectionIndex());
				System.out.println("temp : " + temp);
			}
		});
		list.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		list.setBounds(10, 10, 322, 153);
		
		Button btnConferma = new Button(this, SWT.NONE);
		btnConferma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int x = list.getSelectionIndex();
				System.out.println(new Date());
				GregorianCalendar gc = new GregorianCalendar();
				System.out.println("Giorno: " + gc.get(Calendar.DAY_OF_MONTH) );
				System.out.println("Mese: " + (gc.get(Calendar.MONTH)+1) );
				System.out.println("Anno: " + gc.get(Calendar.YEAR) );
				if (x != -1){
					for(int y=0;y<lista.size();y++){
						String confronto =lista.get(y).getSocio()+ "  " + lista.get(y).getAuto()+ "  " + lista.get(y).dataInizio + "  " + lista.get(y).dataFine;
						
						//calcolo l'importo
						if(temp.equals(confronto)){
							System.out.println(" temp == confronto ");
							String nol = lista.get(y).getCodNoleggio();
							DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							
							Date date_corrente = new Date();
							format.format(date_corrente);
							String data_inizio = lista.get(y).getDataInizio();
							String data_fine = lista.get(y).getDataFine();
							
							Date date_inizio = new Date();
							Date date_fine = new Date();
							
							try {
								System.out.println(date_inizio);
								date_inizio = format.parse(data_inizio);
								date_fine = format.parse(data_fine);
								System.out.println(date_inizio);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
							int penale = 0;
							int importo = 0;
							
							//calcoli
						    final java.util.Calendar calDataInizio = GregorianCalendar.getInstance();
						    calDataInizio.setTime( date_inizio );
						    
						    
						    final java.util.Calendar calDataFine = GregorianCalendar.getInstance();
						    calDataFine.setTime( date_fine );
						    
						    final java.util.Calendar calCorrente = GregorianCalendar.getInstance();
						    calCorrente.setTime( date_corrente );
						    
						    if(calCorrente.after(calDataFine)){
						    	lblGiorniRitardo.setText("vero");;
						    }
						    
						    
							
							//set text
							String importostr = Integer.toString(importo);
							String penalestr = Integer.toString(penale);
							lblImporto.setText(importostr);
							lblPenale.setText(penalestr);
						}
					}
				}
			}
		});
		btnConferma.setFont(SWTResourceManager.getFont("Ebrima", 11, SWT.BOLD));
		btnConferma.setBounds(10, 169, 322, 25);
		btnConferma.setText("CONFERMA");
		

		createContents();
		
		a.getNoleggi(lista);
		for(int i=0;i<lista.size();i++){
			list.add(lista.get(i).getSocio()+ "  " + lista.get(i).getAuto()+ "  " + lista.get(i).dataInizio + "  " + lista.get(i).dataFine);
		}
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("CARSHARING JACK&ALE&TORRE");
		setSize(358, 358);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
