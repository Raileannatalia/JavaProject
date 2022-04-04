package appTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.junit.jupiter.api.Test;
import Vue.Billeterie;

class BilleterieTest {
	
	Billeterie bil = new Billeterie();
	/*private JTextField textPrice;
	private JTextField textNrTicket;
	private String destination;
	private String depart;
	private String class_;*/

	@Test
	public void initialize() {
		JFrame jf = new JFrame();
		JRadioButton rdbtnStandart = new JRadioButton("Standart");
		jf.setBounds(0, 0, 1164, 700);
		rdbtnStandart.setBounds(42, 193, 141, 23);
	
		assertNotNull(rdbtnStandart);
		//rdbtnStandart.initialize();
		int height=rdbtnStandart.getHeight();
		int width=rdbtnStandart.getWidth();
		
		/*rdbtnStandart.run();
		rdbtnStandart.doClick();
		String str=jf.getText().toString();
		assertEquals("Welcome to junit.",str);
		*/
		
		/*public void actionPerformed(ActionEvent e) {
		
		int nb1;
		String a1 ="";
		nb1 = 2453 + (int) (Math.random()*5680);
		a1+=nb1+2453;
		textNrTicket.setText(a1);
	
		
	}*/
	}
}
	
