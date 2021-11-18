package com.springboot.application.controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lowagie.text.DocumentException;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.springboot.application.model.Estoque;
import com.springboot.application.model.Produto;
import com.springboot.application.pdf.EstoquePdfGerar;
import com.springboot.application.repository.EstoqueRepository;
import com.springboot.application.repository.ProdutoRepository;
import com.springboot.application.service.EstoqueService;


@Controller
public class EstoqueController {
	

	
	
	@Autowired
	private EstoqueRepository estoqueRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstoqueService estoqueService;
	
	@Autowired
	private EstoquePdfGerar estoquePdfGerar;

//	@GetMapping("/listarEstoque")
//	public String retornaOEstoqueNoGrafico() {
//		List<Estoque> estoque = estoqueRepository.findAll();
//		String nome = "Joao";
//		Integer idade = 30;
//
//		JsonObject json = Json.createObjectBuilder()
//		                        .add("nome", nome)
//		                        .add("idade", idade)
//		                        .build();
//
//		String jsonString = json.toString();
//	 }

	@GetMapping("/cadastro/estoque")
	public ModelAndView retornaEstoque(Estoque estoque) {

		ModelAndView mv = new ModelAndView("cadastro/cadastro_estoque");
		mv.addObject("estoques", estoque);

		List<String> tipoDeEstoque = Arrays.asList("Selecione..", "Camara Fria", "Paletes", "Prateleiras", "Balcao",
				"Area Ventilada");
		mv.addObject("tipoEstoque", tipoDeEstoque);

		return mv;
	}

	@GetMapping("/cadastro/estoque/listar")
	public ModelAndView listarEstoque() {
		ModelAndView mv = new ModelAndView("lista/listar_estoque");
		mv.addObject("listaEstoque", estoqueRepository.findAll());

		return mv;
	}

	@GetMapping("/cadastro/estoque/editar/{id}")
	public ModelAndView editarEstoque(@PathVariable("id") Long id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);
		return retornaEstoque(estoque.get());
	}

	@GetMapping("/cadastro/estoque/remover/{id}")
	public ModelAndView removerEstoque(@PathVariable("id") Long id) {
		Optional<Estoque> estoque = estoqueRepository.findById(id);

		estoqueRepository.delete(estoque.get());

		return listarEstoque();

	}

	@PostMapping("/cadastro/estoque/salvar")
	public ModelAndView salvarEstoque(@Valid Estoque estoque, BindingResult result) {
		if (result.hasErrors()) {
			return retornaEstoque(estoque);
		}

		estoqueRepository.saveAndFlush(estoque);

		return retornaEstoque(new Estoque());

	}

	@RequestMapping(value = "/estoque/status", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String retornaGrafico() {
		List<Estoque> listaEstoque = estoqueRepository.findAll();
		List<Produto> listaProduto = produtoRepository.findAll();

		ArrayList doisObjetos = new ArrayList();
		doisObjetos.add(listaEstoque);
		doisObjetos.add(listaProduto);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//System.out.println(gson.toJson(doisObjetos));

		return gson.toJson(doisObjetos);
	}

	@PostMapping("**/buscarPorNomeEstoque") // aqui faz a busca pelo nome
	public ModelAndView buscarPorNomeEstoque(@RequestParam("nome") String nome) {
		ModelAndView mv = new ModelAndView("listar_produto");
		mv.addObject("listaEstoque", estoqueRepository.buscarPorNome(nome));
		mv.addObject("estoqueObjeto", new Estoque());
		return mv;
	}
	
//	@GetMapping(value = "/estoque/gerarCsv", produces = "text/csv")
//	public void retornaEstoquesParaCsv(HttpServletResponse servletResponse) throws IOException{
//		servletResponse.setContentType("text/csv");
//		servletResponse.addHeader("Content-Disposition","attachment; filename=\"employees.csv\"");
//		exportarCsv.writeEstoqueToCsv(servletResponse.getWriter());
//	}
	
	//aqui gera arquivo csv
	@GetMapping("/estoque/exportarCsv")
    public void exportCSV(HttpServletResponse response) throws Exception {

        // set file name and content type
        String filename = "estoque.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, 
                   "attachment; filename=\"" + filename + "\"");

        // create a csv writer
        StatefulBeanToCsv<Estoque> writer = new StatefulBeanToCsvBuilder
                    <Estoque>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).
                        withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false).build();

        // write all employees to csv file
        writer.write(estoqueRepository.findAll());

    }
	
	
//	
//	@GetMapping("/estoque/exportarPDF")
//	public void exportar_PDF(List<Estoque> listaEstoque, HttpServletResponse response) {
//		
//	}
	
	
	@GetMapping("/listar")
	public ModelAndView listaEstoque() {
		ModelAndView mv = new ModelAndView("pdf_estoqueListar");
		mv.addObject("listaEstoque", estoqueRepository.findAll());

		return mv;
	}
	
	
	
	
	 @GetMapping("/download-pdf")
	    public void downloadPDFResource(HttpServletResponse response) {
	        try {
	            Path file = Paths.get(estoquePdfGerar.generatePdf().getAbsolutePath());
	            if (Files.exists(file)) {
	                response.setContentType("application/pdf");
	                response.addHeader("Content-Disposition",
	                        "attachment; filename=" + file.getFileName());
	                Files.copy(file, response.getOutputStream());
	                response.getOutputStream().flush();
	            }
	        } catch (DocumentException | IOException ex) {
	            ex.printStackTrace();
	        }
	    }


	
}
