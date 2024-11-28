import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SistemaBancario {
    private JTextField txtSaldo;
    private JButton saqueButton;
    private JButton depositoButton;
    private JTextField txtValorSaque;
    private JTextField txtValorDeposito;

        private static double saldo = 500.0;

        public static void main(String[] args) {

            JFrame frame = new JFrame("Sistema Bancário");
            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            JTextField txtValorSaque = new JTextField("Saldo: R$ " + String.format("%.2f", saldo));
            txtValorSaque.setBounds(20, 20, 200, 30);
            frame.add(txtValorSaque);

            JLabel saqueLabel = new JLabel("Valor do Saque:");
            saqueLabel.setBounds(20, 60, 120, 30);
            frame.add(saqueLabel);

            JTextField saqueField = new JTextField();
            saqueField.setBounds(140, 60, 120, 30);
            frame.add(saqueField);

            JButton saqueButton = new JButton("Realizar Saque");
            saqueButton.setBounds(270, 60, 120, 30);
            frame.add(saqueButton);

            JLabel depositoLabel = new JLabel("Valor do Depósito:");
            depositoLabel.setBounds(20, 100, 120, 30);
            frame.add(depositoLabel);

            JTextField depositoField = new JTextField();
            depositoField.setBounds(140, 100, 120, 30);
            frame.add(depositoField);

            JButton depositoButton = new JButton("Realizar Depósito");
            depositoButton.setBounds(270, 100, 120, 30);
            frame.add(depositoButton);

            JTextArea mensagemArea = new JTextArea();
            mensagemArea.setBounds(20, 150, 360, 80);
            mensagemArea.setEditable(false);
            frame.add(mensagemArea);

            saqueButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double saque = Double.parseDouble(saqueField.getText());
                        if (saque <= 0) {
                            mensagemArea.setText("Erro: O valor do saque deve ser positivo.");
                        } else if (saque > saldo) {
                            mensagemArea.setText("Erro: Saldo insuficiente.");
                        } else {
                            saldo -= saque;
                            txtValorSaque.setText("Saldo: R$ " + String.format("%.2f", saldo));
                            mensagemArea.setText("Saque de R$ " + saque + " realizado com sucesso.");
                        }
                    } catch (NumberFormatException ex) {
                        mensagemArea.setText("Erro: Entrada inválida para saque.");
                    }
                }
            });

            depositoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double deposito = Double.parseDouble(depositoField.getText());
                        if (deposito <= 0) {
                            mensagemArea.setText("Erro: O valor do depósito deve ser positivo.");
                        } else if (deposito > 1000) {
                            mensagemArea.setText("Erro: Depósito acima do limite permitido (R$ 1000).");
                        } else {
                            saldo += deposito;
                            txtValorSaque.setText("Saldo: R$ " + String.format("%.2f", saldo));
                            mensagemArea.setText("Depósito de R$ " + deposito + " realizado com sucesso.");
                        }
                    } catch (NumberFormatException ex) {
                        mensagemArea.setText("Erro: Entrada inválida para depósito.");
                    }
                }
            });

            frame.setVisible(true);
        }
    }

