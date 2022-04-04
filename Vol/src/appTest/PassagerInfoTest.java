package appTest;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.junit.jupiter.api.Test;

class PassagerInfoTest {

	@Test
	public void PassagerInfo() {
	JButton btnActualiser = new JButton("Actualiser");
	btnActualiser.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			UpdateTable();
		}

		private void UpdateTable() {
			
		}
	});
	}

}
