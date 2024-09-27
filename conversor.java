import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class conversor extends JFrame {

    private JTextField hexInput;
    private JTextArea resultArea;
    private JButton convertButton;

    public conversor() {
        setTitle("Conversor Hexadecimal a Decimal y Binario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        hexInput = new JTextField();
        resultArea = new JTextArea();
        convertButton = new JButton("Convertir");

        add(new JLabel("Ingresa un número hexadecimal:"), BorderLayout.NORTH);
        add(hexInput, BorderLayout.CENTER);
        add(convertButton, BorderLayout.EAST);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        convertButton.addActionListener(new ConvertAction());

        setVisible(true);
    }

    private class ConvertAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hex = hexInput.getText();
            try {
                // Convertir el hexadecimal a decimal
                int intValue = Integer.parseUnsignedInt(hex, 16);
                // Convertir el entero a binario
                String binaryValue = Integer.toBinaryString(intValue);
                // Formatear el resultado
                String result = String.format("Decimal: %d\nBinario: %s", intValue, binaryValue);
                resultArea.setText(result);
            } catch (NumberFormatException ex) {
                resultArea.setText("Entrada no válida. Asegúrate de ingresar un número hexadecimal.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new conversor());
    }
}
