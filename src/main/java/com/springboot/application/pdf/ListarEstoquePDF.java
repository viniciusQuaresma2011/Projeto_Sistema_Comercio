package com.springboot.application.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springboot.application.model.Estoque;

///aqui falta implementar
@Component("/cadastro/estoque/listar")
public class ListarEstoquePDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		@SuppressWarnings("unchecked")
		List<Estoque> listaEstoque = (List<Estoque>) model.get("listaEstoque");
		
		//aqui é a quantidade de atributos que precisa ser inserido no PDF
		PdfPTable tabelaEstoque = new PdfPTable(4);
		
		listaEstoque.forEach(estoque -> {
			tabelaEstoque.addCell(estoque.getId().toString(getViewerPreferences()));
			tabelaEstoque.addCell(estoque.getNome());
			tabelaEstoque.addCell(estoque.getTipo());
			tabelaEstoque.addCell(estoque.getQuantidade());
		});
		
		document.add(tabelaEstoque);
		
	}

}
