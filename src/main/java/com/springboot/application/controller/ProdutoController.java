package com.springboot.application.controller;

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
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.springboot.application.model.Estoque;
import com.springboot.application.model.Produto;
import com.springboot.application.model.Usuario;
import com.springboot.application.repository.EstoqueRepository;
import com.springboot.application.repository.ProdutoRepository;
import com.springboot.application.service.ProdutoService;

@Controller
public class ProdutoController {
	
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EstoqueRepository estoqueRepository;
	
	
	
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}

	@GetMapping("/cadastro/produto")
	public ModelAndView retornaCadastroProduto(Produto produto) {
		ModelAndView mv = new ModelAndView("cadastro/cadastro_produto");
		mv.addObject("produtos", produto);
		
		List<String> listaDeCategoria = Arrays.asList("Selecione..", "Outros" ,"Alimentos","Limpeza", "Liquidos","Tecidos","Fitas");
		mv.addObject("listaCategoria", listaDeCategoria );
		
//		List<String> listaDeEstoque = Arrays.asList("Estoque 1","Estoque 2", "Estoque 3", "Estoque 4", "Estoque 5");
//		mv.addObject("listaEstoque", listaDeEstoque);
		
		
		
		List<Estoque> estoque = estoqueRepository.findAll();
		//List<Estoque> estoque = new ArrayList();
		
		mv.addObject("listaEstoque", estoque);
		
		//produtoRepository.save(produto);
		
		return mv;
	}
	
//	@PostMapping("/cadastro/produto")
//	public String cadastroDeProdutoSucesso(@ModelAttribute("produtos") Produto produto) {
//		//produtoService.salvarProduto(produto);
//		return "produto_cadastrado_com_sucesso";
//	}
	
	@GetMapping("/cadastro/produto/listar")
	public ModelAndView listarProduto() {
		ModelAndView mv = new ModelAndView("lista/listar_produto");
		mv.addObject("listaProdutos", produtoRepository.findAll());
		return mv;
	}
	
	@GetMapping("/cadastro/produto/editar/{id}")
	public ModelAndView editarProduto(@PathVariable("id") Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return retornaCadastroProduto(produto.get());
	}
	
	
	@GetMapping("/cadastro/produto/remover/{id}")
	public ModelAndView removerProduto(@PathVariable("id") Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		produtoRepository.delete(produto.get());
		return listarProduto();
		
	}
	
//	@RequestMapping(value = "/estoque/status", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody String retornaGrafico() {
//		List<Estoque> listaEstoque = estoqueRepository.findAll();
//		
//		Gson gson =  new GsonBuilder().setPrettyPrinting().create();		
//		System.out.println(gson.toJson(listaEstoque));
//		
//		return gson.toJson(listaEstoque);
//	}
	
	@PostMapping("/cadastro/produto/salvar")
	public ModelAndView salvarProduto(@Valid Produto produto, BindingResult result) {
		if(result.hasErrors()) {
			return retornaCadastroProduto(produto);
		}
		produtoRepository.saveAndFlush(produto);
		
		
		return retornaCadastroProduto(new Produto());
	}
	
	
	
	
	@PostMapping("**/buscarPorNomeProduto") //aqui faz a busca pelo nome
	public ModelAndView buscarPorNomeProduto(@RequestParam("nome") String nome){
		ModelAndView mv = new ModelAndView("listar_produto");
		mv.addObject("listaProdutos", produtoRepository.buscarPorNome(nome));
		mv.addObject("produtoObjeto", new Produto());
		return mv;
	}
	
	
	@GetMapping("/produto/exportarCsv")
    public void exportCSV(HttpServletResponse response) throws Exception {

        // set file name and content type
        String filename = "produto.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, 
                   "attachment; filename=\"" + filename + "\"");

        // create a csv writer
        StatefulBeanToCsv<Produto> writer = new StatefulBeanToCsvBuilder
                    <Produto>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).
                        withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false).build();

        // write all employees to csv file
        writer.write(produtoRepository.findAll());
	}
	
}
