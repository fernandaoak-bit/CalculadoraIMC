import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraIMC extends JFrame {

    private JTextField campoPeso;
    private JTextField campoAltura;
    private JLabel resultado;
    private JLabel classificacao;

    public CalculadoraIMC() {

        setTitle("Calculadora IMC");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel labelPeso = new JLabel("Peso (Kg):");
        campoPeso = new JTextField();

        JLabel labelAltura = new JLabel("Altura (Cm):");
        campoAltura = new JTextField();

        JButton botaoCalcular = new JButton("Calcular IMC");

        resultado = new JLabel("Resultado: ");
        classificacao = new JLabel("Classificação: ");

        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    double peso = Double.parseDouble(campoPeso.getText());
                    double alturaCm = Double.parseDouble(campoAltura.getText());

                    double alturaM = alturaCm / 100;

                    double imc = peso / (alturaM * alturaM);

                    String classe;

                    if (imc < 18.5) {
                        classe = "Magreza";
                    } else if (imc < 25) {
                        classe = "Normal";
                    } else if (imc < 30) {
                        classe = "Sobrepeso";
                    } else if (imc < 40) {
                        classe = "Obesidade";
                    } else {
                        classe = "Obesidade Grave";
                    }

                    resultado.setText(String.format("Resultado: %.2f", imc));
                    classificacao.setText("Classificação: " + classe);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Digite valores válidos!");
                }
            }
        });

        painel.add(labelPeso);
        painel.add(campoPeso);

        painel.add(labelAltura);
        painel.add(campoAltura);

        painel.add(new JLabel(""));
        painel.add(botaoCalcular);

        painel.add(resultado);
        painel.add(classificacao);

        add(painel);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraIMC().setVisible(true);
            }
        });
    }
}
