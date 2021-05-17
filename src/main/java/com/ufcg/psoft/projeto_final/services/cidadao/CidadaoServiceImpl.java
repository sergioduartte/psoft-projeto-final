package com.ufcg.psoft.projeto_final.services.cidadao;

import com.ufcg.psoft.projeto_final.DTOs.*;
import com.ufcg.psoft.projeto_final.models.*;
import com.ufcg.psoft.projeto_final.errors.*;
import com.ufcg.psoft.projeto_final.exceptions.CadastroCidadaoException;
import com.ufcg.psoft.projeto_final.exceptions.CidadaoNaoEncontradoException;
import com.ufcg.psoft.projeto_final.repositories.*;

import com.ufcg.psoft.projeto_final.services.login.LoginService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CidadaoServiceImpl implements CidadaoService {
	
	@Autowired
    CidadaoRepository cidadaoRepository;

    @Autowired
    LoginService loginService;

    @Override
    public Cidadao saveCidadao (CidadaoDTO cidadaoDTO) throws CidadaoCadastroInvalido {
        Date dataNascimento;
        Cidadao novoCidadao;

        try {
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(cidadaoDTO.getDataNascimento());
        } catch (ParseException e) {
            throw new CidadaoCadastroInvalido("Data nao esta no formato \"dd/MM/yyyy\"." );
        }

        try {
            novoCidadao = new Cidadao(cidadaoDTO.getNomeCompleto(), cidadaoDTO.getEndereco(),
                    cidadaoDTO.getCpf(), cidadaoDTO.getCartaoSus(), cidadaoDTO.getEmail(), dataNascimento,
                    cidadaoDTO.getTelefone(), cidadaoDTO.getProfissao(), cidadaoDTO.getComorbidades(), cidadaoDTO.getSenha());
        } catch (CadastroCidadaoException e) {
            throw new CidadaoCadastroInvalido(e.getMessage());
        }

        try {
            cidadaoRepository.save(novoCidadao);
            loginService.criaLogin(novoCidadao.getCpf(), novoCidadao.getSenha(), "CIDADAO");
        } catch (Exception e){
            throw new CidadaoCadastroInvalido(e.getMessage());
        }

        return novoCidadao;
    }


    @Override
    public Cidadao getCidadao(Long cpf) throws CidadaoNaoEncontradoException {
        Cidadao cidadao = cidadaoRepository.findById(cpf).get();
        if( cidadao == null){
            throw new CidadaoNaoEncontradoException("");
        }
        return cidadao;
    }

    @Override
    public Cidadao atualizaCadastro(AtualizaCidadaoDTO atualizaCidadaoDTO) throws CidadaoNaoEncontradoException, CadastroCidadaoException {

        Cidadao cidadaoAtualizado = this.getCidadao(atualizaCidadaoDTO.getCPF());
        validaAtualizacao(atualizaCidadaoDTO);
        cidadaoAtualizado.setProfissao(atualizaCidadaoDTO.getProfissao());
        cidadaoAtualizado.setNome(atualizaCidadaoDTO.getNomeCompleto());
        cidadaoAtualizado.setEndereco(atualizaCidadaoDTO.getEndereco());
        cidadaoAtualizado.setTelefone(atualizaCidadaoDTO.getTelefone());
        cidadaoAtualizado.setComorbidades(atualizaCidadaoDTO.getComorbidades());

        cidadaoRepository.save(cidadaoAtualizado);

        return cidadaoAtualizado;
    }

    private void validaAtualizacao(AtualizaCidadaoDTO atualizaCidadaoDTO) throws CadastroCidadaoException {
        // TODO nome nao pode ser vazio ou menor que 4 letras
        if (atualizaCidadaoDTO.getNomeCompleto().length() < 5 || atualizaCidadaoDTO.getNomeCompleto().trim().isEmpty()) {
            throw new CadastroCidadaoException ("Novo nome do Cidadao nao pode ter menos de 5 caracteres.");
        }
        // TODO endereco nao pode ser vazio
        if (atualizaCidadaoDTO.getEndereco().trim().isEmpty()){
            throw new CadastroCidadaoException ("Novo endereco nao pode ser vazio.");
        }
        // TODO padrao <palavra><numero><.%+->@<palavra><numero><.->.<palavraDeTamanho2a6>
        Pattern p = Pattern.compile("[\\w\\d_\\.%\\+-]+@[\\w\\d\\.-]+\\.[\\w]{2,6}");
        Matcher m = p.matcher(atualizaCidadaoDTO.getEmail());
        if (!m.matches()) {
            throw new CadastroCidadaoException( "Novo email do cidadao nao esta no formato fulano@email.dominio");
        }
        // TODO checar se nao nasceu depois de hoje
        Date hoje = java.util.Calendar.getInstance().getTime();

        // TODO telefone tem de ter 11 digitos// TODO cartaoSus tem de ter 15 digitos
        if (atualizaCidadaoDTO.getTelefone().length() < 11) {
            throw new CadastroCidadaoException ("O novo numero do Telefone esta fora do formato \"83999998888\".");
        }
        // TODO profissao nao pode ser vazio
        if (atualizaCidadaoDTO.getProfissao().trim().isEmpty()){
            throw new CadastroCidadaoException ("Nova profissao nao pode ser vazia.");
        }
        // TODO comorbidades pode ser vazio, não nulo
        if (atualizaCidadaoDTO.getComorbidades() == null) {
            throw new CadastroCidadaoException ("Comorbidades nao pode ser nula.");
        }
    }
}