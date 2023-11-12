package View;

import static Controller.Converters.DataItemConverter.parseTaskFromItem;
import Controller.Extensions.ControllerUtils;
import Controller.Extractors.NumberExtractor;
import Controller.Processors.DataProcessor;
import MapReduce.VersionTask.AbstractTask;
import View.Utils.ComboBoxUtils;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author kanguro
 */
public class HadoopMiniUI extends javax.swing.JFrame {

	/**
	 * Creates new form HadoopMiniUI
	 */
	public HadoopMiniUI() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainPanel = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jComboBoxTaskSelector = new javax.swing.JComboBox<>();
    btnSeleccionarArchivo = new javax.swing.JButton();
    btnGuardarArchivo = new javax.swing.JButton();
    comboBoxNodos = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    btnProcesar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("HadoopMini D");

    jLabel2.setText("Seleccionar tarea");

    ArrayList<String> taskElement = ComboBoxUtils.taskItems();
    jComboBoxTaskSelector.setModel(new DefaultComboBoxModel<>(taskElement.toArray(new String [0])) );
    jComboBoxTaskSelector.setSelectedItem(taskElement);
    jComboBoxTaskSelector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBoxTaskSelectorActionPerformed(evt);
      }
    });

    btnSeleccionarArchivo.setText("Ingresar archivo");
    btnSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSeleccionarArchivoActionPerformed(evt);
      }
    });

    btnGuardarArchivo.setText("Agregar destino");
    btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGuardarArchivoActionPerformed(evt);
      }
    });

    int nodes = ControllerUtils.coreNumbers();
    ArrayList<String> model = ComboBoxUtils.nodeGenerator(nodes);
    comboBoxNodos.setModel(new DefaultComboBoxModel<>(model.toArray(new String[0])));
    comboBoxNodos.setSelectedItem(model);
    comboBoxNodos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxNodosActionPerformed(evt);
      }
    });

    jLabel1.setText("Seleccionar cantidad nodos");

    btnProcesar.setText("Procesar");
    btnProcesar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnProcesarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
        .addContainerGap(24, Short.MAX_VALUE)
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(btnSeleccionarArchivo)
          .addComponent(btnGuardarArchivo)
          .addComponent(jLabel1)
          .addComponent(btnProcesar)
          .addGroup(mainPanelLayout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(jComboBoxTaskSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(comboBoxNodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(499, 499, 499))
    );
    mainPanelLayout.setVerticalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addComponent(jLabel2)
        .addGap(18, 18, 18)
        .addComponent(jComboBoxTaskSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(28, 28, 28)
        .addComponent(btnSeleccionarArchivo)
        .addGap(18, 18, 18)
        .addComponent(btnGuardarArchivo)
        .addGap(18, 18, 18)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(comboBoxNodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(26, 26, 26)
        .addComponent(btnProcesar)
        .addContainerGap(55, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

	private int nodesNumber;
	private String inputPath; 
	private String outputPath;
	private AbstractTask taskSelected;
	
  private void btnSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarArchivoActionPerformed
		JFileChooser fileChooser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt, *.csv)", "txt", "csv");		
        fileChooser.setFileFilter(filter);
        
		int result = fileChooser.showOpenDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			  inputPath = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println("Archivo seleccionado: " + inputPath);
		}
  }//GEN-LAST:event_btnSeleccionarArchivoActionPerformed

  private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed
		JFileChooser fileChooser = new JFileChooser ();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt, *.csv)", "txt", "csv");		
        fileChooser.setFileFilter(filter);
		int result = fileChooser.showSaveDialog (this);

		if (result == JFileChooser.APPROVE_OPTION){
			 outputPath = fileChooser.getSelectedFile().getAbsolutePath();
			System.out.println("Directorio selecionado para guardar en " + outputPath);
			
		}
		
  }//GEN-LAST:event_btnGuardarArchivoActionPerformed

  private void comboBoxNodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNodosActionPerformed
		String nodeSelected = (String) comboBoxNodos.getSelectedItem();
		  nodesNumber = NumberExtractor.parseNumberFromString(nodeSelected);

		System.out.println("Cantidad de nodos seleccionado es : " + nodesNumber);
  }//GEN-LAST:event_comboBoxNodosActionPerformed

  private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
		System.out.println("procesando ..... ");
		 DataProcessor.launchDataProcessor(taskSelected, inputPath, outputPath ,nodesNumber );
	 	System.out.println("Proceso finalizado ..... ");
  }//GEN-LAST:event_btnProcesarActionPerformed

  private void jComboBoxTaskSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTaskSelectorActionPerformed
		 String taskItemSelected = (String) jComboBoxTaskSelector.getSelectedItem();
		 taskSelected = parseTaskFromItem(taskItemSelected);
		 

		 System.out.println(" la tares seleccionada es: " + taskItemSelected);
		  System.out.println("Objeto de tarea seleccionada: " + taskSelected);
		
    // TODO add your handling code here:
  }//GEN-LAST:event_jComboBoxTaskSelectorActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(HadoopMiniUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(HadoopMiniUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(HadoopMiniUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(HadoopMiniUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HadoopMiniUI().setVisible(true);
			}
		});
	}

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnGuardarArchivo;
  private javax.swing.JButton btnProcesar;
  private javax.swing.JButton btnSeleccionarArchivo;
  private javax.swing.JComboBox<String> comboBoxNodos;
  private javax.swing.JComboBox<String> jComboBoxTaskSelector;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel mainPanel;
  // End of variables declaration//GEN-END:variables
}
