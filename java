import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class App {

    public static void main(String[] args) throws Exception {
        JFrame janela = new JFrame();

        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setBounds(50, 50, 100, 30);

        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(50, 80, 100, 30);

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(50, 150, 100, 30);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(50, 120, 100, 30);

        // Spinner para mês
        String[] monthStrings = { "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December" };
        SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
        JSpinner spinnerMes = new JSpinner(monthModel);
        spinnerMes.setBounds(50, 200, 100, 30);

        // Spinner para ano
        SpinnerNumberModel yearModel = new SpinnerNumberModel(2000, 1900, 2025, 1);
        JSpinner spinnerAno = new JSpinner(yearModel);
        spinnerAno.setBounds(170, 200, 80, 30);

        JLabel labelData = new JLabel("Data:");
        labelData.setBounds(50, 170, 100, 30);

        // Botão
        JButton botaoLogar = new JButton("Login");
        botaoLogar.setBounds(50, 260, 100, 30);
        botaoLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());
                String mes = spinnerMes.getValue().toString();
                int ano = (int) spinnerAno.getValue();

                System.out.printf("Usuario: %s\nSenha: %s\nNascimento: %s de %d\n",
                        usuario, senha, mes, ano);

                campoUsuario.setText("");
                campoSenha.setText("");
            }
        });

        janela.add(botaoLogar);
        janela.add(labelSenha);
        janela.add(campoUsuario);
        janela.add(campoSenha);
        janela.add(labelUsuario);
        janela.add(spinnerMes);
        janela.add(spinnerAno);
        janela.add(labelData);

        janela.setLayout(null);
        janela.setBounds(0, 0, 400, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
