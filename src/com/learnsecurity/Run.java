package com.learnsecurity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class Run {

	public static void main(String argv[]) {

		// read key
		byte keyBytes[] = new byte[AESEncrypter.KEY_SIZE];
		String keyFile = JOptionPane.showInputDialog("Digite o nome do arquivo que contém a chave:");
		// Criando o stream do arquivo da chave com o nome que foi digitado.
		try {
			FileInputStream fis = new FileInputStream(keyFile);
			fis.read(keyBytes);
			SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
			AESEncrypter aes = new AESEncrypter(keySpec);

			while (true) {

				int operation = Integer.parseInt(JOptionPane.showInputDialog(menu()));

				switch (operation) {
				case 1: // Gerar uma nova chave
					String keyFileName = JOptionPane.showInputDialog("Digite o nome para o arquivo da chave");
					FileOutputStream fos = new FileOutputStream(keyFileName);
					KeyGenerator kg = KeyGenerator.getInstance("AES");
					kg.init(AESEncrypter.KEY_SIZE * 8);
					SecretKey skey = kg.generateKey();
					/* write key */
					fos.write(skey.getEncoded());
					fos.close();
					JOptionPane.showMessageDialog(null,
							"Chave criada com sucesso!\n Execute novamente para escolher a nva chave\n");
					break;
				case 2: // criptografar um arquivo txt

					// lendo o nome do arquivo que será criptografado
					String nomeArquivoTexto = JOptionPane
							.showInputDialog("Digite o nome do arquivo com texto que deseja criptografar:");

					// criando o stream do arquivo de entrada com o nome que foi digitado.
					FileInputStream plainText = new FileInputStream(nomeArquivoTexto);

					// criando o arquivo de saida com o texto criptografado
					FileOutputStream encriptado = new FileOutputStream("textoEncriptado.txt");

					// criptografando o texto, passando o arquivo de entrada e saida.
					aes.encrypt(plainText, encriptado);
					JOptionPane.showMessageDialog(null,
							"Arquivo criptografado com sucesso ! Verifique o arquivo 'textoEncriptado.txt'\n");
					break;
				case 3:// descriptografar um arquivo txt

					// lendo o nome do arquivo que será desccriptografado
					String nomeArquivo = JOptionPane
							.showInputDialog("Digite o nome do arquivo com texto que deseja descriptografar:");

					// criando o stream do arquivo de entrada com o nome que foi digitado.
					FileInputStream encriptadoIn = new FileInputStream(nomeArquivo);

					// criando o arquivo de saida com o texto criptografado
					FileOutputStream decriptado = new FileOutputStream("textoDecriptado.txt");
					aes.decrypt(encriptadoIn, decriptado);
					JOptionPane.showMessageDialog(null,
							"Arquivo descriptografado com sucesso ! Verifique o arquivo 'textoDecriptado.txt'\n");
					break;
				case 4:
					System.exit(0);
					fis.close();
					break;
				default:
					JOptionPane.showMessageDialog(null, "Escolha um valor válido");
					break;
				}
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado, verifique o nome ou crie um novo");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Escolha um valor válido");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String menu() {
		String menu = "\n-------------MENU--------------\n" + "1 - Criar uma nova chave\n"
				+ "2 - Encriptar um arquivo txt\n" + "3 - Decriptar um arquivo txt\n" + "4 - Sair\n"
				+ "Digite a opção:";
		return menu;
	}

}
