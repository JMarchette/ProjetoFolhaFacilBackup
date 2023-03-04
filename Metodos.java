import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

class Metodos {
    public String calculaImposto(double salario) {
        /*
        Calcula o imposto em base na tabela de imposto de renda.
        Argumentos:
            salario: double
        Retorna:
            imposto: String ou double
            */
        if (salario == 0) {
            return "isento";
        }

        double imposto = 0;

        if (salario < 2_826_65) {
            imposto = (salario * 7.50) / 100;
        } else if (salario < 3_751_05) {
            imposto = (salario * 15.00) / 100;
        } else if (salario < 4_664_68) {
            imposto = (salario * 22.50) / 100;
        } else if (salario > 4_664_68) {
            imposto = (salario * 27.50) / 100;
        }

        salario -= imposto;
        return String.valueOf(imposto);
    }

    public String calculaInss(double salario) {
        /*
        Calcula o INSS em base na tabela de Inss
        Argumentos:
            salario: double
        Retorna:
            inss: String ou double
            */
        if (salario == 0) {
            return "isento";
        }

        double inss = 0;

        if (salario < 1_212_00) {
            inss = (salario * 7.50) / 100;
        } else if (salario < 2_427_35) {
            inss = (salario * 9.00) / 100;
        } else if (salario < 3_641_04) {
            inss = (salario * 12.00) / 100;
        } else if (salario > 3_641_04) {
            inss = (salario * 14_00) / 100;
        }

        salario -= inss;
        return String.valueOf(inss);
    }
    
    public boolean bonusAniversario(double salario, String nasc) {
        /*
        Verifica se o mês recebido é o mesmo que o de aniversário do usuário
        E se for, adiciona 100 ao salario.
        Argumentos:
            salario: double
            data_nascimento: String
        Retorna:
            bool
            */
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM");

        if (today.format(myFormatObj).equals(nasc.substring(3, 5))) {
            double bonus = 100.0;
            salario += bonus;
            return true;
        }
        return false;
    }


    public void gerarArquivo(String nomeArquivo, String conteudo) throws IOException {
        /*
        Gera um arquivo de texto para relatorio.
        Argumentos:
            nomeArquivo: String
            conteudo: String
        */
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
            writer.write(conteudo);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean validarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os caracteres são iguais (Ex: 000.000.000-00)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }

        // Verifica se os dígitos verificadores calculados são iguais aos informados pelo usuário
        return (cpf.charAt(9) - '0' == digito1 && cpf.charAt(10) - '0' == digito2);
    }


    public static String formatarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return cpf;
        }

        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

} 

