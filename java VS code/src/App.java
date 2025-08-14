import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

        // data atual
        LocalDate hoje = LocalDate.now();
        int anoAtual = hoje.getYear();
        int mesAtual = hoje.getMonthValue();
        int diaAtual = hoje.getDayOfMonth();

        // Spiner de mês

        String[] monthStrings = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };

        SpinnerListModel monthModel = new SpinnerListModel(monthStrings);
        JSpinner spinnerMes = new JSpinner(monthModel);
        spinnerMes.setBounds(50, 200, 100, 30);

        // Spiner de Ano
        SpinnerNumberModel yearModel = new SpinnerNumberModel(2024, 1900, 2100, 1);
        JSpinner spinnerAno = new JSpinner(yearModel);
        spinnerAno.setBounds(160, 200, 100, 30);

        // Spiner de dia

        SpinnerNumberModel dayModel = new SpinnerNumberModel(hoje.getDayOfMonth(), 1,
                YearMonth.of(hoje.getYear(), hoje.getMonthValue()).lengthOfMonth(), 1);

        JSpinner spinnerDia = new JSpinner(dayModel);
        spinnerDia.setBounds(270, 200, 50, 30);

        JLabel labelData = new JLabel("Data de nascimento:");
        labelData.setBounds(50, 170, 200, 30);

        // JLabel para exibir os dados inseridos

        JLabel labeldeResultado = new JLabel("Dados:");
        labeldeResultado.setBounds(50, 300, 300, 30);

        // adicionar ChangeListener para atualizar o dia com base no mês e ano
        // selecionados
        ChangeListener atualizarDias = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int ano = (int) spinnerAno.getValue();
                int mes = java.util.Arrays.asList(monthStrings).indexOf(spinnerMes.getValue()) + 1;
                int maxDias = YearMonth.of(ano, mes).lengthOfMonth();
                int diaAtual = (int) spinnerDia.getValue();
                dayModel.setMaximum(maxDias);
                if (diaAtual > maxDias) {
                    spinnerDia.setValue(maxDias);
                }
            }
        };

        spinnerMes.addChangeListener(atualizarDias);
        spinnerAno.addChangeListener(atualizarDias);

        // botão de login
        JButton botaoLogar = new JButton("Login");
        botaoLogar.setBounds(50, 260, 100, 30);
        botaoLogar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());
                String mes = spinnerMes.getValue().toString();
                int ano = (int) spinnerAno.getValue();
                int dia = (int) spinnerDia.getValue();

                System.out.printf("usuario: %s\nSenha: %s\nData de nascimento: %d de %s de %d\n", usuario, senha, dia,
                        mes, ano);

                // limpar campos
                campoUsuario.setText("");
                campoSenha.setText("");
            }
        });

        // adicionar todas as componentes na minha janela

        janela.add(botaoLogar);
        janela.add(labelUsuario);
        janela.add(labelSenha);
        janela.add(campoUsuario);
        janela.add(campoSenha);
        janela.add(spinnerMes);
        janela.add(spinnerAno);
        janela.add(spinnerDia);
        janela.add(labelData);
        janela.add(labeldeResultado);

        // Definir título da minha janela

        janela.setLayout(null);

        // Definir tamanho da minha janela
        janela.setBounds(0, 0, 400, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }
}
