package br.edu.ifms.ordemservico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.ordemservico.dto.OrdemDeServicoDTO;
import br.edu.ifms.ordemservico.entities.OrdemDeServico;
import br.edu.ifms.ordemservico.repositories.OrdemDeServicoRepository;
import br.edu.ifms.ordemservico.services.exceptions.DataBaseException;
import br.edu.ifms.ordemservico.services.exceptions.ResourceNotFoundException;


@Service
public class OrdemDeServicoService {

	@Autowired
	private OrdemDeServicoRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrdemDeServicoDTO> findAll(){
		List<OrdemDeServico> list = repository.findAll();
		return list.stream().map(OrdemDeServico -> new OrdemDeServicoDTO(OrdemDeServico)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public OrdemDeServicoDTO findById(Long id){
		Optional<OrdemDeServico> obj = repository.findById(id);
		OrdemDeServico ordem = obj.orElseThrow(() -> new ResourceNotFoundException("Ordem de Serviço solicitada não foi Localizada"));
		return new OrdemDeServicoDTO(ordem);
	}
	
	@Transactional
	public OrdemDeServicoDTO insert(OrdemDeServicoDTO dto) {
		OrdemDeServico ordem = new OrdemDeServico();
		copyDtoToEntity(dto, ordem);
		ordem = repository.save(ordem);
		return new OrdemDeServicoDTO(ordem);
	}
	
	@Transactional
	public OrdemDeServicoDTO update( Long id, OrdemDeServicoDTO dto) {
		try {
			OrdemDeServico ordem = repository.getById(id);
			copyDtoToEntity(dto, ordem);
			ordem = repository.save(ordem);
			return new OrdemDeServicoDTO(ordem);
			
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("o Id da ordem de serviço nao foi localizado");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException exception) {
			throw new ResourceNotFoundException("Não foi possivel excluir, o Id da ordem de serviço nao foi localizado");
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Nao foi possivel Excluir a ordem de serviço, pois o mesmo esta em uso.");
		}
		
	}

	private void copyDtoToEntity(OrdemDeServicoDTO dto, OrdemDeServico ordemDeServico) {
		
		ordemDeServico.setEquipamento(dto.getEquipamento());
		ordemDeServico.setPatrimonio(dto.getPatrimonio());
		ordemDeServico.setSetor(dto.getSetor());
		ordemDeServico.setDescricaoPoblema(dto.getDescricaoPoblema());
		ordemDeServico.setDataCadastro(dto.getDataCadastro());
		ordemDeServico.setStatus(dto.getStatus());
		ordemDeServico.setPrioridade(dto.getPrioridade());
		ordemDeServico.setDescricaoSolucao(dto.getDescricaoPoblema());
		ordemDeServico.setServidor(dto.getServidor());
		
	}

	
	
}
