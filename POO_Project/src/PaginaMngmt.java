import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class PaginaMngmt implements ActionListener {
    private ListaProd lista;
    private String curUser;
    
    private JFrame frame = new JFrame();
    private JButton addBtn = new JButton("Adicionar");
    private JButton removeBtn = new JButton("Remover");
    private JButton atualizarBtn = new JButton("Atualizar");
    private JButton showBtn = new JButton("Mostrar Todos");
    private JButton searchBtn = new JButton("Buscar");
    
    private JLabel titulo = new JLabel("GERENCIAMENTO DE INVENTÁRIO");
    private JLabel idLabel = new JLabel("ID:");
    private JLabel nomeLabel = new JLabel("Nome:");
    private JLabel qtdLabel = new JLabel("Quantidade:");
    private JLabel precoLabel = new JLabel("Preço:");
    private JLabel usuarioLabel = new JLabel();
    private JLabel message = new JLabel();
    
    private JTextField idField = new JTextField();
    private JTextField nomeField = new JTextField();
    private JTextField qtdField = new JTextField();
    private JTextField precoField = new JTextField();
    
    private JTextArea displayArea = new JTextArea();
    private JScrollPane scrollPane;
    
    public PaginaMngmt() {
        this("admin");
    }
    
    public PaginaMngmt(String usuario) {
        this.curUser = usuario;
        this.lista = GerenciadorDados.carregarInventario(usuario);
        
        titulo.setBounds(30, 10, 440, 30);
        titulo.setFont(new Font(null, Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        usuarioLabel.setBounds(30, 45, 440, 20);
        usuarioLabel.setText("Usuário: " + usuario);
        usuarioLabel.setFont(new Font(null, Font.ITALIC, 12));
        usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usuarioLabel.setForeground(new Color(100, 100, 100));
        idLabel.setBounds(30, 75, 80, 25);
        nomeLabel.setBounds(30, 110, 80, 25);
        qtdLabel.setBounds(30, 145, 80, 25);
        precoLabel.setBounds(30, 180, 80, 25);
        
        idField.setBounds(120, 75, 200, 25);
        nomeField.setBounds(120, 110, 200, 25);
        qtdField.setBounds(120, 145, 200, 25);
        precoField.setBounds(120, 180, 200, 25);
        
        addBtn.setBounds(30, 225, 120, 35);
        addBtn.addActionListener(this);
        removeBtn.setBounds(160, 225, 120, 35);
        removeBtn.addActionListener(this);
        atualizarBtn.setBounds(290, 225, 120, 35);
        atualizarBtn.addActionListener(this);
        searchBtn.setBounds(420, 225, 100, 35);
        searchBtn.addActionListener(this);
        showBtn.setBounds(30, 270, 490, 35);
        showBtn.addActionListener(this);
        
        message.setBounds(30, 315, 490, 25);
        message.setFont(new Font(null, Font.PLAIN, 14));
        message.setHorizontalAlignment(SwingConstants.CENTER);
        
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(30, 350, 490, 140);
        
        frame.add(titulo);
        frame.add(usuarioLabel);
        frame.add(idLabel);
        frame.add(nomeLabel);
        frame.add(qtdLabel);
        frame.add(precoLabel);
        frame.add(idField);
        frame.add(nomeField);
        frame.add(qtdField);
        frame.add(precoField);
        frame.add(addBtn);
        frame.add(removeBtn);
        frame.add(atualizarBtn);
        frame.add(searchBtn);
        frame.add(showBtn);
        frame.add(message);
        frame.add(scrollPane);
        frame.setTitle("Sistema de Inventário - " + usuario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(570, 560);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salvarDados();
            }
        });
        
        frame.setVisible(true);
        
        if (!lista.isEmpty()) {
            mostrarTodos();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            adicionarProduto();
        } else if (e.getSource() == removeBtn) {
            removerProduto();
        } else if (e.getSource() == atualizarBtn) {
            atualizarProduto();
        } else if (e.getSource() == searchBtn) {
            buscarProduto();
        } else if (e.getSource() == showBtn) {
            mostrarTodos();
        }
    }
    
    private void adicionarProduto() {
        try {
            String id = idField.getText().trim();
            String nome = nomeField.getText().trim();
            int qtd = Integer.parseInt(qtdField.getText().trim());
            float preco = Float.parseFloat(precoField.getText().trim());
            
            if (id.isEmpty() || nome.isEmpty()) {
                mostrarMensagem("ID e Nome são obrigatórios!", Color.RED);
                return;
            }
            
            if (qtd < 0 || preco < 0) {
                mostrarMensagem("Quantidade e Preço devem ser positivos!", Color.RED);
                return;
            }
            
            Produto produto = Produto.newProduto(nome, id, qtd, preco);
            
            if (lista.adicionar(produto)) {
                salvarDados();
                mostrarMensagem("Produto adicionado com sucesso!", Color.GREEN);
                limparCampos();
            } else {
                mostrarMensagem("Produto com este ID já existe!", Color.RED);
            }
        } catch (NumberFormatException ex) {
            mostrarMensagem("Quantidade e Preço devem ser números válidos!", Color.RED);
        }
    }
    
    private void removerProduto() {
        String id = idField.getText().trim();
        
        if (id.isEmpty()) {
            mostrarMensagem("Digite o ID do produto a remover!", Color.RED);
            return;
        }
        
        if (lista.removerProduto(id)) {
            salvarDados();
            mostrarMensagem("Produto removido com sucesso!", Color.GREEN);
            limparCampos();
            displayArea.setText("");
        } else {
            mostrarMensagem("Produto não encontrado!", Color.RED);
        }
    }
    
    private void atualizarProduto() {
        try {
            String id = idField.getText().trim();
            String nome = nomeField.getText().trim();
            int qtd = Integer.parseInt(qtdField.getText().trim());
            float preco = Float.parseFloat(precoField.getText().trim());
            
            if (id.isEmpty() || nome.isEmpty()) {
                mostrarMensagem("ID e Nome são obrigatórios!", Color.RED);
                return;
            }
            
            if (qtd < 0 || preco < 0) {
                mostrarMensagem("Quantidade e Preço devem ser positivos!", Color.RED);
                return;
            }
            
            if (lista.atualizarProduto(id, nome, qtd, preco)) {
                salvarDados();
                mostrarMensagem("Produto atualizado com sucesso!", Color.GREEN);
                limparCampos();
            } else {
                mostrarMensagem("Produto não encontrado!", Color.RED);
            }
        } catch (NumberFormatException ex) {
            mostrarMensagem("Quantidade e Preço devem ser números válidos!", Color.RED);
        }
    }
    
    private void buscarProduto() {
        String id = idField.getText().trim();
        
        if (id.isEmpty()) {
            mostrarMensagem("Digite o ID do produto a buscar!", Color.RED);
            return;
        }
        
        Produto produto = lista.buscarProduto(id);
        
        if (produto != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("===========================================\n");
            sb.append(String.format("ID: %s\n", produto.getId()));
            sb.append(String.format("Nome: %s\n", produto.getNome()));
            sb.append(String.format("Quantidade: %d\n", produto.getQtd()));
            sb.append(String.format("Preco: R$ %.2f\n", produto.getPreco()));
            sb.append("===========================================");
            
            displayArea.setText(sb.toString());
            mostrarMensagem("Produto encontrado!", Color.GREEN);
        } else {
            displayArea.setText("");
            mostrarMensagem("Produto não encontrado!", Color.RED);
        }
    }
    
    private void mostrarTodos() {
        if (lista.isEmpty()) {
            displayArea.setText("Nenhum produto cadastrado.");
            mostrarMensagem("Inventário vazio!", Color.ORANGE);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("================ INVENTARIO COMPLETO ================\n\n");
        
        for (Produto p : lista.getTodosProdutos()) {
            sb.append(String.format("ID: %-10s | Nome: %-20s\n", p.getId(), p.getNome()));
            sb.append(String.format("Qtd: %-10d | Preco: R$ %.2f\n", p.getQtd(), p.getPreco()));
            sb.append("-----------------------------------------------------\n");
        }
        
        sb.append(String.format("\nTotal de produtos: %d", lista.getTamanho()));
        
        displayArea.setText(sb.toString());
        displayArea.setCaretPosition(0);
        mostrarMensagem("Exibindo todos os produtos!", Color.BLUE);
    }
    
    private void salvarDados() {
        GerenciadorDados.salvarInventario(curUser, lista);
    }
    
    private void mostrarMensagem(String texto, Color cor) {
        message.setText(texto);
        message.setForeground(cor);
    }
    
    private void limparCampos() {
        idField.setText("");
        nomeField.setText("");
        qtdField.setText("");
        precoField.setText("");
    }
}