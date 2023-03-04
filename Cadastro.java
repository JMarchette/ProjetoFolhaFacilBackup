import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cadastro
{

    public class Frame extends JFrame {

        Color azulFundo = new Color(227, 235, 238);
        Color botao = new Color(94, 119, 255);

        JTextField nomeField = new JTextField ("Nome",20);      
        JTextField cpfField = new JTextField ("CPF",20);
        JTextField rgField = new JTextField ("RG",10);
        JTextField nascField = new JTextField ("Data de Nascimento __/__/__ ",20);
    
        JComboBox<String> generoCombo = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outros"});
        JTextField telefoneField = new JTextField ("Telefone",10);
        JTextField emailField = new JTextField ("Email",20);

        JTextField logradouroField = new JTextField ("Logradouro",20);
        JTextField numdacasaField = new JTextField ("Nº",5);
        JTextField complementoField = new JTextField ("Complemento",10);
        JTextField bairroField = new JTextField ("Bairro",20);
        JTextField cepField = new JTextField ("CEP",10);
        JTextField estadoField = new JTextField ("Estado",20);
        JTextField paisField = new JTextField ("Pais",10);
        JTextField ufField = new JTextField ("UF",5);


        JTextField agenciaField = new JTextField ("Agencia",20);
        JTextField contaField = new JTextField ("Conta",10);
        JComboBox<String> tipoCombo = new JComboBox<String>(new String[]{"Corrente", "Poupança"});
        JTextField salarioField = new JTextField ("Salario",10);

        JTextField cargoField = new JTextField ("Cargo",20);
        JCheckBox cargoConfiancaBox = new JCheckBox ("Cargo de Confiança");

        JTextField dtinicioField = new JTextField ("Data de Inicio __/__/__",20);
        JTextField dtpagField = new JTextField ("Data de Pagamento __/__/__",20);

        JCheckBox conveniomBox = new JCheckBox ("Médico");
        JCheckBox conveniooBox = new JCheckBox ("Odontologico");
        JButton confirmarButton = new JButton("Confirmar");
        JButton cancelarButton = new JButton("Cancelar");
        JButton voltarButton = new JButton("Voltar");
        Banco bd = new Banco();

    
        

        public Frame(){
            JFrame jFrame = new JFrame("Cadastro");
            jFrame.setLayout(new FlowLayout());
            jFrame.setSize(1086, 680);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.getContentPane().setBackground(azulFundo);

            voltarButton.setBackground(botao);
            voltarButton.setFont(Font.getFont(Font.SANS_SERIF));
            voltarButton.setForeground(Color.WHITE);
            voltarButton.setSize(500, 400);


            ActionListener FecharCancelar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    janelaInicial ji = new janelaInicial();
                    ji.createAndShowGUI();
                    dispose();
                }
            };

            voltarButton.addActionListener(FecharCancelar);
            cancelarButton.addActionListener(FecharCancelar);
    
            
            nomeField.setPreferredSize(new Dimension(200, 30));
            cpfField.setPreferredSize(new Dimension(200, 30));
            rgField.setPreferredSize(new Dimension(200, 30));
            nascField.setPreferredSize(new Dimension(200, 30));
            generoCombo.setPreferredSize(new Dimension(200, 30));
            telefoneField.setPreferredSize(new Dimension(200, 30));
            emailField.setPreferredSize(new Dimension(200, 30));

            logradouroField.setPreferredSize(new Dimension(200, 30));
            numdacasaField.setPreferredSize(new Dimension(200, 30));
            complementoField.setPreferredSize(new Dimension(200, 30));
            bairroField.setPreferredSize(new Dimension(200, 30));
            cepField.setPreferredSize(new Dimension(200, 30));
            estadoField.setPreferredSize(new Dimension(200, 30));
            ufField.setPreferredSize(new Dimension(200, 30));
            paisField.setPreferredSize(new Dimension(200, 30));

            agenciaField.setPreferredSize(new Dimension(200, 30));
            tipoCombo.setPreferredSize(new Dimension(200, 30));
            contaField.setPreferredSize(new Dimension(200, 30));
            salarioField.setPreferredSize(new Dimension(200, 30));
            cargoField.setPreferredSize(new Dimension(200, 30));
            dtinicioField.setPreferredSize(new Dimension(200, 30));
            dtpagField.setPreferredSize(new Dimension(200, 30));

            confirmarButton.setBackground(botao);
            confirmarButton.setFont(Font.getFont(Font.SANS_SERIF));
            confirmarButton.setForeground(Color.WHITE);
            confirmarButton.setSize(500, 400);

            cancelarButton.setBackground(botao);
            cancelarButton.setFont(Font.getFont(Font.SANS_SERIF));
            cancelarButton.setForeground(Color.WHITE);
            cancelarButton.setSize(500, 400);

            JTextArea vazio = new JTextArea("  ");
            vazio.setForeground(Color.black);
            vazio.setPreferredSize(new Dimension(1086, 20));
            vazio.setEditable(false);
            vazio.setLineWrap(true);
            vazio.setWrapStyleWord(true);
            vazio.setBackground(Color.white);
            vazio.setFont(new Font("Courier", Font.ITALIC,20));
            vazio.setSelectionColor(Color.lightGray);
            vazio.setSelectedTextColor(Color.darkGray);


            String tdados = "DADOS CADASTRAIS";
            JTextArea tdadosexibir = new JTextArea(tdados);
            tdadosexibir.setForeground(botao);
            tdadosexibir.setPreferredSize(new Dimension(1086, 50));
            tdadosexibir.setEditable(false);
            tdadosexibir.setLineWrap(true);
            tdadosexibir.setWrapStyleWord(true);
            tdadosexibir.setBackground(azulFundo);
            tdadosexibir.setFont(new Font("Courier", Font.ITALIC,20));
            tdadosexibir.setSelectionColor(Color.lightGray);
            tdadosexibir.setSelectedTextColor(Color.darkGray);

            Container dadoscadastrais = this.getContentPane();
            dadoscadastrais.setLayout(new FlowLayout(FlowLayout.LEFT));
            dadoscadastrais.add(vazio);
            dadoscadastrais.add(tdadosexibir);
            dadoscadastrais.add(nomeField);
            dadoscadastrais.add(cpfField); 
            dadoscadastrais.add(rgField);
            dadoscadastrais.add(nascField);
            dadoscadastrais.add(generoCombo);
            dadoscadastrais.add(telefoneField);
            dadoscadastrais.add(emailField);

            String cc = "Convênio:";
            JTextArea ccc = new JTextArea(cc);
            ccc.setForeground(Color.black);
            ccc.setBackground(Color.white);
            ccc.setFont(new Font("Courier", Font.ITALIC,13));
            ccc.setEditable(false);
            setPreferredSize(new Dimension(12, 12));

            Container checkboxx =this.getContentPane();
            checkboxx.setBackground(Color.white);
            checkboxx.add(ccc);
            checkboxx.add(conveniomBox); 
            checkboxx.add(conveniooBox);

            String tendereco = "ENDEREÇO";
            JTextArea tenderecoexibir = new JTextArea(tendereco);
            tenderecoexibir.setForeground(botao);
            tenderecoexibir.setPreferredSize(new Dimension(1086, 50));
            tenderecoexibir.setEditable(false);
            tenderecoexibir.setLineWrap(true);
            tenderecoexibir.setWrapStyleWord(true);
            tenderecoexibir.setBackground(azulFundo);
            tenderecoexibir.setFont(new Font("Courier", Font.ITALIC,20));
            tenderecoexibir.setSelectionColor(Color.lightGray);
            tenderecoexibir.setSelectedTextColor(Color.darkGray);

            Container enderecos = this.getContentPane();
            enderecos.add(tenderecoexibir);
            enderecos.add(logradouroField);
            enderecos.add(numdacasaField);
            enderecos.add(complementoField);
            enderecos.add(bairroField);
            enderecos.add(cepField); 
            enderecos.add(estadoField);
            enderecos.add(ufField);
            enderecos.add(paisField);

            String tbanco = "DADOS BANCÁRIOS";

            JTextArea tbancoexibir = new JTextArea(tbanco);
            tbancoexibir.setForeground(botao);
            tbancoexibir.setPreferredSize(new Dimension(1086, 50));
            tbancoexibir.setEditable(false);
            tbancoexibir.setLineWrap(true);
            tbancoexibir.setWrapStyleWord(true);
            tbancoexibir.setBackground(azulFundo);
            tbancoexibir.setFont(new Font("Courier", Font.ITALIC,20));
            tbancoexibir.setSelectionColor(Color.lightGray);
            tbancoexibir.setSelectedTextColor(Color.darkGray);

            Container dadosbanco = this.getContentPane();
            dadosbanco.add(tbancoexibir);
            dadosbanco.add(agenciaField);
            dadosbanco.add(contaField);
            dadosbanco.add(tipoCombo);
            dadosbanco.add(salarioField);
            dadosbanco.add(cargoField);
            checkboxx.add(cargoConfiancaBox);
            dadosbanco.add(dtinicioField);
            dadosbanco.add(dtpagField);

            JTextArea vvv = new JTextArea("  ");
            vvv.setForeground(Color.black);
            vvv.setPreferredSize(new Dimension(400, 400));
            vvv.setEditable(false);
            vvv.setLineWrap(true);
            vvv.setWrapStyleWord(true);
            vvv.setBackground(Color.white);

            Container botoes = this.getContentPane();
            botoes.add(vazio);
            botoes.add(vvv);
            botoes.add(voltarButton);
            botoes.add(confirmarButton);
            botoes.add(cancelarButton);

            nomeField.addFocusListener(new Eventos("Nome", Color.GRAY));
            cpfField.addFocusListener(new Eventos("CPF", Color.GRAY));
            rgField.addFocusListener(new Eventos("RG", Color.GRAY));
            nascField.addFocusListener(new Eventos("Data de Nascimento __/__/__ ", Color.GRAY));
            telefoneField.addFocusListener(new Eventos("Telefone", Color.GRAY));
            emailField.addFocusListener(new Eventos("Email", Color.GRAY));    

            logradouroField.addFocusListener(new Eventos("Logradouro", Color.GRAY));
            numdacasaField.addFocusListener(new Eventos("Nº", Color.GRAY));
            bairroField.addFocusListener(new Eventos("Bairro", Color.GRAY));
            complementoField.addFocusListener(new Eventos("Complemento", Color.GRAY));

            agenciaField.addFocusListener(new Eventos("Agencia", Color.GRAY));
            contaField.addFocusListener(new Eventos("Conta", Color.GRAY));
            salarioField.addFocusListener(new Eventos("Salario", Color.GRAY));
            cargoField.addFocusListener(new Eventos("Cargo", Color.GRAY));

            
            dtinicioField.addFocusListener(new Eventos("Data de Inicio __/__/__", Color.GRAY));
            dtpagField.addFocusListener(new Eventos("Data de Pagamento __/__/__", Color.GRAY));
            estadoField.addFocusListener(new Eventos("Estado", Color.GRAY));
            paisField.addFocusListener(new Eventos("Pais", Color.GRAY));
            ufField.addFocusListener(new Eventos("UF", Color.GRAY));
            cepField.addFocusListener(new Eventos("CEP", Color.GRAY));
            

            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setSize(1086,700);
            this.setVisible(true);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setTitle("Cadastro de Funcionário");

        
            confirmarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                String nomeValor = nomeField.getText();
                String cpfValor = cpfField.getText();
                String rgValor = rgField.getText();
                String nascimentoValor = nascField.getText();
                String generoValor = generoCombo.getSelectedItem().toString();
                String telefoneValor = telefoneField.getText();
                String emailValor = emailField.getText();
                String logradouroValor = logradouroField.getText();
                String numCasaValor = numdacasaField.getText();
                String complementoValor = complementoField.getText();
                String bairroValor = bairroField.getText();
                String cepValor = cepField.getText();
                String estadoValor = estadoField.getText();
                String paisValor = paisField.getText();
                String ufValor = ufField.getText();
                String agenciaValor = agenciaField.getText();
                String contaValor = contaField.getText();
                String salarioValor = salarioField.getText();
                String cargoValor = cargoField.getText();
                String dataInicioValor = dtinicioField.getText();
                String dataPagamentoValor = dtpagField.getText();

        
                String convenio1Valor = "nenhum";
                String convenio2Valor = "nenhum";
                String confiancaValor = "não";
        
                if (conveniomBox.isSelected()) {
                    convenio1Valor = "Médico";
                }
                if (conveniooBox.isSelected()) {
                    convenio2Valor = "Odontológico";
                }

                if (cargoConfiancaBox.isSelected()) {
                    confiancaValor = "sim";
                }
                bd.inicializarConexao();
                bd.adicionarDados(nomeValor, generoValor, rgValor, cpfValor, nascimentoValor, telefoneValor, emailValor, convenio1Valor, convenio2Valor, logradouroValor, numCasaValor, complementoValor, estadoValor, bairroValor, cepValor, ufValor, agenciaValor, contaValor, salarioValor, cargoValor, dataInicioValor, dataPagamentoValor, paisValor, confiancaValor, "pendente");            
                bd.fecharConexao();        
                }
            });
        }
    };
}

