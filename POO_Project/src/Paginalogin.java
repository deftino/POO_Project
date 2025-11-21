import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Paginalogin implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Cadastrar");
    JTextField userField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel user = new JLabel("Usuário: ");
    JLabel password = new JLabel("Senha: ");
    JLabel titulo = new JLabel("LOGIN");
    JLabel message = new JLabel();
    
    Autenticacao autenticacao;
    
    HashMap<String, String> lf = new HashMap<>();
    
    public Paginalogin(HashMap<String, String> lforiginal, Autenticacao auth) {
        this.autenticacao = auth;
        lf.putAll(lforiginal);
        
        user.setBounds(50, 100, 75, 50);
        password.setBounds(50, 150, 75, 50);
        titulo.setBounds(155, 10, 200, 75);
        titulo.setFont(new Font(null, Font.ITALIC, 30));
        message.setBounds(105, 235, 120, 120);
        message.setFont(new Font(null, Font.PLAIN, 15));
        
        userField.setBounds(105, 110, 205, 30);
        passwordField.setBounds(105, 160, 205, 30);
        
        loginButton.setBounds(105, 200, 100, 50);
        loginButton.addActionListener(this);
        registerButton.setBounds(210, 200, 100, 50);
        registerButton.addActionListener(this);
        
        frame.add(user);
        frame.add(password);
        frame.add(titulo);
        frame.add(message);
        frame.add(userField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(registerButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String s1 = userField.getText();
            String s2 = String.valueOf(passwordField.getPassword());
            if (s1.length() >= 5 && s2.length() >= 5) {
                if (lf.containsKey(s1)) {
                    message.setForeground(Color.blue);
                    message.setText("Já existe!");
                } else {
                    lf.put(s1, s2);
                    autenticacao.getlogininfo().put(s1, s2);
                    autenticacao.salvarUsuarios();
                    message.setForeground(Color.blue);
                    message.setText("Cadastrado!");
                    userField.setText("");
                    passwordField.setText("");
                }
            } else {
                message.setForeground(Color.red);
                message.setText("Cadastro Inválido!");
            }
        }
        if (e.getSource() == loginButton) {
            String s1 = userField.getText();
            String s2 = String.valueOf(passwordField.getPassword());
            if (lf.containsKey(s1)) {
                if (lf.get(s1).equals(s2)) {
                    message.setForeground(Color.green);
                    message.setText("Entrando...");
                    PaginaMngmt pagina = new PaginaMngmt(s1);
                    frame.dispose();
                } else {
                    message.setForeground(Color.red);
                    message.setText("Login Inválido!");
                }
            } else {
                message.setForeground(Color.red);
                message.setText("Login Inválido!");
            }
        }
    }
}