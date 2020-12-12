package br.edu.ufersa.sei.model.BO;
//package br.edu.ufersa.sei.model.BO;
//
//import java.awt.Desktop;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import br.edu.ufersa.sei.exception.InsertException;
//import br.edu.ufersa.sei.model.VO.AlunoVO;
//
//public class TestePDF {
//	
//	public static void main(String[] args) {
//		gerarPDF();
//	}
//
//	private static void gerarPDF() {
//		
//		AlunoBO<AlunoVO> aluBO = new AlunoBO<AlunoVO>();
//		List<AlunoVO> alunosList;
//		
//		Document doc = new Document();
//		String arquivoPdf = "alunos.pdf";  //nome como vai ser salvo
//		
//		try {
//			 alunosList = aluBO.listar();
//			 
//			 try {
//				  PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
//				  doc.open();
//				  
//				  Paragraph title = new Paragraph("Lista de Alunos");
//				  title.setAlignment(1);
//				  doc.add(title);
//				  Paragraph p = new Paragraph(" ");
//				  doc.add(p);
//				  
//				  PdfPTable tabela = new PdfPTable(5);  //número de colunas da tabela
//			        
//				  PdfPCell cell = new PdfPCell(new Paragraph("Nome"));
//				  PdfPCell cell2 = new PdfPCell(new Paragraph("CPF"));
//				  PdfPCell cell3 = new PdfPCell(new Paragraph("Email"));
//				  PdfPCell cell4 = new PdfPCell(new Paragraph("Endereço"));
//				  PdfPCell cell5 = new PdfPCell(new Paragraph("Turma"));
//				
//				  tabela.addCell(cell);
//				  tabela.addCell(cell2);
//				  tabela.addCell(cell3);
//				  tabela.addCell(cell4);
//				  tabela.addCell(cell5);
//				  
//				  for(AlunoVO alu : alunosList) {
//					  
//					  cell = new PdfPCell(new Paragraph(alu.getNome() + ""));
//					  cell2 = new PdfPCell(new Paragraph(alu.getCpf() + ""));
//					  cell3 = new PdfPCell(new Paragraph(alu.getEmail() + ""));
//					  cell4 = new PdfPCell(new Paragraph(alu.getEndereco() + ""));
//					  cell5 = new PdfPCell(new Paragraph(alu.getTurma().getIdTurma() + ""));
//					
//					  tabela.addCell(cell);
//					  tabela.addCell(cell2);
//					  tabela.addCell(cell3);
//					  tabela.addCell(cell4);
//					  tabela.addCell(cell5); 
//				  }
//				  
//				  doc.add(tabela);
//				  doc.close();
//				  
//				  try {
//					   Desktop.getDesktop().open(new File(arquivoPdf));
//				  } catch (IOException e) {
//					e.printStackTrace();
//				  }
//				
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (DocumentException e) {
//				e.printStackTrace();
//			}		 
//			
//		} catch (InsertException e) {
//			e.printStackTrace();
//		}
//	}
//	
//}
