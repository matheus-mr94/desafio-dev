package br.com.bycoders.services;

import java.io.InputStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bycoders.enums.TipoTransacao;
import br.com.bycoders.models.Loja;
import br.com.bycoders.models.Operacao;
import br.com.bycoders.repositories.LojaRepository;
import br.com.bycoders.repositories.OperacaoRepository;

@Service
public class EntradaArquivoService {

	@Autowired
	OperacaoRepository operacaoRepository;

	@Autowired
	LojaRepository lojaRepository;
	
	@Autowired
	OperacaoService operacaoService;

	public void LeituraArquivos(InputStream path) throws ParseException {
		List<Operacao> listaOperacoes = new ArrayList<>();
		Scanner sc = new Scanner(path);
		while (sc.hasNext()) {
			Operacao operacao = new Operacao();
			Loja loja = new Loja();

			String[] line = sc.nextLine().split(";");
			String col1 = line[0];
			String col2 = line[1];
			String col3 = line[2];
			String col4 = line[3];
			String col5 = line[4];
			String col6 = line[5];
			String col7 = line[6];
			String col8 = line[7];
			
			if (col1.equals("1")) {
				operacao.setTipoTransacao(TipoTransacao.DEBITO);
			} else if (col1.equals("2")) {
				operacao.setTipoTransacao(TipoTransacao.BOLETO);
			} else if (col1.equals("3")) {
				operacao.setTipoTransacao(TipoTransacao.FINANCIAMENTO);
			} else if (col1.equals("4")) {
				operacao.setTipoTransacao(TipoTransacao.CREDITO);
			} else if (col1.equals("5")) {
				operacao.setTipoTransacao(TipoTransacao.RECEBIMENTO_EMPRESTIMO);
			} else if (col1.equals("6")) {
				operacao.setTipoTransacao(TipoTransacao.VENDAS);
			} else if (col1.equals("7")) {
				operacao.setTipoTransacao(TipoTransacao.RECEBIMENTO_TED);
			} else if (col1.equals("8")) {
				operacao.setTipoTransacao(TipoTransacao.RECEBIMENTO_DOC);
			} else if (col1.equals("9")) {
				operacao.setTipoTransacao(TipoTransacao.ALUGUEL);
			}

			String ano = col2.substring(0, 4);
			String mes = col2.substring(4, 6);
			String dia = col2.substring(6, 8);
			String data = ano + "-" + mes + "-" + dia;

			operacao.setData(LocalDate.parse(data));
			Double valor = Double.parseDouble(col3) / 100;
			operacao.setValor(valor);
			operacao.setCartao(col5);

			String hora = col6.substring(0, 2);
			String min = col6.substring(2, 4);
			String segundos = col6.substring(4, 6);
			String horaFormatada = hora + ":" + min + ":" + segundos;
			operacao.setHora(horaFormatada);

			if (!lojaRepository.findByCpfBeneficiario(col4).isPresent()) {
				loja.setCpfBeneficiario(col4);
				loja.setNomeDono(col7);
				loja.setNomeLoja(col8);
			}
			if(loja.getCpfBeneficiario() != null) {
				lojaRepository.save(loja);
				operacao.setLoja(loja);	
			}
		
			listaOperacoes.add(operacao);

		}
		sc.close();
		operacaoRepository.saveAll(listaOperacoes);
	}

}
