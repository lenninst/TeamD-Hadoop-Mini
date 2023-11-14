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
    jPanel1 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jComboBoxTaskSelector = new javax.swing.JComboBox<>();
    btnSeleccionarArchivo = new javax.swing.JButton();
    btnGuardarArchivo = new javax.swing.JButton();
    comboBoxNodos = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    btnProcesar = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("HadoopMini D");

    mainPanel.setForeground(new java.awt.Color(203, 206, 215));

    jPanel1.setForeground(new java.awt.Color(234, 235, 240));

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

    btnProcesar.setBackground(new java.awt.Color(200, 218, 255));
    btnProcesar.setForeground(new java.awt.Color(51, 51, 51));
    btnProcesar.setText("Procesar");
    btnProcesar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnProcesarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(17, 17, 17)
        .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(31, Short.MAX_VALUE))
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addGap(31, 31, 31)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(3, 3, 3)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2)
                .addComponent(jComboBoxTaskSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(comboBoxNodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSeleccionarArchivo)
            .addComponent(btnGuardarArchivo))
          .addContainerGap(33, Short.MAX_VALUE)))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(277, Short.MAX_VALUE)
        .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(jLabel2)
          .addGap(18, 18, 18)
          .addComponent(jComboBoxTaskSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGap(28, 28, 28)
          .addComponent(btnSeleccionarArchivo)
          .addGap(18, 18, 18)
          .addComponent(btnGuardarArchivo)
          .addGap(22, 22, 22)
          .addComponent(jLabel1)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
          .addComponent(comboBoxNodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addContainerGap(77, Short.MAX_VALUE)))
    );

    jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
    jLabel3.setText("HADOOP-MINI");

    jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel4.setText("GRUPO D");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3)
          .addComponent(jLabel4))
        .addGap(0, 190, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel4)
        .addGap(0, 32, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(mainPanelLayout.createSequentialGroup()
            .addGap(131, 131, 131)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(mainPanelLayout.createSequentialGroup()
            .addGap(117, 117, 117)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    mainPanelLayout.setVerticalGroup(
      mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(mainPanelLayout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 64, Short.MAX_VALUE))
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
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel mainPanel;
  // End of variables declaration//GEN-END:variables
}
