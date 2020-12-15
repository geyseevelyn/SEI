package br.edu.ufersa.sei.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.edu.ufersa.sei.exception.InsertException;
import br.edu.ufersa.sei.exception.NotFoundException;
import br.edu.ufersa.sei.model.BO.DisciplinaBO;
import br.edu.ufersa.sei.model.BO.NotaBO;
import br.edu.ufersa.sei.model.DAO.BoletimDAO;
import br.edu.ufersa.sei.model.VO.AlunoVO;
import br.edu.ufersa.sei.model.VO.BoletimVO;
import br.edu.ufersa.sei.model.VO.DisciplinaVO;
import br.edu.ufersa.sei.model.VO.NotaVO;
import br.edu.ufersa.sei.view.Telas;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class BoletimController implements Initializable {
	
	@FXML private TableView<BoletimVO> tvNotas;
	@FXML private TableColumn<BoletimVO, String> colDisc;
	@FXML private TableColumn<BoletimVO, Double> colN1;
	@FXML private TableColumn<BoletimVO, Double> colN2;
	@FXML private TableColumn<BoletimVO, Double> colN3;
	@FXML private TableColumn<BoletimVO, Double> colMedia;
	@FXML private TableColumn<BoletimVO, Double> colFaltas;
	@FXML private TableColumn<BoletimVO, Double> colSituacao;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarBoletim();
	}
	
	public void carregarBoletim() {
		List<BoletimVO> boletim = new ArrayList<>();
		 
		 colN1.setCellValueFactory(new PropertyValueFactory<>("n1"));
		 colN2.setCellValueFactory(new PropertyValueFactory<>("n2"));
		 colN3.setCellValueFactory(new PropertyValueFactory<>("n3"));
		 colMedia.setCellValueFactory(new PropertyValueFactory<>("media"));
		 colMedia.setCellFactory(tc -> new TableCell<BoletimVO,Double>() {
			    @Override
			    protected void updateItem(Double media, boolean empty) {
			        super.updateItem(media, empty) ;
			        if (empty) {
			            setText(null);
			        } else {
			            setText(String.format("%.1f", media.doubleValue()).replace(",", "."));
			        }
			    }
			});
		 colFaltas.setCellValueFactory(new PropertyValueFactory<>("faltas"));
		 colDisc.setCellValueFactory(new Callback<CellDataFeatures<BoletimVO, String>, ObservableValue<String>>() {
    		 public ObservableValue<String> call(TableColumn.CellDataFeatures<BoletimVO , String> a) {
    			 return new SimpleObjectProperty<String>("" + a.getValue().getDisc().getNome());
    	     }
    	});
		 
		 colSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));
		 try {
			 boletim = listarNotasAluno(Telas.getUserAlu());
		 } catch (InsertException e) {
			 e.printStackTrace();
		 }  	
		 tvNotas.setItems(FXCollections.observableArrayList(boletim));
	}
	
	public List<BoletimVO> listarNotasAluno(AlunoVO alu) throws InsertException {
		List<BoletimVO> boletim = new ArrayList<BoletimVO>();
		BoletimDAO bDAO = new BoletimDAO();
		ResultSet bRS = null;
		
			
		try {
		      bRS = bDAO.listarNotasAluno(alu);
		      AlunoVO avo = new AlunoVO();
		      DisciplinaVO dvo = new DisciplinaVO();
		      DisciplinaBO dbo = new DisciplinaBO();
		      try {
				dbo.buscarPorId(dvo);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		      
		        	
		         while(bRS.next()) {
		        	 BoletimVO vo = new BoletimVO();
					 
		        	 vo.setN1(bRS.getDouble("n1"));
		        	 vo.setN2(bRS.getDouble("n2"));
		        	 vo.setN3(bRS.getDouble("n3"));
		        	 vo.calcularMedia(bRS.getDouble("n1"), bRS.getDouble("n2"), bRS.getDouble("n3"));
		        	 vo.setFaltas(bRS.getInt("faltas"));
		        	 vo.setSituacao(bRS.getString("situacao"));
		        	 avo.setIdAluno(bRS.getLong("idaluno"));
		        	 dvo.setIdDisc(bRS.getLong("iddisc"));
		        	 try {
		 				dvo = dbo.buscarPorId(dvo);
		 			} catch (NotFoundException e) {
		 				e.printStackTrace();
		 			}
		        	 vo.setAluno(avo);
		        	 vo.setDisc(dvo);
		        	 

		        	 boletim.add(vo);
		        }
			} catch (SQLException e) {
					e.printStackTrace();
			}
		    return boletim;
	}
	
	public void gerarBoletim() {
		gerarPDF();
	}
	
public void gerarPDF() {
		List<BoletimVO> boletimList = new ArrayList<BoletimVO>();
		Document doc = new Document();
		String arquivoPdf = "boletim.pdf";  //nome como vai ser salvo
		
		try {
			boletimList = listarNotasAluno(Telas.getUserAlu());
			
			try {
				PdfWriter.getInstance(doc, new FileOutputStream(arquivoPdf));
				doc.open();

				doc.setPageSize(PageSize.A4);
				
				Image imagem = Image.getInstance("C:\\Users\\Alex\\Desktop\\Logão.png");
				imagem.scaleToFit(120, 120);
				imagem.setAbsolutePosition(80, 750);
				doc.add(imagem);
				
				
				doc.add(new Paragraph("\n\n")); //pular linha
				Paragraph title = new Paragraph(new Phrase("BOLETIM", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14f)));
				title.setAlignment(1);
				doc.add(title);
				doc.add(new Paragraph(" ")); //pular linha

				PdfPTable table = new PdfPTable(2);
				addTableHeader2(table);
				doc.add(table);
				doc.add(new Paragraph(" ")); //pular linha

				PdfPTable tabela = new PdfPTable(7);  //número de colunas da tabela
				tabela.setWidths(new int[]{200,100,100,100,100,100,200});
				addTableHeader(tabela);

				for(BoletimVO bvo : boletimList) {

					PdfPCell cell = new PdfPCell(new Paragraph(bvo.getDisc().getNome() + ""));
					PdfPCell cell2 = new PdfPCell(new Paragraph(bvo.getN1() + ""));
					PdfPCell cell3 = new PdfPCell(new Paragraph(bvo.getN2() + ""));
					PdfPCell cell4 = new PdfPCell(new Paragraph(bvo.getN3()+ ""));
					DecimalFormat formato = new DecimalFormat("#.#");
					PdfPCell cell5 = new PdfPCell(new Paragraph(formato.format(bvo.getMedia()).replace(",", ".")));
					PdfPCell cell6 = new PdfPCell(new Paragraph(bvo.getFaltas() + ""));
					PdfPCell cell7 = new PdfPCell(new Paragraph(bvo.getSituacao() + ""));
					
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					tabela.addCell(cell);
					tabela.addCell(cell2);
					tabela.addCell(cell3);
					tabela.addCell(cell4);
					tabela.addCell(cell5);
					tabela.addCell(cell6);
					tabela.addCell(cell7);					
					
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
		Stream.of("Disiciplina", "N1", "N2", "N3", "Média", "Faltas", "Situação")
		.forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setPhrase(new Phrase(columnTitle));
			header.setHorizontalAlignment(1);
			table.addCell(header);
		});
	}
	
		private static void addTableHeader2(PdfPTable table) {
			AlunoVO avo = Telas.getUserAlu();
			Stream.of("Nome: " + avo.getNome(), "Matrícula: " + avo.getMatricula())
			.forEach(columnTitle -> {
				PdfPCell header = new PdfPCell();
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setPhrase(new Phrase(columnTitle));
				header.setIndent(1);
				//header.setColspan(2);
				//header.setHorizontalAlignment(1);
				table.addCell(header);
			});
	}
	
	public void goToDisciplinas(ActionEvent event) throws Exception {
		Telas.telaDisciplinasAluno(); 
	}
		
	public void goToNotas(ActionEvent event) throws Exception {
		Telas.telaNotasAluno();
	}
	    
	public void voltar() throws Exception {
		Telas.telaPrincipalAluno();
	}
	    
	public void sair() throws Exception {
		Telas.telaLogin();
	}

}
