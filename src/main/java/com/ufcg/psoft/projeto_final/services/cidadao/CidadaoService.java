package com.ufcg.psoft.projeto_final.services.cidadao;

import com.ufcg.psoft.projeto_final.DTOs.AtualizaCidadaoDTO;
import com.ufcg.psoft.projeto_final.DTOs.CidadaoDTO;
import com.ufcg.psoft.projeto_final.errors.CidadaoCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.exceptions.CadastroCidadaoException;
import com.ufcg.psoft.projeto_final.exceptions.CidadaoNaoEncontradoException;
import com.ufcg.psoft.projeto_final.exceptions.NaoAutorizadoException;
import com.ufcg.psoft.projeto_final.models.Cidadao;
import com.ufcg.psoft.projeto_final.models.situacoes.EnumSituacoes;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;


@Service
public interface CidadaoService {

    Cidadao saveCidadao(CidadaoDTO cidadaoDTO) throws LoginTipoInvalido, CidadaoCadastroInvalido;

    Cidadao getCidadao(Long cpf) throws CidadaoNaoEncontradoException;

    Cidadao atualizaCadastro(AtualizaCidadaoDTO atualizaCidadaoDTO, HttpHeaders headers) throws CidadaoNaoEncontradoException, CadastroCidadaoException, NaoAutorizadoException, CidadaoCadastroInvalido;

    EnumSituacoes getSituacao(Long cpf, HttpHeaders headers) throws CidadaoNaoEncontradoException, NaoAutorizadoException, CidadaoCadastroInvalido;

    void notificaAptoParaVacina(Long id);

    boolean usuarioTemPermissao(HttpHeaders headers, Long cpf) throws CidadaoCadastroInvalido, CidadaoNaoEncontradoException;
}