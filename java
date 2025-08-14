import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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

        //
        JButton botaoLogar = new JButton("Login");
        botaoLogar.setBounds(50, 210, 100, 30);
        botaoLogar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());
                System.out.printf("usuario: %s\nSenha: %s\n", usuario, senha);
                campoUsuario.setText("");
                campoSenha.setText("");
            }

        });

       

        janela.add(botaoLogar);
        janela.add(labelSenha);
        janela.add(campoUsuario);
        janela.add(campoSenha);
        janela.add(labelUsuario);

        // Definir título da minha janela

        janela.setLayout(null);

        // Definir tamanho da minha janela
        janela.setBounds(0, 0, 400, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }
}
