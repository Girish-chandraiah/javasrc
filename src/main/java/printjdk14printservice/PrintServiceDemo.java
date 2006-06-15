package printjdk14printservice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.darwinsys.swingui.UtilGUI;

/**
 * Show the PrintService, a more high-level API than PrintJob, from a GUI.
 */
public class PrintServiceDemo extends JFrame {

	private static final long serialVersionUID = 923572304627926023L;
	
	private static final String FILE_NAME = "duke.gif";

	/** main program: instantiate and show. 
	 * @throws IOException */
	public static void main(String[] av) throws IOException {
		new PrintServiceDemo().setVisible(true);
	}

	/** Constructor */
	PrintServiceDemo() {
		setLayout(new FlowLayout());
		JButton b;
		add(b = new JButton("Print"));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					print(FILE_NAME);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(PrintServiceDemo.this, "Error: " + e1, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pack();
		UtilGUI.center(this);
	}

	/** Print a file by name 
	 * @throws IOException
	 */
	public void print(String fileName) throws IOException {
	
		System.out.println("Printing " + fileName);
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.GIF;
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		aset.add(MediaSizeName.NA_LETTER);
		PrintService[] pservices = PrintServiceLookup.lookupPrintServices(
				flavor, aset);
		if (pservices.length > 0) {
			DocPrintJob pj = pservices[0].createPrintJob();
			Doc doc = new MyDemoDoc(FILE_NAME, flavor);
			try {
				pj.print(doc, aset);
			} catch (PrintException e) {
				JOptionPane.showMessageDialog(PrintServiceDemo.this,
						"Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Simple holder for filename and document flavor.
	 */
	final class MyDemoDoc implements Doc {
		
		private DocFlavor flavor;
		private String fileName;

		public MyDemoDoc(String fileName, DocFlavor flavor) {
			this.fileName = fileName;
			this.flavor = flavor;
		}

		public DocFlavor getDocFlavor() {
			return flavor;
		}

		public Object getPrintData() throws IOException {
			return null;
		}

		public DocAttributeSet getAttributes() {
			return null;
		}

		public Reader getReaderForText() throws IOException {
			return null;
		}

		public InputStream getStreamForBytes() throws IOException {
			return getClass().getResourceAsStream(fileName);
		}
	}
}