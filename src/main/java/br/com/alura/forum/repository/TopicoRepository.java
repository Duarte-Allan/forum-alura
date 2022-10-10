package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	
	
	/**
	 * 
	 * Filtra por nome do curso - Método Default
	 * @param nomeCurso
	 * @return
	 */
	List<Topico> findByCursoNome(String nomeCurso); //Relaciona os objetos Curso e Nome.
	
	/**
	 * 
	 * Filtra por nome do curso - Se existir atributo igual ao relacionamento dos objetos, utilizar "_" para separar e não gerar ambiguidade.
	 * @param nomeCurso
	 * @return
	 */
	List<Topico> findByCurso_Nome(String nomeCurso);
	
	/**
	 * 
	 * Filtra por nome do curso - Quando é necessário criar o nome do método, deve ser feito a query jtpql
	 * @param nomeCurso
	 * @return
	 */
	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso); 
}
