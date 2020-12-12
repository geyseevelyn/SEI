package br.edu.ufersa.sei.model.BO;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.model.VO.AlunoVO;

public class TestePDF {
	
	public static void main(String[] args) {
		gerarPDF();
	}

	private static void gerarPDF() {
		
		AlunoBO<AlunoVO> aluBO = new AlunoBO<AlunoVO>();
		List<AlunoVO> alunosList;
		
		Document doc = new Document();
		String arquivoPdf = "alunos.pdf";  //nome como vai ser salvo
		
		try {
			 alunosList = aluBO.listar();
			 
			 try {
				  PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
				  
				  doc.open();
				  
				  doc.setPageSize(PageSize.A4);
			
//				  Image imagem = Image.getInstance("C:\\Users\\Notebook\\Documents\\UFERSA\\POO\\eclipse-workspace\\ProjetoPOO\\src\\br\\edu\\ufersa\\sei\\view\\VE\\logotelas.png");
//				  imagem.scaleToFit(100, 100);
//				  doc.add(imagem);
//				
				  Paragraph title = new Paragraph("Lista de Alunos");
				  title.setAlignment(1);
				  doc.add(title);
				  doc.add(new Paragraph(" ")); //pular linha
				  
				  PdfPTable tabela = new PdfPTable(5);  //número de colunas da tabela
			      addTableHeader(tabela);
				  
				  for(AlunoVO alu : alunosList) {
					  
					  PdfPCell cell = new PdfPCell(new Paragraph(alu.getNome() + ""));
					  PdfPCell cell2 = new PdfPCell(new Paragraph(alu.getCpf() + ""));
					  PdfPCell cell3 = new PdfPCell(new Paragraph(alu.getEmail() + ""));
					  PdfPCell cell4 = new PdfPCell(new Paragraph(alu.getEndereco() + ""));
					  PdfPCell cell5 = new PdfPCell(new Paragraph(alu.getTurma().getIdTurma() + ""));
					
					  tabela.addCell(cell);
					  tabela.addCell(cell2);
					  tabela.addCell(cell3);
					  tabela.addCell(cell4);
					  tabela.addCell(cell5); 
				  }
				  
				  doc.add(tabela);
				  doc.close();
				  
				  Desktop.getDesktop().open(new File(arquivoPdf));  //abrir o documento automaticamente
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		  
		} catch (InsertException e) {
			e.printStackTrace();
		}
	}	

	private static void addTableHeader(PdfPTable table) {
	    Stream.of("Nome", "CPF", "Email", "Endereço", "Turma")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
}