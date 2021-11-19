package br.edu.ifms.ordemservico.dto;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import br.edu.ifms.ordemservico.entities.OrdemDeServico;
import br.edu.ifms.ordemservico.entities.Servidor;
import br.edu.ifms.ordemservico.entities.enums.Prioridade;
import br.edu.ifms.ordemservico.entities.enums.Status;

public class OrdemDeServicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "O campo equipamento é obrigatório")
	private String equipamento;
	@NotBlank(message = "O campo patrimonio é obrigatório")
	private String patrimonio;
	@NotBlank(message = "O campo setor é obrigatório")
	private String setor;
	@NotBlank(message = "O campo descrição do problema é obrigatório")
	private String descricaoPoblema;
	@FutureOrPresent(message = "A data nao pode ser anterior a data atual")
	private Date dataCadastro;
	private Status status;
	private Prioridade prioridade;
	@NotBlank(message = "O campo é obrigatório")
	private String descricaoSolucao;
	@NotBlank(message = "O campo é obrigatório")
	private Servidor servidor;
	
	public OrdemDeServicoDTO() {	}

	public OrdemDeServicoDTO(Long id, String equipamento, String patrimonio, String setor, String descricaoPoblema,
			Date dataCadastro, Status status, Prioridade prioridade, String descricaoSolucao, Servidor servidor) {
		this.id = id;
		this.equipamento = equipamento;
		this.patrimonio = patrimonio;
		this.setor = setor;
		this.descricaoPoblema = descricaoPoblema;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.prioridade = prioridade;
		this.descricaoSolucao = descricaoSolucao;
		this.servidor = servidor;
	}
	
	public OrdemDeServicoDTO(OrdemDeServico ordem) {
		this.id = ordem.getId();
		this.equipamento = ordem.getEquipamento();
		this.patrimonio = ordem.getPatrimonio();
		this.setor = ordem.getSetor();
		this.descricaoPoblema = ordem.getDescricaoPoblema();
		this.dataCadastro = ordem.getDataCadastro();
		this.status = ordem.getStatus();
		this.prioridade = ordem.getPrioridade();
		this.descricaoSolucao = ordem.getDescricaoSolucao();
		this.servidor = ordem.getServidor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getDescricaoPoblema() {
		return descricaoPoblema;
	}

	public void setDescricaoPoblema(String descricaoPoblema) {
		this.descricaoPoblema = descricaoPoblema;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public String getDescricaoSolucao() {
		return descricaoSolucao;
	}

	public void setDescricaoSolucao(String descricaoSolucao) {
		this.descricaoSolucao = descricaoSolucao;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	

	
}
