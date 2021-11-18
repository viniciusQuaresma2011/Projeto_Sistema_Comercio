package com.springboot.application.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.springboot.application.repository.EstoqueRepository;

@Service
public class EstoquePdfGerar {
	
	private static final String PDF_RESOURCES = "src/main/resources/templates/";
    private EstoqueRepository estoqueRepository;
    private SpringTemplateEngine templateEngine;

    @Autowired
    public EstoquePdfGerar(EstoqueRepository estoqueRepository, SpringTemplateEngine templateEngine) {
        this.estoqueRepository = estoqueRepository;
        this.templateEngine = templateEngine;
    }

    public File generatePdf() throws IOException, DocumentException {
        Context context = getContext();
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }


    private File renderPdf(String html) throws IOException, DocumentException {
        File file = File.createTempFile("estoque", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContext() {
        Context context = new Context();
        context.setVariable("listaEstoque", estoqueRepository.findAll());
        return context;
    }

    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("pdf_estoque", context);
    }
	
	
}
